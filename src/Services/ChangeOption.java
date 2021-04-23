package Services;

import Cars.Car;
import Enum.Option;

public class ChangeOption extends Service implements OptionChangable {

    @Override
    public Car addOptionToList(Car car, Option option) {
        if (car != null && option != null) {
            if (car.addOption(option)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car deleteOptionFromList(Car car, Option option) {
        if (car != null && option != null) {
            if (car.deleteOptionFromList(option)) {
                return car;
            }
        }
        return null;
    }
}
