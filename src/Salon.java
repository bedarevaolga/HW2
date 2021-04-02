public class Salon {

    Car createNewCarOnFactory(Factory factory, Color color, Model model, int year,
                              WheelSize wheelSize, EngineVolume engineVolume) {
        return factory.createNewCar(color, model, year, wheelSize, engineVolume);
    }

    void changeColorInCar(ChangeColorService changeColorService, Car car, Color color) {
        changeColorService.changeColor(car, color);
    }

    void changeWheelsInCar(ChangeWheelsService changeWheelsService, Car car, WheelSize wheelSize) {
        changeWheelsService.changeWheels(car, wheelSize);
    }

    void addOptionInCar(ChangeOption changeOption, Car car, String string) {
        changeOption.addOptionToList(car, string);
    }

    void deleteOptionInCar(ChangeOption changeOption, Car car, String string) {
        changeOption.deleteOptionFromList(car, string);
    }
}
