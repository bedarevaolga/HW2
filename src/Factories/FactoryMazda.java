package Factories;

import Cars.Car;
import Cars.CarMazda;
import Enum.*;
import Services.ChangeColorService;
import Services.ChangeOption;
import Services.ChangeWheelsService;

public class FactoryMazda extends Factory {

    public FactoryMazda(ChangeWheelsService changeWheelsService,
                        ChangeColorService changeColorService,
                        ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        if (year <= 2021 && year >= 2019) {
            if (color != null && model != null && wheelSize != null && engineVolume != null) {
                Car newMazda = new CarMazda(color, year, wheelSize, engineVolume);
                System.out.println("Мы изготовили для вас новый автомобиль:");
                newMazda.infoAboutCar();
                return newMazda;
            }
            System.out.println("Авто не изготовлено, выберите параметры из списка");
            return null;
        }
        throw new IllegalArgumentException();
    }
}