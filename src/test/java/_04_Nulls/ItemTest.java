package _04_Nulls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testGetPriceWithDiscount_NoDiscount() {
        Item item = new Item(1, "Apple", 10.0);
        assertEquals(10.0, item.getPriceWithDiscount());
    }

    @Test
    void testGetPriceWithDiscount_WithDiscount() {
        Item item = new Item(1, "Apple", 10.0, 2.0);
        assertEquals(8.0, item.getPriceWithDiscount());
    }

//    @Test
//    void testGetName_NullName() {
//        Item item = new Item(1, null, 10.0, null);
//        assertNull(item.getName());
//    }

    @Test
    void testGetName_ValidName() {
        Item item = new Item(1, "Apple", 10.0);
        assertEquals("apple", item.getName());
    }
}
