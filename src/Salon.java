public class Salon {
    private Factory factory;
    private Service service;

    Salon(Factory factory, Service service) {
        this.factory = factory;
        this.service = service;
    }

    public Car orderFromFactory(Color newColor, Model newModel, int year, WheelSize newWheelSize, EngineVolume newEngineVolume) {
        return factory.searchAppropriateCarAtWarehouse(newColor, newModel, year, newWheelSize, newEngineVolume);
    }

    Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        Car createNewCar = new Car(color, model, year, wheelSize, engineVolume);
        System.out.println("Мы изготовили для вас новый автомобиль: ");
        System.out.println("Цвет авто: " + color);
        System.out.println("модель авто: " + model);
        System.out.println("год авто: " + year);
        System.out.println("размер колес: " + wheelSize);
        System.out.println("объем двигателя: " + engineVolume);
        return createNewCar;
    }
}
