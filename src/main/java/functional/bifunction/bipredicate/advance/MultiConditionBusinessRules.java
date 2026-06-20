package functional.bifunction.bipredicate.advance;

import java.util.function.BiPredicate;

class LoanApplication {
    double annualIncome;
    int creditScore;
    public LoanApplication(double income, int score) { annualIncome = income; creditScore = score; }
}

class BankPolicy {
    double minIncome;
    int minCreditScore;
    public BankPolicy(double income, int score) { minIncome = income; minCreditScore = score; }
}

public class MultiConditionBusinessRules {
    public static void main(String[] args) {
        // Problem 15: Implement multi-condition business rules.
        
        // Rule for standard loan approval
        BiPredicate<LoanApplication, BankPolicy> standardApproval = (app, policy) ->
                app.annualIncome >= policy.minIncome && app.creditScore >= policy.minCreditScore;

        // Rule for special consideration (e.g., high income but lower credit score)
        BiPredicate<LoanApplication, BankPolicy> specialConsideration = (app, policy) ->
                app.annualIncome >= policy.minIncome * 2 && app.creditScore >= policy.minCreditScore - 50;

        // The final rule: approve if standard OR special consideration is met.
        BiPredicate<LoanApplication, BankPolicy> finalApprovalRule = standardApproval.or(specialConsideration);

        BankPolicy policy = new BankPolicy(50000, 650);
        LoanApplication app1 = new LoanApplication(60000, 700); // Standard approval
        LoanApplication app2 = new LoanApplication(40000, 720); // Denied (low income)
        LoanApplication app3 = new LoanApplication(120000, 620); // Approved (special consideration)

        System.out.println("App1 approved? " + finalApprovalRule.test(app1, policy));
        System.out.println("App2 approved? " + finalApprovalRule.test(app2, policy));
        System.out.println("App3 approved? " + finalApprovalRule.test(app3, policy));
    }
}
