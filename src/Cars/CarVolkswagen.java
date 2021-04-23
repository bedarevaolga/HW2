package Cars;

import Enum.*;

public class CarVolkswagen extends Car {

    public CarVolkswagen(Color color, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        super(color, Model.VOLKSWAGEN, year, wheelSize, engineVolume);
    }
}
