package functional.function.advance;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// A generic mapper that can be configured with mapping functions.
class Mapper {
    private final Map<Class<?>, Map<Class<?>, Function<?, ?>>> registry = new HashMap<>();

    public <S, D> void register(Class<S> sourceType, Class<D> destType, Function<S, D> mappingFunction) {
        registry.computeIfAbsent(sourceType, k -> new HashMap<>()).put(destType, mappingFunction);
    }

    @SuppressWarnings("unchecked")
    public <S, D> D map(S sourceObject, Class<D> destType) {
        Function<S, D> function = (Function<S, D>) registry.get(sourceObject.getClass()).get(destType);
        if (function == null) {
            throw new IllegalArgumentException("No mapper registered for " + sourceObject.getClass() + " -> " + destType);
        }
        return function.apply(sourceObject);
    }
}

// Example classes
class Order { String orderId; double amount; public Order(String id, double amt) { orderId = id; amount = amt; } }
class OrderSummaryDto { String summary; public OrderSummaryDto(String s) { summary = s; } @Override public String toString() { return summary; } }

public class ObjectMappingFramework {
    public static void main(String[] args) {
        // Problem 11: Build object mapping framework.
        Mapper mapper = new Mapper();

        // Register a specific mapping function from Order to OrderSummaryDto
        mapper.register(Order.class, OrderSummaryDto.class, 
            order -> new OrderSummaryDto("Order " + order.orderId + " for $" + order.amount));

        Order order = new Order("ORD-123", 199.99);
        OrderSummaryDto dto = mapper.map(order, OrderSummaryDto.class);

        System.out.println(dto);
    }
}
