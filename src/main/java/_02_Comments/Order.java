package _02_Comments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    public static final double TAX = 1.16d;

    // Keep sorted! See contains()
    private final List<Item> list = new ArrayList<>();

    void addToOrder(Item item) {
        this.list.add(item);
        Collections.sort(this.list);
    }

    boolean contains(Item item) {
        // Ran into performance issues when orders grew too large, using BinarySearch solved those issues.
        // Note: it's important to keep this list sorted at all times for BinarySearch to work correctly.
        return Collections.binarySearch(this.list, item) >= 0;
    }

    double getTotalPrice() {
        return this.list.stream()
                .mapToDouble(Item::price)
                .sum() * TAX;
    }
}

record Item(int id, String name, double price) implements Comparable<Item> {
    @Override
    public int compareTo(final Item o) {
        return Integer.compare(this.id, o.id);
    }
}
