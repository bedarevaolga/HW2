public class Service {

    public void changeColor(Car car, Color color) {
        car.changeColor(color);
    }
    public void changeWheels(Car car, WheelSize wheelSize) {
        car.changeWheels(wheelSize);
    }
    public void addOptionToList(Car car, String newOption) {
        car.addOptionToList(newOption);
    }
    public void deleteOptionFromList(Car car, String option) {
        car.deleteOptionFromList(option);
    }
}

