import java.util.ArrayList;
import java.util.List;

public class FactoryPorsche extends Factory {
    List<Car> warehouse = new ArrayList<>();

    public FactoryPorsche(ChangeWheelsService changeWheelsService,
                          ChangeColorService changeColorService,
                          ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        Car newPorsche = new CarPorsche(color, year, wheelSize, engineVolume);
        System.out.println("Мы изготовили для вас новый автомобиль," + newPorsche.toString());
        return newPorsche;
    }

}

