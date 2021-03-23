import java.util.Arrays;

public class Factory {
    Model model;
    EngineVolume engineVolume;
    Color color;
    WheelSize wheelSize;
    Car[] warehouse = new Car[5];
    Service service;

    Factory(Service service) {
        this.service = service;
        warehouse[0] = new Car(Color.BLUE, Model.BMW, 2020, WheelSize.INCHES19, EngineVolume.MIDSIZE_3000);
        warehouse[1] = new Car(Color.RED, Model.PORSCHE, 2021, WheelSize.INCHES20, EngineVolume.LARGESIZE_3500);
        warehouse[2] = new Car(Color.GREEN, Model.VOLKSWAGEN, 2021, WheelSize.INCHES18, EngineVolume.SUBCOMPACT_1500);
        warehouse[3] = new Car(Color.BLACK, Model.KIA, 2021, WheelSize.INCHES17, EngineVolume.MIDSIZE_3000);
        warehouse[4] = new Car(Color.YELLOW, Model.MAZDA, 2021, WheelSize.INCHES18, EngineVolume.MINICAR_1100);
    }

    void printCarOption() {
        System.out.println("Информация о возможных для производства характеристиках");
        System.out.println("Выбор цветов автомобиля: " + (Arrays.toString(Color.values())));
        System.out.println("Выбор объёма двигателя: " + (Arrays.toString(EngineVolume.values())));
        System.out.println("Выбор модели автомобиля: " + (Arrays.toString(Model.values())));
        System.out.println("Выбор размера колес: " + (Arrays.toString(WheelSize.values())));
    }

    Car searchCarAtWarehouse(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        for (int i = 0; i < warehouse.length; i++) {
            if (color == warehouse[i].color && model == warehouse[i].model && year == warehouse[i].year &&
                    wheelSize == warehouse[i].wheelSize && engineVolume == warehouse[i].engineVolume) {
                for (int j = i; j < warehouse.length - 1; j++) {
                    warehouse[i] = warehouse[i + 1];
                    warehouse = Arrays.copyOf(warehouse, warehouse.length - 1);
                    System.out.println("Данный автомобиль есть на складе");
                    return warehouse[i];
                }
            }
        }
        if (color == warehouse[warehouse.length - 1].color && model == warehouse[warehouse.length - 1].model && year == warehouse[warehouse.length - 1].year &&
                wheelSize == warehouse[warehouse.length - 1].wheelSize && engineVolume == warehouse[warehouse.length - 1].engineVolume) {
            warehouse = Arrays.copyOf(warehouse, warehouse.length - 1);
            System.out.println("Данный автомобиль есть на складе");
            return warehouse[warehouse.length - 1];
        }
        Car car1 = new Car(color, model, year, wheelSize, engineVolume);
        System.out.println("Данного автомобиля нет на складе, но мы его изготовили");
        return car1;
    }

    Car searchAppropriateCarAtWarehouse(Color color, Model model, int year,
                                        WheelSize wheelSize, EngineVolume engineVolume) {
        for (int i = 0; i < warehouse.length; i++) {
            if (model == warehouse[i].model && year == warehouse[i].year && engineVolume == warehouse[i].engineVolume) {
                warehouse[i].changeColor(color);
                warehouse[i].changeWheels(wheelSize);
                for (int j = i; j < warehouse.length - 1; j++) {
                    warehouse[i] = warehouse[i + 1];
                    warehouse = Arrays.copyOf(warehouse, warehouse.length - 1);
                    System.out.println("Есть подходящее авто для апгрейда");
                    return warehouse[i];
                }
            }
            if (model == warehouse[warehouse.length - 1].model && year == warehouse[warehouse.length - 1].year &&
                    engineVolume == warehouse[warehouse.length - 1].engineVolume) {
                warehouse[warehouse.length - 1].changeColor(color);
                warehouse[warehouse.length - 1].changeWheels(wheelSize);
                warehouse = Arrays.copyOf(warehouse, warehouse.length - 1);
                System.out.println("Есть подходящее авто для апгрейда");
                return warehouse[warehouse.length - 1];
            }
        }
        System.out.println("подходящего авто для апгрейда нет");
        return null;
    }
}


