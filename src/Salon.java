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


    boolean changeColorInCar(ChangeColorService changeColorService, Car car, Color color) {
        if (changeColorService != null && car != null && color != null) {
            changeColorService.changeColor(car, color);
            return true;
        } else {
            return false;
        }
    }

    boolean changeWheelsInCar(ChangeWheelsService changeWheelsService, Car car, WheelSize wheelSize) {
        if (changeWheelsService != null && car != null && wheelSize != null) {
            changeWheelsService.changeWheels(car, wheelSize);
            return true;
        } else {
            return false;
        }
    }

    boolean addOptionInCar(ChangeOption changeOption, Car car, Option option) {
        if (changeOption != null && car != null && option != null) {
            changeOption.addOptionToList(car, option);
            return true;
        } else {
            return false;
        }
    }

    boolean deleteOptionInCar(ChangeOption changeOption, Car car, Option option) {
        if (changeOption != null && car != null && option != null) {
            changeOption.deleteOptionFromList(car, option);
            return true;
        } else {
            return false;
        }
    }
}
