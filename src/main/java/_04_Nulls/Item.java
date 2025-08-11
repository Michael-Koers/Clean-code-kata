package _04_Nulls;

import java.util.Objects;

public class Item {

    private final int id;
    private final String name;
    private final Double price;
    private final Double discount;

    public Item(final int id, final String name, final Double price) {
        this(id, name, price, 0d);
    }

    public Item(final int id, final String name, final Double price, final Double discount) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(price, "price must not be null");
        Objects.requireNonNull(discount, "discount must not be null");

        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Double getPriceWithDiscount() {
        return price - discount;
    }

    public String getName() {
        return name.toLowerCase();
    }

    public int getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }
}
