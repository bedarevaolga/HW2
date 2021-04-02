import java.util.ArrayList;
import java.util.List;

public class FactoryKia extends Factory {
    List<Car> warehouse = new ArrayList<>();

    public FactoryKia(ChangeWheelsService changeWheelsService,
                      ChangeColorService changeColorService,
                      ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        Car newKia = new CarKia(color, year, wheelSize, engineVolume);
        System.out.println("Мы изготовили для вас новый автомобиль," + newKia.toString());
        return newKia;
    }
}
