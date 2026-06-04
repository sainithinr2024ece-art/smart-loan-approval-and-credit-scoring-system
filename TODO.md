# TODO List for Rectifying Errors in Smart Loan Approval and Credit Scoring Application

## Tasks to Complete
- [x] Update `CreditScore.java`: Change field from `rating` to `riskCategory`, rename method to `calculateRiskCategory`, and align thresholds with `CreditScoringService.java`.
- [x] Update `CreditScoringService.java`: Change `setRiskCategory` to `setRiskCategory` (after entity update), add `UserRepository` injection, and update `user.setCreditScore()` after calculation.
- [x] Update `LoanController.java`: Change return value in `showApplyForm` to "apply-loan-step1".
- [x] Update `HomeController.java`: Remove the `/register` mapping since no template exists.
- [x] Update `LoanApplication.java`: Add `@ManyToOne User user;` relationship.
- [x] Update `UserRepository.java`: Add `Optional<User> findByEmail(String email);`.

## Followup Steps
- [x] Verify all changes compile without errors.
- [x] Change Java version from 21 to 17 in build.gradle to resolve compilation issues.
