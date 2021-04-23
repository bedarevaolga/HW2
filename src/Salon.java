import Enum.*;
import Cars.Car;
import Factories.Factory;
import Services.ChangeColorService;
import Services.ChangeOption;
import Services.ChangeWheelsService;

public class Salon {

    Car createNewCarOnFactory(Factory factory, Color color, Model model, int year,
                              WheelSize wheelSize, EngineVolume engineVolume) {
        if (year <= 2021 && year >= 2019) {
            if (color != null && model != null && wheelSize != null && engineVolume != null) {
                return factory.createNewCar(color, model, year, wheelSize, engineVolume);
            }
            return null;
        }
        throw new IllegalArgumentException();
    }

    Car changeColorInCar(ChangeColorService changeColorService, Car car, Color color) {
        if (changeColorService != null && car != null && color != null) {
            return changeColorService.changeColor(car, color);
        }
        return null;
    }

    Car changeWheelsInCar(ChangeWheelsService changeWheelsService, Car car, WheelSize wheelSize) {
        if (changeWheelsService != null && car != null && wheelSize != null) {
            return changeWheelsService.changeWheels(car, wheelSize);
        }
        return null;
    }

    Car addOptionInCar(ChangeOption changeOption, Car car, Option option) {
        if (changeOption != null && car != null && option != null) {
            return changeOption.addOptionToList(car, option);
        }
        return null;
    }

    Car deleteOptionInCar(ChangeOption changeOption, Car car, Option option) {
        if (changeOption != null && car != null && option != null) {
            return changeOption.deleteOptionFromList(car, option);
        }
        return null;
    }
}

