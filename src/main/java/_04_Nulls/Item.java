package _04_Nulls;

import lombok.Getter;

public class Item {

    private final int id;
    private final String name;
    private final Double price;
    private final Double discount;

    public Item(final int id, final String name, final Double price, final Double discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Double getPriceWithDiscount() {
        if (discount == null) {
            return price;
        }
        return price - discount;
    }

    public String getName() {
        if (name == null) {
            return null;
        }

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
