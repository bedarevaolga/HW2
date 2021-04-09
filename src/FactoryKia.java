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
        if (year <= 2021 && year >= 2019) {
            if (color != null && model != null && wheelSize != null && engineVolume != null && year <= 2021 && year >= 2019) {
                Car newKia = new CarKia(color, year, wheelSize, engineVolume);
                System.out.println("Мы изготовили для вас новый автомобиль:");
                newKia.infoAboutCar();
                return newKia;
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
