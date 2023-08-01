package HomeWork._2023_07_13;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

        List<Developer> developers = generator.generateDevelopers(10);//генерация списка девелоперов

        handler.printWithSportsCars(developers);// выводим всех мужчин с спортивными машинами

        Map<Character, List<Car>> carsByGender = handler.groupCarsByGender(developers);//группировка машин по полу
        carsByGender.forEach((gender, cars) -> {
                    System.out.println(gender == 'M' ? "M cars:" : "F cars:");
                    cars.forEach(car -> System.out.println(car.getBrand()));
        });

            Map<Developer, Integer> developerCarSpeedMap = handler.mapDevelopersAndCarSpeed(developers);//создаем Map, где ключ - разработчик, значение - максимальная скорость его машины
            developerCarSpeedMap.forEach((developer, maxSpeed) ->
                    System.out.println(developer.getFirstName() + ", has car max speed: " + maxSpeed));


            handler.writeDevelopersToFile(developers, "developers_info.txt"); //записываем в текстовый файл

        }



}

