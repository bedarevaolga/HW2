package Services;

import Cars.Car;
import Enum.Option;

public interface OptionChangable {

    Car addOptionToList(Car car, Option newOption);

    Car deleteOptionFromList(Car car, Option option);
}
