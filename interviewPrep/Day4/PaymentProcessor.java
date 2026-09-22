package Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentProcessor {
    public void processPayment(Order order, boolean networkDown) throws PaymentGatewayFailedException {
        if (order == null) {
            throw new PaymentProcessorException("Order is null");
        } else if (order.getAmount() <= 0) {
            throw new PaymentProcessorException("Order amount less than or equal to zero");
        } 

        if (networkDown) {
            throw new PaymentGatewayFailedException("Network down. Payment Gateway Failed");    
        }

        System.out.println("Order processed successfully");
    }

    public static void main(String args[]) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Order order1 = new Order(0);
        Order order2 = new Order(-2);
        Order order3 = new Order(4);
        
       // try {
            //paymentProcessor.processPayment(null, false);
            //paymentProcessor.processPayment(order1, false);
          //  paymentProcessor.processPayment(order2, false);
           // paymentProcessor.processPayment(order3, true);
            //paymentProcessor.processPayment(order3, false);
       /// } catch (PaymentGatewayFailedException ex) {
        //    System.out.println(ex.getMessage() + " - " + ex.getStackTrace());
       // }

        List<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Avacado"));
        fruits.add(null);

        List<String> fruitsStartingWithA = fruits.stream()
            .filter(fruit -> fruit == null || fruit.startsWith("A")).toList();
    //    fruitsStartingWithA.add("Guava"); // Not allowed

        List<String> fruitsStartingWithB = fruits.stream()
            .filter(fruit -> fruit == null  || fruit.startsWith("B")).collect(Collectors.toList());
        fruitsStartingWithB.add("Blueberry"); // Allowed
        
        System.out.println("Fruits starting with A");
        System.out.println(fruitsStartingWithA);
        
        System.out.println("Fruits starting with B");
        System.out.println(fruitsStartingWithB);
        
    }
}
