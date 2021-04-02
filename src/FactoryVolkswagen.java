import java.util.ArrayList;
import java.util.List;

public class FactoryVolkswagen extends Factory {
    List<Car> warehouse = new ArrayList<>();

    public FactoryVolkswagen(ChangeWheelsService changeWheelsService,
                             ChangeColorService changeColorService,
                             ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
        warehouse.add(new CarVolkswagen(Color.GREEN, 2020, WheelSize.INCHES19, EngineVolume.MIDSIZE_3000));
        warehouse.add(new CarVolkswagen(Color.RED, 2021, WheelSize.INCHES17, EngineVolume.MINICAR_1100));
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        Car newVolkswagen = new CarVolkswagen(color, year, wheelSize, engineVolume);
        System.out.println("Мы изготовили для вас новый автомобиль," + newVolkswagen.toString());
        return newVolkswagen;
    }

    public Car searchCarAtWarehouse(Color color, Model model, int year,
                                    WheelSize wheelSize, EngineVolume engineVolume) {
        for (int i = 0; i < warehouse.size(); i++) {
            if (warehouse.get(i).compareCarAtWarehouse(color, model, year, wheelSize, engineVolume)) {
                Car car = warehouse.get(i);
                warehouse.remove(i);
                System.out.println("Данное авто есть на складе");
                return car;
            }
        }
        System.out.println("Данного авто нет на складе, но мы его изготовили");
        return new CarVolkswagen(color, year, wheelSize, engineVolume);
    }
}
