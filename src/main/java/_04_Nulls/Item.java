package _04_Nulls;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Item {

    private final int id;
    private final String name;
    private final Double price;
    private final Double discount;

    public double getPriceWithDiscount() {
        if (discount == null) {
            return price;
        }
        return price - discount;
    }

    public String getName(){
        if(name == null){
            return null;
        }

        return name.toLowerCase();
    }
}
