package Services;

import Cars.Car;
import Enum.WheelSize;

public class ChangeWheelsService extends Service implements WheelChangeable {

    @Override
    public Car changeWheels(Car car, WheelSize wheelSize) {
        if (car != null && wheelSize != null) {
            if (car.changeWheels(wheelSize)) {
                return car;
            }
        }
        return null;
    }
}