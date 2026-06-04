package com.example.demo.service;

import com.example.demo.entity.CreditScore;
import com.example.demo.entity.LoanApplication;
import com.example.demo.entity.User;
import com.example.demo.repository.CreditScoreRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class CreditScoringService {

    @Autowired
    private CreditScoreRepository creditScoreRepository;

    @Autowired
    private UserRepository userRepository;

    private final Random random = new Random();

    public CreditScore calculateCreditScore(User user, LoanApplication application) {
        // Simple credit scoring logic
        int baseScore = 600 + random.nextInt(100);
        String riskCategory = determineRiskCategory(baseScore);

        CreditScore creditScore = new CreditScore();
        creditScore.setUser(user);
        creditScore.setScore(baseScore);
        creditScore.setRiskCategory(riskCategory);

        // Update user's credit score
        user.setCreditScore(baseScore);
        userRepository.save(user);

        return creditScoreRepository.save(creditScore);
    }

    private String determineRiskCategory(int score) {
        if (score >= 750) return "EXCELLENT";
        if (score >= 700) return "VERY_GOOD";
        if (score >= 650) return "GOOD";
        if (score >= 600) return "FAIR";
        return "POOR";
    }
}