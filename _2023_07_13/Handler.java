package HomeWork._2023_07_13;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Handler {

    /**
     * метод для вывода всех мужчин с спортивными машинами
     * @param developers
     */
    public void printWithSportsCars(List<Developer> developers) {
        developers.stream()
                .filter(developer -> developer.getGender() == 'M' && developer.getCar().isSportsCar())
                .forEach(developer -> System.out.println(developer.getFirstName() + " has a sports car"));
    }

    /**
     * метод группировать по полу все машины. те у мужчин такие то у женщин такие то
     * @param developers
     * @return
     */
    public Map<Character, List<Car>> groupCarsByGender(List<Developer> developers) {
        return developers.stream()
                .map(Developer::getCar)
                .collect(Collectors.groupingBy(car -> car.isSportsCar() ? 'M' : 'F'));
    }

    /**
     * Метод для перевода в Map ключ-девелопер со значением - максимальная скорость авто
     * @param developers
     * @return
     */
    public Map<Developer, Integer> mapDevelopersAndCarSpeed(List<Developer> developers) {
        return developers.stream()
                .collect(Collectors.toMap(developer -> developer, developer -> developer.getCar().getMaxSpeed()));
    }

    /**
     * Метод для записи информации о девелоперах в текстовый файл
     * @param developers
     * @param filename
     */
    public void writeDevelopersToFile(List<Developer> developers, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            developers.forEach(developer ->
                    writer.println(developer.getFirstName() + "-[auto: " + developer.getCar().getBrand() +
                            " ::: salary: " + developer.getSalary() + "]"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
