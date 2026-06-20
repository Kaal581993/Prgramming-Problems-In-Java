package exception_handling.intermediate;

public class ProductStockValidation {
    public static void main(String[] args) {
        int stockCount=0;

        try{
            stockValidation(stockCount);
        }catch (OutOfStockException ose){
            System.err.println("Transaction Failed: " + ose.getMessage());

        }
    }

    public static void stockValidation(int stockCount) throws OutOfStockException{
        if(stockCount<=0){
            throw new OutOfStockException("No item found in Stock");
        }
    }
}


class OutOfStockException extends Exception{
    public OutOfStockException(String message){
        super(message);
    }
}
