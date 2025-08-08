package _04_Nulls;

import java.util.List;

public class ItemRepository {

    private final List<Item> items;

    public ItemRepository(List<Item> items) {
        this.items = items;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public int count() {
        return items != null ? items.size() : 0;
    }

    public Item findById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Double findItemDiscountById(int id) {
        var item = items.stream()
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
