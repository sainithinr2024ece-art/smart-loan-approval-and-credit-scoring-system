package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit_scores")
public class CreditScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer score;

    @Column(name = "calculation_date")
    private LocalDateTime calculationDate;

    private String riskCategory; // EXCELLENT, GOOD, FAIR, POOR

    // Constructors
    public CreditScore() {
        this.calculationDate = LocalDateTime.now();
    }

    public CreditScore(User user, Integer score) {
        this.user = user;
        this.score = score;
        this.calculationDate = LocalDateTime.now();
        this.riskCategory = calculateRiskCategory(score);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
        this.riskCategory = calculateRiskCategory(score);
    }

    public LocalDateTime getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(LocalDateTime calculationDate) {
        this.calculationDate = calculationDate;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    // Helper method
    private String calculateRiskCategory(Integer score) {
        if (score >= 750) return "EXCELLENT";
        if (score >= 700) return "VERY_GOOD";
        if (score >= 650) return "GOOD";
        if (score >= 600) return "FAIR";
        return "POOR";
    }
}