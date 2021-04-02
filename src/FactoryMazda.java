import java.util.ArrayList;
import java.util.List;

public class FactoryMazda extends Factory {
    List<Car> warehouse = new ArrayList<>();

    public FactoryMazda(ChangeWheelsService changeWheelsService,
                        ChangeColorService changeColorService,
                        ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        Car newMazda = new CarMazda(color, year, wheelSize, engineVolume);
        System.out.println("Мы изготовили для вас новый автомобиль," + newMazda.toString());
        return newMazda;
    }
}
