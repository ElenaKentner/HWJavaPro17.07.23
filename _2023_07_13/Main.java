package homeWork._2023_07_13;

import java.util.List;
import java.util.Map;

/*
Написать класс машина у которой будут поля цвет, булеан-спортивная или нет, энам марка и инт максимальная скорость
Написать класс Девелопер у которого будет имя, фамилия , возраст, зарплата, чар- пол и машина
Написать класс Генератор которые генерирует Девелоперов и Машины
у генератора будут два метода которые будут генерировать машины и девелоперов в зависимости от количества которые вы передадите в параметры
Вам в помощ библиотека faker для генерации любых имен, фамилий итд
Написать класс Обработчик который будет:
—проходится по листу девелоперов и выводить всех мужчин у которых спортивная машина
—группировать по полу все машины. те у мужчин такие то у женщин такие то
—Переводить в мапу ключ-девелопер а значение максимальная скоросьть авто
—записывать в текстовый файл всех девелоперов в формате : Jonn-[auto: BMW ::: salary: 12345] в столбик. Т.е в файле нужна только эта инфа

 */
public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Handler handler = new Handler();

        List<Develop> develops = generator.generateDevelopers(10);
        for (Develop develop : develops) {
            System.out.println("Developer: " + develop.getFirstName() + " " + develop.getLastName() +
                    ", has car: " + develop.getCar().getBrand());
        }

        handler.printWithSportsCars(develops);

        Map<Character, List<Car>> carsByGender = handler.groupCarsByGender(develops);
        carsByGender.forEach((gender, cars) -> {
                    System.out.println(gender == 'M' ? "M cars:" : "F cars:");
                    cars.forEach(car -> System.out.println(car.getBrand()));
        });

            Map<Develop, Integer> developerCarSpeedMap = handler.mapDevelopersAndCarSpeed(develops);
            developerCarSpeedMap.forEach((develop, maxSpeed) ->
                    System.out.println(develop.getFirstName() + ", has car max speed: " + maxSpeed));


            handler.writeDevelopersToFile(develops, "developers_info.txt");

        }



}

