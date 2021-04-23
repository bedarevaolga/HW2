package Services;

import Cars.Car;
import Enum.WheelSize;

public interface WheelChangeable {

    Car changeWheels(Car car, WheelSize wheelSize);
}
