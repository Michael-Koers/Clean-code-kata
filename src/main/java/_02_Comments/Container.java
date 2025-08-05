package _02_Comments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Container object for all items placed in an Order
public class Container {

    // Tax
    public static final double _1_16 = 1.16d;

    // List of all items in this order
    // Keep sorted!
    List<ContainerObject> list = new ArrayList<>();

    // Adds new item to the order
    void addToOrder(ContainerObject containerObject) {
        this.list.add(containerObject);
        Collections.sort(this.list);
    }

    // Checks if the order contains a specific item
    boolean contains(ContainerObject containerObject) {
        // Ran into performance issues when orders grew too large, using BinarySearch solved those issues.
        // Note: it's important to keep this list sorted at all times for BinarySearch to work correctly.
        return Collections.binarySearch(this.list, containerObject) >= 0;
    }

    // Gets total price of the order
    double calculate() {
        // Use streams to iterate through all items and sum their prices
        return this.list.stream()
                .mapToDouble(ContainerObject::field2)
                .sum() * _1_16;
    }
}

/**
 * Represents items placed in an order.
 * @param field0 Item ID
 * @param field1 Item name
 * @param field2 Item price
 */
record ContainerObject(int field0, String field1, double field2) implements Comparable<ContainerObject> {

    // To make Item sortable for collection sorting
    @Override
    public int compareTo(final ContainerObject o) {
        return Integer.compare(this.field0, o.field0);
    }
}
