package Services;

import Cars.Car;
import Enum.Color;

public class ChangeColorService extends Service implements ColorChangeable {

    @Override
    public Car changeColor(Car car, Color color) {
        if (car != null && color != null) {
            if (car.changeColor(color)) {
                return car;
            }
        }
        return null;
    }
}