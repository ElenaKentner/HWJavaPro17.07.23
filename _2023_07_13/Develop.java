package homeWork._2023_07_13;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class Develop {
    private String firstName;
    private String lastName;
    private int age;
    private int salary;
    private char gender;
    private Car car;

    public Develop(String firstName, String lastName, int age, int salary, char gender, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.car = car;
    }
}
