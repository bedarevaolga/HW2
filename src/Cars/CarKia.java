package Cars;

import Enum.*;

public class CarKia extends Car {

    public CarKia(Color color, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        super(color, Model.KIA, year, wheelSize, engineVolume);
    }

}
