package _03_Split_State;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelManagerTest {

    @Test
    void testHasEnoughEmployees_NullHotel() {
        assertFalse(HotelManager.hasEnoughEmployees(null));
    }

    @Test
    void testHasEnoughEmployees_ZeroFloorsOrEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 0, 0, 0);
        assertFalse(HotelManager.hasEnoughEmployees(hotel));
    }

    @Test
    void testHasEnoughEmployees_NotEnoughEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 2, 5); // Less than 2 * 3 = 6
        assertFalse(HotelManager.hasEnoughEmployees(hotel));
    }

    @Test
    void testHasEnoughEmployees_NegativeEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 2, -5);
        assertFalse(HotelManager.hasEnoughEmployees(hotel));
    }

    @Test
    void testHasEnoughEmployees_EnoughEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 9); // 3 * 3 = 9
        assertTrue(HotelManager.hasEnoughEmployees(hotel));
    }

    @Test
    void testCalculateGuestCapacity_NullHotel() {
        assertEquals(0, HotelManager.calculateGuestCapacity(null));
    }

    @Test
    void testCalculateGuestCapacity_ZeroRooms() {
        Hotel hotel = new Hotel("Test Hotel", 0, 3, 10);
        assertEquals(0, HotelManager.calculateGuestCapacity(hotel));
    }

    @Test
    void testCalculateGuestCapacity_PositiveRooms() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 10);
        assertEquals(20, HotelManager.calculateGuestCapacity(hotel)); // 10 * 2 = 20
    }

    @Test
    void testHireNewEmployees_NullHotel() {
        HotelManager.hireNewEmployees(null, 5);
        // No exception should be thrown, and no action should be taken.
    }

    @Test
    void testHireNewEmployees_AddEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 5);
        HotelManager.hireNewEmployees(hotel, 3);
        assertEquals(8, hotel.getEmployees()); // 5 + 3 = 8
    }

    @Test
    void testHireNewEmployees_AddZeroEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 5);
        HotelManager.hireNewEmployees(hotel, 0);
        assertEquals(5, hotel.getEmployees()); // No change
    }

    @Test
    void testHireNewEmployees_AddNegativeEmployees() {
        Hotel hotel = new Hotel("Test Hotel", 10, 3, 5);
        HotelManager.hireNewEmployees(hotel, -2);
        assertEquals(3, hotel.getEmployees()); // 5 - 2 = 3
    }
}
