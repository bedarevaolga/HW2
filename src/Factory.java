import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public abstract class Factory implements Printable {
    private ChangeWheelsService changeWheelsService;
    private ChangeColorService changeColorService;
    private ChangeOption changeOption;

    public Factory(ChangeWheelsService changeWheelsService, ChangeColorService changeColorService, ChangeOption changeOption) {
        this.changeWheelsService = changeWheelsService;
        this.changeColorService = changeColorService;
        this.changeOption = changeOption;
    }

    public void printCarOption() {
        System.out.println("Информация о возможных для производства характеристиках");
        System.out.println("Выбор цветов автомобиля: " + (Arrays.toString(Color.values())));
        System.out.println("Выбор объёма двигателя: " + (Arrays.toString(EngineVolume.values())));
        System.out.println("Выбор модели автомобиля: " + (Arrays.toString(Model.values())));
        System.out.println("Выбор размера колес: " + (Arrays.toString(WheelSize.values())));
    }

    public Car searchCarAtWarehouse(Color color, Model model, int year,
                                    WheelSize wheelSize, EngineVolume engineVolume) {
        return null;
    }

    public Car searchAppropriateCarAtWarehouse(Color color, Model model, int year,
                                               WheelSize wheelSize, EngineVolume engineVolume) {
        return null;
    }

    public abstract Car createNewCar(Color color, Model model, int year,
                                     WheelSize wheelSize, EngineVolume engineVolume);
}

