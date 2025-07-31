package _04_Nulls;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    private final ItemRepository repository = new ItemRepository();

    @Test
    void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(4, items.size());
    }

    @Test
    void testFindById_ExistingId() {
        Item item = repository.findById(1);
        assertNotNull(item);
        assertEquals(1, item.getId());
    }

    @Test
    void testFindById_NonExistingId() {
        Item item = repository.findById(999);
        assertNull(item);
    }

    @Test
    void testFindByDiscountEqualsOrHigher_NoDiscounts() {
        List<Item> items = repository.findByDiscountEqualsOrHigher(10.0);
        assertTrue(items.isEmpty());
    }

    @Test
    void testFindByDiscountEqualsOrHigher_WithDiscounts() {
        List<Item> items = repository.findByDiscountEqualsOrHigher(5.0);
        assertEquals(1, items.size());
        assertEquals(3, items.get(0).getId());
    }

    @Test
    void testFindByDiscountEqualsOrHigher_LowerThreshold() {
        List<Item> items = repository.findByDiscountEqualsOrHigher(0.0);
        assertEquals(2, items.size());
    }
}
