package _02_Comments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testAddToOrder() {
        Item item1 = new Item(1, "Item1", 10.0);
        Item item2 = new Item(2, "Item2", 20.0);

        order.addToOrder(item1);
        order.addToOrder(item2);

        assertTrue(order.contains(item1));
        assertTrue(order.contains(item2));
    }

    @Test
    void testContains() {
        Item item1 = new Item(1, "Item1", 10.0);
        Item item2 = new Item(2, "Item2", 20.0);

        order.addToOrder(item1);

        assertTrue(order.contains(item1));
        assertFalse(order.contains(item2));
    }

    @Test
    void testGetTotalPrice() {
        Item item1 = new Item(1, "Item1", 10.0);
        Item item2 = new Item(2, "Item2", 20.0);

        order.addToOrder(item1);
        order.addToOrder(item2);

        double expectedTotal = (10.0 + 20.0) * Order.TAX;
        assertEquals(expectedTotal, order.getTotalPrice(), 0.001);
    }

    @Test
    void testEmptyContainerGetTotalPrice() {
        assertEquals(0.0, order.getTotalPrice(), 0.001);
    }
}
