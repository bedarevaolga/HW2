package Factories;

import Cars.Car;
import Cars.CarKia;
import Enum.*;
import Services.ChangeColorService;
import Services.ChangeOption;
import Services.ChangeWheelsService;

public class FactoryKia extends Factory {

    public FactoryKia(ChangeWheelsService changeWheelsService,
                      ChangeColorService changeColorService,
                      ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        if (year <= 2021 && year >= 2019) {
            if (color != null && model != null && wheelSize != null && engineVolume != null) {
                Car newKia = new CarKia(color, year, wheelSize, engineVolume);
                System.out.println("Мы изготовили для вас новый автомобиль:");
                newKia.infoAboutCar();
                return newKia;
            }
            System.out.println("Авто не изготовлено, выберите параметры из списка");
            return null;
        }
        throw new IllegalArgumentException();
    }
}
