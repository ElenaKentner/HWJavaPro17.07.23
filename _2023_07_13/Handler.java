package homeWork._2023_07_13;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Handler {

    /**
     * метод для вывода всех мужчин с спортивными машинами
     * @param develops
     */
    public void printWithSportsCars(List<Develop> develops) {
        develops.stream()
                .filter(develop -> develop.getGender() == 'M' && develop.getCar().isSportsCar())
                .forEach(develop -> System.out.println(develop.getFirstName() + " has a sports car"));
    }

    /**
     * метод группировать по полу все машины. те у мужчин такие то у женщин такие то
     * @param develops
     * @return
     */
    public Map<Character, List<Car>> groupCarsByGender(List<Develop> develops) {
        return develops.stream()
                .map(Develop::getCar)
                .collect(Collectors.groupingBy(car -> car.isSportsCar() ? 'M' : 'F'));
    }

    /**
     * Метод для перевода в Map ключ-девелопер со значением - максимальная скорость авто
     * @param develops
     * @return
     */
    public Map<Develop, Integer> mapDevelopersAndCarSpeed(List<Develop> develops) {
        return develops.stream()
                .collect(Collectors.toMap(develop -> develop, develop -> develop.getCar().getMaxSpeed()));
    }

    /**
     * Метод для записи информации о девелоперах в текстовый файл
     * @param develops
     * @param filename
     */
    public void writeDevelopersToFile(List<Develop> develops, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            develops.forEach(develop ->
                    writer.println(develop.getFirstName() + "-[auto: " + develop.getCar().getBrand() +
                            " ::: salary: " + develop.getSalary() + "]"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
