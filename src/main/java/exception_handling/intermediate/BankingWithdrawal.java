//package exception_handling.intermediate;
//
//public class BankingWithdrawal {
//
//    public static void main(String[] args) {
//        long Balance = 5000;
//        long withDrawalAmt = 7500;
//
//        BalanceAfterWithDrawal(Balance, withDrawalAmt);
//    }
//
//    private static long BalanceAfterWithDrawal(long balance, long withDrawalAmt) {
//
//    try{
//        return balance-withDrawalAmt;
//    }catch (Exception e){
//        System.out.println("Cannot withdraw the amount due to Insuffiient Balancce");
//        throw new RuntimeException("Cannot withdraw the amount due to Insuffiient Balancce");
//
//    }
//    }
//}


package exception_handling.intermediate;

public class BankingWithdrawal {

    public static void main(String[] args) {
        long balance = 5000;
        long withdrawalAmt = 7500;

        try {
            long remainingBalance = balanceAfterWithdrawal(
                    balance, withdrawalAmt
            );
            System.out.println(
                    "Withdrawal successful! Remaining balance: " +
                    "" + remainingBalance);
        } catch (IllegalArgumentException e) {
            // Handle the exception gracefully in main
            System.err.println("Transaction Failed: " + e.getMessage());
        }
    }

    private static long balanceAfterWithdrawal(
            long balance, long withdrawalAmt
        ) {
        // Explicitly check the business rule constraint
        if (withdrawalAmt > balance) {
            throw new IllegalArgumentException(
                    "Cannot withdraw the amount due to Insufficient Balance"
            );
        }

        return balance - withdrawalAmt;
    }
}