package _02_Comments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Container object for all items placed in an Order
public class Container {

    // Tax
    public static final double _1_16 = 1.16d;

    // List of all items in this order
    List<Item> list = new ArrayList<>();

    // Adds new item to the order
    void addToOrder(Item item) {
        this.list.add(item);
    }

    // Checks if the order contains a specific item
    boolean contains(Item item) {
        // Ran into performance issues when orders grew too large, using BinarySearch solved those issues.
        return Collections.binarySearch(this.list, item) >= 0;
    }

    // Gets totalprice of the order
    double calculate() {
        return this.list.stream()
                .mapToDouble(Item::price)
                .sum() * _1_16;
    }
}


record Item(int id, String name, double price) implements Comparable<Item> {
    @Override
    public int compareTo(final Item o) {
        return Integer.compare(this.id, o.id);
    }
}
