package homeWork._2023_07_13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Car {
    private String color;
    private boolean isSportsCar;
    private CarBrand brand;
    private int maxSpeed;

    public boolean isSportsCar() {

        return isSportsCar;
    }

}
