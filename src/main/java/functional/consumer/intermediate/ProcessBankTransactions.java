package functional.consumer.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Transaction {
    String type;
    double amount;
    public Transaction(String type, double amount) { this.type = type; this.amount = amount; }
    @Override public String toString() { return "Transaction{" + type + ", $" + amount + '}'; }
}

public class ProcessBankTransactions {

    // Consumer to process a deposit
    public static final Consumer<Transaction> DEPOSIT_PROCESSOR = tx ->
            System.out.println("Processing deposit of $" + tx.amount);

    // Consumer to process a withdrawal
    public static final Consumer<Transaction> WITHDRAWAL_PROCESSOR = tx ->
            System.out.println("Processing withdrawal of $" + tx.amount);

    public static void main(String[] args) {
        // Problem 7: Process bank transactions.
        List<Transaction> transactions = Arrays.asList(
                new Transaction("DEPOSIT", 1000),
                new Transaction("WITHDRAWAL", 200),
                new Transaction("DEPOSIT", 500)
        );

        // A generic processor that delegates to the correct specific processor
        Consumer<Transaction> transactionRouter = tx -> {
            if ("DEPOSIT".equals(tx.type)) {
                DEPOSIT_PROCESSOR.accept(tx);
            } else if ("WITHDRAWAL".equals(tx.type)) {
                WITHDRAWAL_PROCESSOR.accept(tx);
            }
        };

        transactions.forEach(transactionRouter);
    }
}
