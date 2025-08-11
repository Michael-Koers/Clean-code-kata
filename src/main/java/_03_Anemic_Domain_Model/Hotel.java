package _03_Anemic_Domain_Model;


public class Hotel {

    private static final int REQUIRED_EMPLOYEES_PER_FLOOR = 3;
    private static final int GUESTS_PER_ROOM = 2;

    private final String name;
    private final int rooms;
    private final int floors;
    private int employees;

    public Hotel(final String name, final int rooms, final int floors, final int employees) {
        this.name = name;
        this.rooms = rooms;
        this.floors = floors;
        this.employees = employees;
    }

    public void hireNewEmployees(int employees) {
        this.employees = this.employees + employees;
    }

    public int calculateGuestCapacity() {
        if (rooms <= 0) {
            return 0;
        }
        return rooms * GUESTS_PER_ROOM;
    }

    public boolean hasEnoughEmployees() {
        if (floors <= 0 || employees <= 0) {
            return false;
        }
        return employees >= (floors * REQUIRED_EMPLOYEES_PER_FLOOR);
    }

    public int getEmployees() {
        return employees;
    }
}
