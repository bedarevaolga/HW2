public class FactoryBMW extends Factory {

    private final Car bmw1;
    private final Car bmw2;
    private final Car bmw3;

    public FactoryBMW(ChangeWheelsService changeWheelsService,
                      ChangeColorService changeColorService,
                      ChangeOption changeOption) {
        super(changeWheelsService, changeColorService, changeOption);
        warehouse.add(this.bmw1 = new CarBMW(Color.BLUE, 2020, WheelSize.INCHES_19, EngineVolume.MIDSIZE_3000));
        warehouse.add(this.bmw2 = new CarBMW(Color.RED, 2021, WheelSize.INCHES_18, EngineVolume.SUBCOMPACT_1500));
        warehouse.add(this.bmw3 = new CarBMW(Color.GREEN, 2021, WheelSize.INCHES_17, EngineVolume.LARGE_SIZE_3500));
        bmw2.addOptionToList(Option.HEATED_SEATS); // добавила опций чтобы можно было поудалять
        bmw3.addOptionToList(Option.TIRE_PRESSURE_SENSORS);
    }

    public Car createNewCar(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        if (year <= 2021 && year >= 2019) {
            if (color != null && model != null && wheelSize != null && engineVolume != null) {
                Car newBMW = new CarBMW(color, year, wheelSize, engineVolume);
                System.out.println("Мы изготовили для вас новый автомобиль:");
                newBMW.infoAboutCar();
                return newBMW;
            }
            System.out.println("Авто не изготовлено, выберите параметры из списка");
            return null;
        }
        throw new IllegalArgumentException();
    }
}

