//package exception_handling.intermediate.advance.interview_problems;
//
//import java.util.*;
//import java.util.function.Consumer;
//
//class Product {
//    int id;
//    String name;
//    int quantity;
//    double price;
//
//    public Product(int id, String name, int quantity, double price) {
//        this.id = id;
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
//    }
//}
//
//class Order {
//    int orderId;
//    Product product;
//    String status; // e.g., "PLACED", "CANCELLED", "RETURNED"
//
//    public Order(int orderId, Product product) {
//        this.orderId = orderId;
//        this.product = product;
//        this.status = "PLACED";
//    }
//
//    @Override
//    public String toString() {
//        return "Order ID: " + orderId + ", Product: " + product.name + ", Status: " + status;
//    }
//}
//
//public class ECommerceOrderingSystem {
//
//    static Map<Integer, Product> products = new HashMap<>();
//    static Map<Integer, Order> orders = new HashMap<>();
//
//    static {
//        products.put(1, new Product(1, "iPhone 16 Pro", 34, 1299.99));
//        products.put(2, new Product(2, "POCO X6 Pro", 4, 349.99));
//        products.put(3, new Product(3, "Macbook Pro", 24, 2499.99));
//        products.put(4, new Product(4, "Starlabs Laptop", 84, 1999.00));
//        products.put(5, new Product(5, "Lenovo Laptop", 54, 999.50));
//    }
//
//    public static void main(String[] args) {
//        System.out.println("--- Welcome to the E-Commerce Ordering System ---");
//
//        try (Scanner scan = new Scanner(System.in)) {
//            while (true) {
//                System.out.println("\nChoose an option:");
//                System.out.println("1. Place Order");
//                System.out.println("2. Cancel Order");
//                System.out.println("3. Return Order");
//                System.out.println("4. Exit");
//
//                int choice = scan.nextInt();
//
//                switch (choice) {
//                    case 1:
//                        placeOrder(scan);
//                        break;
//                    case 2:
//                        cancelOrder(scan);
//                        break;
//                    case 3:
//                        returnOrder(scan);
//                        break;
//                    case 4:
//                        System.out.println("Thank you for using the system.");
//                        return;
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("An error occurred: " + e.getMessage());
//        }
//    }
//
//    private static void placeOrder(Scanner scan) {
//        System.out.println("\n--- Available Products ---");
//        products.values().forEach(System.out::println);
//
//        System.out.print("Enter the product ID to order: ");
//        int productId = scan.nextInt();
//
//        Product selectedProduct = products.get(productId);
//
//        if (selectedProduct == null) {
//            throw new InvalidOrderException("Product with ID " + productId + " not found.");
//        }
//
//        if (selectedProduct.quantity <= 0) {
//            throw new OutOfStockException("Product is out of stock: " + selectedProduct.name);
//        }
//
//        // --- Payment Handling ---
//        System.out.printf("The price of the product is $%.2f. Proceed with payment? (yes/no): ", selectedProduct.price);
//        String paymentConfirmation = scan.next();
//
//        if (!"yes".equalsIgnoreCase(paymentConfirmation)) {
//            System.out.println("Payment cancelled. Order not placed.");
//            return;
//        }
//        System.out.println("Payment successful!");
//        // --- End of Payment Handling ---
//
//        selectedProduct.quantity--;
//
//        int orderId = new Random().nextInt(10000) + 1;
//        Order newOrder = new Order(orderId, selectedProduct);
//        orders.put(orderId, newOrder);
//
//        System.out.println("Order placed successfully! Your order details:");
//        System.out.println(newOrder);
//    }
//
//    private static void cancelOrder(Scanner scan) {
//        if (orders.isEmpty()) {
//            System.out.println("No orders to cancel.");
//            return;
//        }
//
//        System.out.println("\n--- Your Orders ---");
//        orders.values().forEach(System.out::println);
//        System.out.print("Enter the order ID to cancel: ");
//        int orderId = scan.nextInt();
//
//        Order orderToCancel = orders.get(orderId);
//
//        if (orderToCancel == null) {
//            throw new InvalidOrderException("Order with ID " + orderId + " not found.");
//        }
//
//        // --- Refund Logic ---
//        Consumer<Order> initiateRefund = order -> {
//            System.out.printf("Initiating refund of $%.2f for order %d...%n", order.product.price, order.orderId);
//            // In a real system, this would call a payment gateway API.
//            System.out.println("Refund processed successfully.");
//        };
//
//        initiateRefund.accept(orderToCancel);
//        // --- End of Refund Logic ---
//
//        orderToCancel.status = "CANCELLED";
//        // Return the product to stock
//        orderToCancel.product.quantity++;
//
//        System.out.println("Order " + orderId + " has been cancelled.");
//    }
//
//    private static void returnOrder(Scanner scan) {
//        if (orders.isEmpty()) {
//            System.out.println("No orders to return.");
//            return;
//        }
//
//        System.out.println("\n--- Your Orders ---");
//        orders.values().forEach(System.out::println);
//        System.out.print("Enter the order ID to return: ");
//        int orderId = scan.nextInt();
//
//        Order orderToReturn = orders.get(orderId);
//
//        if (orderToReturn == null) {
//            throw new InvalidOrderException("Order with ID " + orderId + " not found.");
//        }
//
//        // --- Return and Refund Logic using Lambda ---
//        Consumer<Order> returnOrderAndRefund = order -> {
//            System.out.println("Processing return for order " + order.orderId + "...");
//            order.status = "RETURNED";
//            // Return the product to stock
//            order.product.quantity++;
//            System.out.printf("Initiating refund of $%.2f...%n", order.product.price);
//            System.out.println("Refund processed successfully.");
//        };
//
//        returnOrderAndRefund.accept(orderToReturn);
//        // --- End of Return and Refund Logic ---
//
//        System.out.println("Order " + orderId + " has been returned.");
//    }
//}
//
//class OutOfStockException extends RuntimeException {
//    public OutOfStockException(String message) {
//        super(message);
//    }
//}
//
//class InvalidOrderException extends RuntimeException {
//    public InvalidOrderException(String message) {
//        super(message);
//    }
//}


/**
 *
 * the provided code does not fully or safely solve the problem due to several critical design
 * and business logic issues. While it lists the requested functions, it fails key exception
 * handling and validation checks.
 *
 * Key Issues in the Provided Code
 * Fatal Control Flow/App Crashing (Critical) In the provided code, the menu loop (while (true))
 * is wrapped inside a single external try-catch block in the main method. If an
 * InvalidOrderException or OutOfStockException is thrown inside placeOrder(),
 * cancelOrder(), or returnOrder(), the exception propagates all the way to main,
 * breaks the menu loop, prints the stack trace, and crashes/exits the application.
 * A robust interactive program should catch these business exceptions inside the menu loop,
 * display the error, and allow the user to select another action.
 *
 * No Custom PaymentFailedException The problem statement explicitly asks to handle Payment
 * failure. Instead of using exception handling, the code simply prints "Payment cancelled.
 * Order not placed." and exits the method with a return; statement. A standard
 * exception-oriented solution should define a custom PaymentFailedException and throw it when payment is declined.
 *
 * Double Refund & Stock Duplication Exploit (Business Logic Bypass) There are no
 * checks on the order status during cancellation or returns:
 *
 * A user can cancel an order that is already "CANCELLED" or "RETURNED", which triggers refunds
 * repeatedly and keeps incrementing the stock of the product.
 * Similarly, a user can return a cancelled or returned order multiple times, causing duplicate refunds.
 * An InvalidOrderException should be thrown if the order is not currently in the "PLACED" state.
 * Scanner Input Mismatch Vulnerability If the user enters a non-integer input (e.g., "xyz") for
 * menu choices or ID selections, Scanner.nextInt() throws an InputMismatchException. This is uncaught
 * inside the loop and crashes the program.
 *
 * */


package exception_handling.intermediate.advance.interview_problems;

import java.util.*;
import java.util.function.Consumer;



public class ECommerceOrderingSystem {

    static Map<Integer, Product> products = new HashMap<>();
    static Map<Integer, Order> orders = new HashMap<>();

    static {
        products.put(1, new Product(1, "iPhone 16 Pro", 34, 1299.99));
        products.put(2, new Product(2, "POCO X6 Pro", 4, 349.99));
        products.put(3, new Product(3, "Macbook Pro", 24, 2499.99));
        products.put(4, new Product(4, "Starlabs Laptop", 84, 1999.00));
        products.put(5, new Product(5, "Lenovo Laptop", 54, 999.50));
    }

    public static void main(String[] args) {
        System.out.println("--- Welcome to the E-Commerce Ordering System ---");

        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Place Order");
                System.out.println("2. Cancel Order");
                System.out.println("3. Return Order");
                System.out.println("4. Exit");

                try {
                    if (!scan.hasNextInt()) {
                        String invalidInput = scan.next();
                        System.out.println("Invalid choice: '" + invalidInput + "'. Please enter a number.");
                        continue;
                    }
                    int choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            placeOrder(scan);
                            break;
                        case 2:
                            cancelOrder(scan);
                            break;
                        case 3:
                            returnOrder(scan);
                            break;
                        case 4:
                            System.out.println("Thank you for using the system.");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (OutOfStockException | InvalidOrderException | PaymentFailedException e) {
                    System.err.println("Operation Failed: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input format. Please try again.");
                    scan.nextLine(); // Clear the scanner buffer
                } catch (Exception e) {
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Fatal system error: " + e.getMessage());
        }
    }

    private static void placeOrder(Scanner scan) {
        System.out.println("\n--- Available Products ---");
        products.values().forEach(System.out::println);

        System.out.print("Enter the product ID to order: ");
        if (!scan.hasNextInt()) {
            String invalid = scan.next();
            throw new InvalidOrderException("Product ID must be an integer, got: '" + invalid + "'");
        }
        int productId = scan.nextInt();

        Product selectedProduct = products.get(productId);

        if (selectedProduct == null) {
            throw new InvalidOrderException("Product with ID " + productId + " not found.");
        }

        if (selectedProduct.quantity <= 0) {
            throw new OutOfStockException("Product is out of stock: " + selectedProduct.name);
        }

        // --- Payment Handling ---
        System.out.printf("The price of the product is $%.2f. Proceed with payment? (yes/no): ", selectedProduct.price);
        String paymentConfirmation = scan.next();

        if ("no".equalsIgnoreCase(paymentConfirmation)) {
            throw new PaymentFailedException("Payment declined by user. Order not placed.");
        } else if (!"yes".equalsIgnoreCase(paymentConfirmation)) {
            throw new PaymentFailedException("Payment failed due to invalid authentication or response.");
        }
        System.out.println("Payment successful!");
        // --- End of Payment Handling ---

        selectedProduct.quantity--;

        int orderId = new Random().nextInt(10000) + 1;
        Order newOrder = new Order(orderId, selectedProduct);
        orders.put(orderId, newOrder);

        System.out.println("Order placed successfully! Your order details:");
        System.out.println(newOrder);
    }

    private static void cancelOrder(Scanner scan) {
        if (orders.isEmpty()) {
            System.out.println("No orders to cancel.");
            return;
        }

        System.out.println("\n--- Your Orders ---");
        orders.values().forEach(System.out::println);
        System.out.print("Enter the order ID to cancel: ");
        if (!scan.hasNextInt()) {
            String invalid = scan.next();
            throw new InvalidOrderException("Order ID must be an integer, got: '" + invalid + "'");
        }
        int orderId = scan.nextInt();

        Order orderToCancel = orders.get(orderId);

        if (orderToCancel == null) {
            throw new InvalidOrderException("Order with ID " + orderId + " not found.");
        }

        // Validate order status before proceeding with cancellation
        if ("CANCELLED".equals(orderToCancel.status)) {
            throw new InvalidOrderException("Order " + orderId + " is already cancelled.");
        }
        if ("RETURNED".equals(orderToCancel.status)) {
            throw new InvalidOrderException("Order " + orderId + " has already been returned and cannot be cancelled.");
        }

        // --- Refund Logic ---
        Consumer<Order> initiateRefund = order -> {
            System.out.printf("Initiating refund of $%.2f for order %d...%n", order.product.price, order.orderId);
            System.out.println("Refund processed successfully.");
        };

        initiateRefund.accept(orderToCancel);
        // --- End of Refund Logic ---

        orderToCancel.status = "CANCELLED";
        // Return the product to stock
        orderToCancel.product.quantity++;

        System.out.println("Order " + orderId + " has been cancelled.");
    }

    private static void returnOrder(Scanner scan) {
        if (orders.isEmpty()) {
            System.out.println("No orders to return.");
            return;
        }

        System.out.println("\n--- Your Orders ---");
        orders.values().forEach(System.out::println);
        System.out.print("Enter the order ID to return: ");
        if (!scan.hasNextInt()) {
            String invalid = scan.next();
            throw new InvalidOrderException("Order ID must be an integer, got: '" + invalid + "'");
        }
        int orderId = scan.nextInt();

        Order orderToReturn = orders.get(orderId);

        if (orderToReturn == null) {
            throw new InvalidOrderException("Order with ID " + orderId + " not found.");
        }

        // Validate order status before proceeding with return
        if ("RETURNED".equals(orderToReturn.status)) {
            throw new InvalidOrderException("Order " + orderId + " has already been returned.");
        }
        if ("CANCELLED".equals(orderToReturn.status)) {
            throw new InvalidOrderException("Order " + orderId + " is cancelled and cannot be returned.");
        }

        // --- Return and Refund Logic using Lambda ---
        Consumer<Order> returnOrderAndRefund = order -> {
            System.out.println("Processing return for order " + order.orderId + "...");
            order.status = "RETURNED";
            // Return the product to stock
            order.product.quantity++;
            System.out.printf("Initiating refund of $%.2f...%n", order.product.price);
            System.out.println("Refund processed successfully.");
        };

        returnOrderAndRefund.accept(orderToReturn);
        // --- End of Return and Refund Logic ---

        System.out.println("Order " + orderId + " has been returned.");
    }
}

class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}

class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}

class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String message) {
        super(message);
    }
}
class Product {
    int id;
    String name;
    int quantity;
    double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}

class Order {
    int orderId;
    Product product;
    String status; // e.g., "PLACED", "CANCELLED", "RETURNED"

    public Order(int orderId, Product product) {
        this.orderId = orderId;
        this.product = product;
        this.status = "PLACED";
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Product: " + product.name + ", Status: " + status;
    }
}