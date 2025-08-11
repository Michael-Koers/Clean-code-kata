package _03_Anemic_Domain_Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelManagerTest {

    // No longer relevant
//    @Test
//    void testHasEnoughEmployees_NullHotel() {
//        assertFalse(HotelManager.hasEnoughEmployees(null));
//    }

    @Test
    void testHasEnoughEmployees_ZeroFloorsOrEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 0, 0, 0);
        assertFalse(hotel.hasEnoughEmployees());
    }

    @Test
    void testHasEnoughEmployees_NotEnoughEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 2, 5); // Less than 2 * 3 = 6
        assertFalse(hotel.hasEnoughEmployees());
    }

    @Test
    void testHasEnoughEmployees_NegativeEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 2, -5);
        assertFalse(hotel.hasEnoughEmployees());
    }

    @Test
    void testHasEnoughEmployees_EnoughEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 9); // 3 * 3 = 9
        assertTrue(hotel.hasEnoughEmployees());
    }

    // No longer relevant
//    @Test
//    void testCalculateGuestCapacity_NullHotel() {
//        assertEquals(0, null.calculateGuestCapacity());
//    }

    @Test
    void testCalculateGuestCapacity_ZeroRooms() {
        Hotel hotel = new Hotel("Test Hotel", 0, 3, 10);
        assertEquals(0, hotel.calculateGuestCapacity());
    }

    @Test
    void testCalculateGuestCapacity_PositiveRooms() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 10);
        assertEquals(20, hotel.calculateGuestCapacity()); // 10 * 2 = 20
    }

    // No longer relevant
//    @Test
//    void testHireNewEmployees_NullHotel() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            null.hireNewEmployees(5);
//        });
//    }

    @Test
    void testHireNewEmployees_AddEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 5);
        hotel.hireNewEmployees(3);
        assertEquals(8, hotel.getEmployees()); // 5 + 3 = 8
    }

    @Test
    void testHireNewEmployees_AddZeroEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 5);
        hotel.hireNewEmployees(0);
        assertEquals(5, hotel.getEmployees()); // No change
    }

    @Test
    void testHireNewEmployees_AddNegativeEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 5);
        hotel.hireNewEmployees(-2);
        assertEquals(3, hotel.getEmployees()); // 5 - 2 = 3
    }
}
