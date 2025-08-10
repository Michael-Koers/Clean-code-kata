package _03_Anemic_Domain_Model;

public class HotelManager {

    private static final int GUESTS_PER_ROOM = 2;
    private static final int REQUIRED_EMPLOYEES_PER_FLOOR = 3;

    private HotelManager() {}

    public static boolean hasEnoughEmployees(Hotel hotel) {
        if (hotel == null) {
            return false;
        }
        int floors = hotel.getFloors();
        int employees = hotel.getEmployees();
        if (floors <= 0 || employees <= 0) {
            return false;
        }
        return employees >= (floors * REQUIRED_EMPLOYEES_PER_FLOOR);
    }

    public static int calculateGuestCapacity(Hotel hotel) {
        if (hotel == null) {
            return 0;
        }
        int rooms = hotel.getRooms();
        if (rooms <= 0) {
            return 0;
        }
        return rooms * GUESTS_PER_ROOM;
    }

    public static void hireNewEmployees(Hotel hotel, int employees) {
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel cannot be null");
        }
        hotel.setEmployees(hotel.getEmployees() + employees);
    }
}
