package functional.predicate.basic.intermediate.advance;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

class Order {
    double amount;
    String region;
    boolean isPriority;
    public Order(double amount, String region, boolean isPriority) {
        this.amount = amount; this.region = region; this.isPriority = isPriority;
    }
}

// Represents an action to be taken if a rule matches
interface Action {
    void execute(Order order);
}

class Rule {
    Predicate<Order> condition;
    Action action;
    public Rule(Predicate<Order> condition, Action action) {
        this.condition = condition; this.action = action;
    }
}

public class RuleEngine {
    private Set<Rule> rules = new HashSet<>();

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void process(Order order) {
        rules.stream()
             .filter(rule -> rule.condition.test(order))
             .forEach(rule -> rule.action.execute(order));
    }

    public static void main(String[] args) {
        // Problem 14: Implement rule engine using Predicate chaining.
        RuleEngine engine = new RuleEngine();

        // Rule 1: High-value international orders need special handling.
        Predicate<Order> highValue = o -> o.amount > 1000;
        Predicate<Order> international = o -> !o.region.equals("DOMESTIC");
        Action flagForReview = o -> System.out.println("FLAGGED: High-value international order $" + o.amount);
        engine.addRule(new Rule(highValue.and(international), flagForReview));

        // Rule 2: Priority orders get express shipping.
        Action grantExpressShipping = o -> System.out.println("ACTION: Granting express shipping for order.");
        engine.addRule(new Rule(o -> o.isPriority, grantExpressShipping));

        // Process orders
        engine.process(new Order(1500, "INTERNATIONAL", false));
        engine.process(new Order(200, "DOMESTIC", true));
    }
}
