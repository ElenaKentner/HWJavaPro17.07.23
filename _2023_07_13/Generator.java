package HomeWork._2023_07_13;

import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private final Faker faker;

    public Generator() {
        this.faker = new Faker();
    }

    /**
     * Метод для генерации случайной машины
     *
     * @return объект класса Car с случайными значениями
     */
    public Car generateCar() {
        String color = faker.color().name();
        boolean isSportsCar = faker.random().nextBoolean();
        CarBrand brand = generateRandomCarBrand();
        int maxSpeed = faker.number().numberBetween(100, 300);
        return new Car(color, isSportsCar, brand, maxSpeed);
    }

    /**
     * Метод для генерации случайного разработчика с случайной машиной
     *
     * @return объект класса Developer с случайными значениями
     */
    public Developer generateDeveloper() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(18, 65);
        int salary = faker.number().numberBetween(30000, 100000);
        char gender = faker.bool().bool() ? 'M' : 'F';
        Car car = generateCar();
        return new Developer(firstName, lastName, age, salary, gender, car);
    }

    /**
     * Метод для генерации списка случайных разработчиков
     *
     * @param count количество разработчиков для генерации
     * @return список разработчиков
     */
    public List<Developer> generateDevelopers(int count) {
        List<Developer> developers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            developers.add(generateDeveloper());
        }
        return developers;
    }

    /**
     * Метод для генерации бренда машины из списка
     *
     * @return случайный бренд из перечисления CarBrand
     */
    private CarBrand generateRandomCarBrand() {
        CarBrand[] carBrands = CarBrand.values();
        Random random = new Random();
        return carBrands[random.nextInt(carBrands.length)];
    }
}