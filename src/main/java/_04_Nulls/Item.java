package _04_Nulls;

public class Item {

    // Should never be null
    private final int id;
    // Should never be null
    private final String name;
    // Should never be null
    private final Double price;
    // Discount in euros, not percentage
    // Not always present
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
