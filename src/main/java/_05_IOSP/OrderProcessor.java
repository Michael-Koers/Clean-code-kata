package _05_IOSP;

import java.util.List;

public class OrderProcessor {

    public static final int STOCK_MINIMUM = 5;
    public static final double DISCOUNT_THRESHOLD = 3;
    private static final double DISCOUNT_RATE = 0.1;

    public static void main(String[] args) {
        // Example usage
        Item item1 = new Item("Widget", 19.99, 10);
        Item item2 = new Item("Gadget", 29.99, 5);
        Order order = new Order(1, "New", List.of(item1, item2));

        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(order);
    }

    public void processOrder(Order order) {
        if (!isValid(order)) {
            logError("Invalid order: " + order.id());
            throw new IllegalArgumentException("Invalid order");
        }
        saveOrderToDatabase(order);
        double total = calculateTotalWithDiscount(order);
        sendConfirmationEmail(order, total);
        order = order.updateStatus("Processed");
        logOrderProcessed(order);

        if (shouldNotifyManager(order)) {
            notifyManager(order, total);
        }
    }

    private boolean isValid(Order order) {
        return order != null && !order.items().isEmpty() && checkInventory(order);
    }

    private boolean checkInventory(Order order) {
        for (Item item : order.items()) {
            if (!isInStock(item)) {
                logError("Item out of stock: " + item.name());
                return false;
            }
        }
        return true;
    }

    private boolean isInStock(Item item) {
        return item.stock() < getStockMinimum();
    }


    private void saveOrderToDatabase(Order order) {
        System.out.println("Order saved to DB: " + order.id());
        order = order.updateStatus("Processing");
        updateOrderHistory(order);
    }

    private void updateOrderHistory(Order order) {
        System.out.println("Order history updated for: " + order.id());
    }

    private double calculateTotalWithDiscount(Order order) {
        double total = calculateTotal(order);
        if (order.items().size() > getDiscountThreshold()) {
            total *= getDiscountRate();
            logDiscountApplied(order, total);
        }
        return total;
    }

    private double calculateTotal(Order order) {
        return order.items().stream().mapToDouble(Item::price).sum();
    }

    private void logDiscountApplied(Order order, double total) {
        System.out.println("Discount applied to order " + order.id() + ": " + total);
    }

    private void sendConfirmationEmail(Order order, double total) {
        System.out.println("Email sent for order " + order.items() + " with total " + total);
        logEmailSent(order);
    }

    private void logEmailSent(Order order) {
        System.out.println("Confirmation email logged for: " + order.id());
    }

    private void logOrderProcessed(Order order) {
        System.out.println("Order processed: " + order.id());
        archiveOrder(order);
    }

    private void archiveOrder(Order order) {
        System.out.println("Order archived: " + order.id());
    }

    private boolean shouldNotifyManager(Order order) {
        return order.items().size() > 10;
    }

    private void notifyManager(Order order, double total) {
        System.out.println("Manager notified for order " + order.id() + " with total " + total);
        logManagerNotification(order);
    }

    private void logManagerNotification(Order order) {
        System.out.println("Manager notification logged for: " + order.id());
    }

    private void logError(String message) {
        System.err.println("ERROR: " + message);
    }

    private int getStockMinimum() {
        return STOCK_MINIMUM;
    }

    private double getDiscountThreshold() {
        return DISCOUNT_THRESHOLD;
    }

    private double getDiscountRate() {
        return 1 - DISCOUNT_RATE;
    }
}
