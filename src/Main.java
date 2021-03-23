public class Main {
    public static void main(String[] args) {
        Car car = new Car(Color.BLACK, Model.BMW, 2021, WheelSize.INCHES17, EngineVolume.LARGESIZE_3500);
        car.changeColor(Color.RED);
        car.changeWheels(WheelSize.INCHES19);

        Service service = new Service();
        service.changeColor(car, Color.GREEN);
        service.changeWheels(car, WheelSize.INCHES20);

        car.carInformation();

        Factory factory = new Factory(service);
        factory.printCarOption();
        Car customerCar = factory.searchCarAtWarehouse(Color.BLACK, Model.MAZDA, 2021, WheelSize.INCHES17, EngineVolume.MIDSIZE_3000);
        Car upgradeAppropriateCar = factory.searchAppropriateCarAtWarehouse(Color.YELLOW, Model.VOLKSWAGEN, 2021, WheelSize.INCHES20, EngineVolume.SUBCOMPACT_1500);

        Salon salon = new Salon(factory, service);
        salon.orderFromFactory(Color.YELLOW, Model.MAZDA, 2021, WheelSize.INCHES18, EngineVolume.MINICAR_1100);
        salon.createNewCar(Color.GREEN, Model.PORSCHE, 2021, WheelSize.INCHES20, EngineVolume.LARGESIZE_3500);
    }
}
