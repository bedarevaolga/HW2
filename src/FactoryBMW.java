import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactoryBMW extends Factory {
    List<Car> warehouse = new ArrayList<>();

    public FactoryBMW(ChangeWheelsService changeWheelsService,
                      ChangeColorService changeColorService,
                      ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
        warehouse.add(new CarBMW(Color.BLUE, 2020, WheelSize.INCHES19, EngineVolume.MIDSIZE_3000));
        warehouse.add(new CarBMW(Color.RED, 2021, WheelSize.INCHES18, EngineVolume.SUBCOMPACT_1500));
        warehouse.add(new CarBMW(Color.GREEN, 2021, WheelSize.INCHES17, EngineVolume.LARGESIZE_3500));
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        Car newBMW = new CarBMW(color, year, wheelSize, engineVolume);
        System.out.println("Мы изготовили для вас новый автомобиль," + newBMW.toString());
        return newBMW;
    }

    @Override
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
        return new CarBMW(color, year, wheelSize, engineVolume);
    }

    public Car searchAppropriateCarAtWarehouse(Color color, Model model, int year,
                                               WheelSize wheelSize, EngineVolume engineVolume) {
        for (int i = 0; i < warehouse.size(); i++) {
            if (warehouse.get(i).searchCarForChanges(color, model, year, wheelSize, engineVolume)) {
                Car car = warehouse.get(i);
                warehouse.get(i).changeColor(color);
                warehouse.get(i).changeWheels(wheelSize);
                warehouse.remove(i);
                System.out.println("Есть подходящее авто для апгрейда");
                return car;
            }
        }
        System.out.println("подходящего авто для апгрейда нет");
        return null;
    }
}
