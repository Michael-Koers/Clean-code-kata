package _03_Split_State;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Hotel {

    private String name;
    private int rooms;
    private int floors;
    private int employees;
}
