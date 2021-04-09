import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Factory implements Printable {

    protected final List<Car> warehouse = new ArrayList<>();

    public Factory(ChangeWheelsService changeWheelsService, ChangeColorService changeColorService,
                   ChangeOption changeOption) {
    }

    public void printCarOption() {
        String builder = "Информация о возможных для производства характеристиках" + "\n" +
                "Выбор цветов автомобиля: " + (Arrays.toString(Color.values())) + "\n" +
                "Выбор объёма двигателя: " + (Arrays.toString(EngineVolume.values())) + "\n" +
                "Выбор размера колес: " + (Arrays.toString(WheelSize.values())) + "\n";
        System.out.println(builder);
    }

    public Car searchCarAtWarehouse(Color color, Model model, int year,
                                    WheelSize wheelSize, EngineVolume engineVolume) {
        for (int i = 0; i < warehouse.size(); i++) {
            Car checkedCar = warehouse.get(i);
            if (checkedCar.compareCarAtWarehouse(color, model, year, wheelSize, engineVolume)) {
                warehouse.remove(i);
                System.out.println("Данное авто есть на складе");
                return checkedCar;
            }
        }
        System.out.println("Данного авто нет на складе");
        return null;
    }

    public Car searchAppropriateCarAtWarehouse(Color color, Model model, int year,
                                               WheelSize wheelSize, EngineVolume engineVolume) {
        if (color != null && wheelSize != null) {
            for (int i = 0; i < warehouse.size(); i++) {
                Car checkedCar = warehouse.get(i);
                if (checkedCar.searchCarForChanges(model, year, engineVolume)) {
                    checkedCar.changeColor(color);
                    checkedCar.changeWheels(wheelSize);
                    warehouse.remove(i);
                    System.out.println("Есть подходящее авто для апгрейда");
                    return checkedCar;
                }
            }
            System.out.println("подходящего авто для апгрейда нет");
            return null;
        } else {
            throw new NullPointerException();
        }
    }

    public abstract Car createNewCar(Color color, Model model, int year,
                                     WheelSize wheelSize, EngineVolume engineVolume);
}

