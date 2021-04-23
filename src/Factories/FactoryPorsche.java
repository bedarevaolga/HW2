package Factories;

import Cars.Car;
import Cars.CarPorsche;
import Enum.*;
import Services.ChangeColorService;
import Services.ChangeOption;
import Services.ChangeWheelsService;

public class FactoryPorsche extends Factory {

    public FactoryPorsche(ChangeWheelsService changeWheelsService,
                          ChangeColorService changeColorService,
                          ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        if (year <= 2021 && year >= 2019) {
            if (color != null && model != null && wheelSize != null && engineVolume != null) {
                Car newPorsche = new CarPorsche(color, year, wheelSize, engineVolume);
                System.out.println("Мы изготовили для вас новый автомобиль:");
                newPorsche.infoAboutCar();
                return newPorsche;
            }
            System.out.println("Авто не изготовлено, выберите параметры из списка");
            return null;
        }
        throw new IllegalArgumentException();
    }
}