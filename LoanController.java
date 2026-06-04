package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/apply")
    public String showApplyForm(Model model) {
        return "apply-loan-step1";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "application-success";
    }

    @GetMapping("/applications")
    public String viewApplications() {
        return "my-applications";
    }
}