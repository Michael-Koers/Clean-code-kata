package _03_Anemic_Domain_Model;


public class Hotel {

    private String name;
    private int rooms;
    private int floors;
    private int employees;

    public Hotel(final String name, final int rooms, final int floors, final int employees) {
        this.name = name;
        this.rooms = rooms;
        this.floors = floors;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(final int rooms) {
        this.rooms = rooms;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(final int floors) {
        this.floors = floors;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(final int employees) {
        this.employees = employees;
    }
}
