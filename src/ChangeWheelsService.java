public class ChangeWheelsService extends Service implements WheelChangeable {

    @Override
    public boolean changeWheels(Car car, WheelSize wheelSize) {
        if (car != null && wheelSize != null) {
            car.changeWheels(wheelSize);
            return true;
        } else {
            return false;
        }
    }
}