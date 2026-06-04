package com.example.demo.service;

import com.example.demo.entity.LoanApplication;
import com.example.demo.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public LoanApplication createApplication(LoanApplication application) {
        application.setAppliedDate(LocalDateTime.now());
        return loanApplicationRepository.save(application);
    }

    public List<LoanApplication> getAllApplications() {
        return loanApplicationRepository.findAll();
    }

    public LoanApplication getApplicationById(Long id) {
        return loanApplicationRepository.findById(id).orElse(null);
    }
}