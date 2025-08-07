package _04_Nulls;

import java.util.List;

public class ItemRepository {

    // Simulating a database with a static list of items
    List<Item> items = List.of(
            new Item(1, "Apple", 10.0, null),
            new Item(2, "Banana", 20.0, null),
            new Item(3, "Strawberry", 30.0, 5.0),
            new Item(4, null, 0.0, 0.0)
    );

    public List<Item> findAll() {
        return items;
    }

    public Item findById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public double findItemDiscountById(int id) {
        var item=  items.stream()
                .filter(i -> i.getId() == id)
                .map(Item::getDiscount)
                .filter(discount -> discount != null) // Ensure discount is not null
                .findFirst();

        return item.orElse(null);

    }

    public List<Item> findByDiscountEqualsOrHigher(double discount) {
        return items.stream()
                .filter(item -> item.getDiscount() != null) // Ensure discount is not null
                .filter(item -> item.getDiscount() >= discount)
                .toList();
    }
}
