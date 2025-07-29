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
    void testGetPrettyName_NullHotel() {
        assertEquals("Unknown Hotel", HotelManager.getPrettyName(null));
    }

    @Test
    void testGetPrettyName_NullOrEmptyName() {
        Hotel hotelWithNullName = new Hotel(null, 10, 3, 10);
        assertEquals("Unknown Hotel", HotelManager.getPrettyName(hotelWithNullName));

        Hotel hotelWithEmptyName = new Hotel("", 10, 3, 10);
        assertEquals("Unknown Hotel", HotelManager.getPrettyName(hotelWithEmptyName));
    }

    @Test
    void testGetPrettyName_ValidName() {
        Hotel hotel = new Hotel("Grand Hotel", 10, 3, 10);
        assertEquals("Grand Hotel", HotelManager.getPrettyName(hotel));
    }
}
