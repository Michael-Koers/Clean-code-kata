package _05_IOSP;

import java.util.List;

public record Order(int id, String status, List<Item> items) {

    Order updateStatus(String newStatus) {
        return new Order(this.id, newStatus, this.items);
    }
}

