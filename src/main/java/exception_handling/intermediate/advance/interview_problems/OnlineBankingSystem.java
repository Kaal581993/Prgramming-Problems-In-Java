package exception_handling.intermediate.advance.interview_problems;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OnlineBankingSystem {

    private static final Map<String, Long> userAccounts = new HashMap<>();

    public static void main(String[] args) throws
            NegativeAmountException,
            InvalidAccountException,
            InSufficientBalance, IOException {

        Long depositAmount;
        Long withDrawalAmount;
        Long transferAmount;
        String accnum;

        // 1. Populate the map with 10 entries
        for (int i = 1; i <= 10; i++) {
            String accountNumber = String.format("ACC%03d", i); // e.g., ACC001, ACC002...
            long initialBalance = i * 10000L;                    // e.g., 1000, 2000...
            userAccounts.put(accountNumber, initialBalance);

        }
        // 2. Print all accounts
        System.out.println("--- Current Bank Accounts ---");
        userAccounts.forEach((accountNo, balance) ->
                System.out.println("Account: " + accountNo + " | Balance: $" + balance)
        );

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your option: \n 1. Deposit \n 2. Withdraw \n 3. Transfer");
        int choice = scan.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    System.out.println("Enter the account number \n");
                    accnum = scan.next();
                    System.out.println("Enter the Deposit amount \n");
                    depositAmount = scan.nextLong();

                    deposit(accnum, depositAmount);

                    // 2. Print all accounts
                    System.out.println("--- Current Bank Accounts ---");
                    userAccounts.forEach((accountNo, balance) ->
                            System.out.println("Account: " + accountNo + " | Balance: $" + balance)
                    );
                    break;
                case 2:
                    System.out.println("Enter the account number \n");
                    accnum = scan.next();
                    System.out.println("Enter the Withdrawal amount \n");
                    withDrawalAmount = scan.nextLong();

                    withdraw(accnum, withDrawalAmount);

                    // 2. Print all accounts
                    System.out.println("--- Current Bank Accounts ---");
                    userAccounts.forEach((accountNo, balance) ->
                            System.out.println("Account: " + accountNo + " | Balance: $" + balance)
                    );
                    break;
                case 3:
                    System.out.println("Enter the account number to transfer funds from \n");
                    accnum = scan.next();
                    System.out.println("Enter the account number to reeive funds \n");
                    String accnum2 = scan.next();
                    System.out.println("Enter the Withdrawal amount \n");
                    transferAmount = scan.nextLong();

                    transfer(accnum, accnum2, transferAmount);

                    // 2. Print all accounts
                    System.out.println("--- Current Bank Accounts ---");
                    userAccounts.forEach((accountNo, balance) ->
                            System.out.println("Account: " + accountNo + " | Balance: $" + balance)
                    );
                    break;
                default:
                    break;
            }
        }

    }

    // Deposit: updates a single account
    public static void deposit(String accountNumber, long depositAmount)
            throws InvalidAccountException,
            NegativeAmountException {

        if (depositAmount < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }

        if (!userAccounts.containsKey(accountNumber)) {
            throw new InvalidAccountException("Account " + accountNumber + " does not exist");
        }
        // Update only the targeted entry in-place
        userAccounts.put(accountNumber, userAccounts.get(accountNumber) + depositAmount);
    }

    // Withdraw: checks balance and updates a single account
    public static void withdraw(String accountNumber, long withdrawalAmount)
            throws InvalidAccountException,
            NegativeAmountException,
            InSufficientBalance {

        if (withdrawalAmount < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }

        if (!userAccounts.containsKey(accountNumber)) {
            throw new InvalidAccountException("Account " + accountNumber + " does not exist");
        }
        long currentBalance = userAccounts.get(accountNumber);
        if (currentBalance < withdrawalAmount) {
            throw new InSufficientBalance("Not enough Balance");
        }
        userAccounts.put(accountNumber, currentBalance - withdrawalAmount);
    }

    // Transfer: updates both source and destination accounts
    public static void transfer(String fromAccount, String toAccount, long transferAmount)
            throws InvalidAccountException,
            NegativeAmountException,
            InSufficientBalance {

        if (transferAmount < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }

        if (!userAccounts.containsKey(fromAccount)) {
            throw new InvalidAccountException("Source account " + fromAccount + " does not exist");
        }

        if (!userAccounts.containsKey(toAccount)) {
            throw new InvalidAccountException("Destination account " + toAccount + " does not exist");
        }
        long fromBalance = userAccounts.get(fromAccount);
        if (fromBalance < transferAmount) {
            throw new InSufficientBalance("Not enough Balance");
        }
        // Perform the transfer
        userAccounts.put(fromAccount, fromBalance - transferAmount);
        userAccounts.put(toAccount, userAccounts.get(toAccount) + transferAmount);
    }


}

class InSufficientBalance extends Exception{
    public InSufficientBalance(String message){
        super(message);
    }
}

class InvalidAccountException extends Exception{
    public InvalidAccountException(String message){
        super(message);
    }
}

class NegativeAmountException extends Exception{
    public NegativeAmountException(String message){
        super(message);
    }
}