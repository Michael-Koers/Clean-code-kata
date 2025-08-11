package _04_Nulls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepository {

    private final List<Item> items;

    public ItemRepository(List<Item> items) {
        if(items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = new ArrayList<>(items);
        }
    }

    public List<Item> findAll() {
        return this.items;
    }

    public int count() {
        return items.size();
    }

    public Optional<Item> findById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    public List<Item> findByDiscountEqualsOrHigher(double discount) {
        return items.stream()
                .filter(item -> item.getDiscount() >= discount)
                .toList();
    }
}
