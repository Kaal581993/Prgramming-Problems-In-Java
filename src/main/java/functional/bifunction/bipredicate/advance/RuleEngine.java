package functional.bifunction.bipredicate.advance;

import java.util.function.BiPredicate;

class Transaction {
    double amount;
    String countryCode;
    public Transaction(double amount, String country) { this.amount = amount; this.countryCode = country; }
}

class FraudPolicy {
    double maxAmount;
    String restrictedCountry;
    public FraudPolicy(double max, String restricted) { maxAmount = max; restrictedCountry = restricted; }
}

public class RuleEngine {
    public static void main(String[] args) {
        // Problem 11: Build rule engine using BiPredicate chaining.
        
        // Rule 1: Amount must not exceed the policy's max amount.
        BiPredicate<Transaction, FraudPolicy> amountRule = (tx, policy) -> tx.amount <= policy.maxAmount;
        
        // Rule 2: Transaction country must not be on the restricted list.
        BiPredicate<Transaction, FraudPolicy> countryRule = (tx, policy) -> !tx.countryCode.equals(policy.restrictedCountry);
        
        // Combine rules: a transaction is valid if both amount and country rules pass.
        BiPredicate<Transaction, FraudPolicy> fraudCheck = amountRule.and(countryRule);

        FraudPolicy policy = new FraudPolicy(1000.0, "XYZ");
        Transaction tx1 = new Transaction(500.0, "USA");
        Transaction tx2 = new Transaction(1500.0, "USA");
        Transaction tx3 = new Transaction(500.0, "XYZ");

        System.out.println("Tx1 is valid? " + fraudCheck.test(tx1, policy)); // true
        System.out.println("Tx2 is valid? " + fraudCheck.test(tx2, policy)); // false (amount too high)
        System.out.println("Tx3 is valid? " + fraudCheck.test(tx3, policy)); // false (restricted country)
    }
}
