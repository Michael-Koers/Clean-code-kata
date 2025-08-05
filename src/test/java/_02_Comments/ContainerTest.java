package _02_Comments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container container;

    @BeforeEach
    void setUp() {
        container = new Container();
    }

    @Test
    void testAddToOrder() {
        ContainerObject item1 = new ContainerObject(1, "Item1", 10.0);
        ContainerObject item2 = new ContainerObject(2, "Item2", 20.0);

        container.addToOrder(item1);
        container.addToOrder(item2);

        assertTrue(container.contains(item1));
        assertTrue(container.contains(item2));
    }

    @Test
    void testContains() {
        ContainerObject item1 = new ContainerObject(1, "Item1", 10.0);
        ContainerObject item2 = new ContainerObject(2, "Item2", 20.0);

        container.addToOrder(item1);

        assertTrue(container.contains(item1));
        assertFalse(container.contains(item2));
    }

    @Test
    void testCalculate() {
        ContainerObject item1 = new ContainerObject(1, "Item1", 10.0);
        ContainerObject item2 = new ContainerObject(2, "Item2", 20.0);

        container.addToOrder(item1);
        container.addToOrder(item2);

        double expectedTotal = (10.0 + 20.0) * Container._1_16;
        assertEquals(expectedTotal, container.calculate(), 0.001);
    }

    @Test
    void testEmptyContainerCalculate() {
        assertEquals(0.0, container.calculate(), 0.001);
    }
}
