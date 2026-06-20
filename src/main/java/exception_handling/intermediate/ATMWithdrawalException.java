package exception_handling.intermediate;

public class ATMWithdrawalException {
    public static void main(String[] args) {
        double balance= 4500;

        double withDrawalAmount = 5500;


        try {
            double remainingBalance = balanceAfterWithdrawal(
                    balance, withDrawalAmount
            );
            System.out.println(
                    "Withdrawal successful! Remaining balance: " +
                            "" + remainingBalance);
        }  catch(InsufficientFundsException ife){
            System.err.println("Transaction Failed: " + ife.getMessage());

        }
    }


    public static double balanceAfterWithdrawal(
            double balance,
            double withDrawalAmount) throws InsufficientFundsException{

        if (withDrawalAmount > balance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw the amount due to Insufficient Balance"
            );
    }

        return balance - withDrawalAmount;


}
}

 class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}
