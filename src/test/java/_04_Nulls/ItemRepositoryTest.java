package _04_Nulls;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    private final List<Item> items = List.of(
            new Item(1, "Apple", 10.0, null),
            new Item(2, "Banana", 20.0, null),
            new Item(3, "Strawberry", 30.0, 5.0),
            new Item(4, null, 0.0, 0.0)
    );
    private final ItemRepository repository = new ItemRepository(items);

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

    @Test
    void testFindAll_WithEmptyList() {
        ItemRepository emptyRepository = new ItemRepository(null);
        List<Item> items = emptyRepository.findAll();
        assertNull(items);
    }

    @Test
    void testCount_WithItems() {
        assertEquals(4, repository.count());
    }

    @Test
    void testCount_WithNullList() {
        ItemRepository emptyRepository = new ItemRepository(null);
        assertEquals(0, emptyRepository.count());
    }
}
