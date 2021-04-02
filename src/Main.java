public class Main {
    public static void main(String[] args) {
        CarPorsche porsche = new CarPorsche(Color.BLACK, 2021, WheelSize.INCHES17, EngineVolume.LARGESIZE_3500);
        porsche.changeColor(Color.RED);
        porsche.changeWheels(WheelSize.INCHES19);

        System.out.println(porsche.toString());

        ChangeColorService changeColorService = new ChangeColorService();
        changeColorService.changeColor(porsche, Color.GREEN);

        ChangeWheelsService changeWheelsService = new ChangeWheelsService();
        changeWheelsService.changeWheels(porsche, WheelSize.INCHES20);

        ChangeOption changeOption = new ChangeOption();
        changeOption.addOptionToList(porsche, "Подогрев сидений");

        System.out.println(porsche.toString());

        Factory factoryBMW = new FactoryBMW(changeWheelsService, changeColorService, changeOption);
        Factory factoryVolkswagen = new FactoryVolkswagen(changeWheelsService, changeColorService, changeOption);

        factoryBMW.printCarOption();

        Car newCarBMW = factoryBMW.createNewCar(Color.GREEN, Model.BMW, 2021,
                WheelSize.INCHES20, EngineVolume.LARGESIZE_3500);

        Car customerCar = factoryBMW.searchCarAtWarehouse(Color.RED, Model.BMW, 2020,
                WheelSize.INCHES19, EngineVolume.MIDSIZE_3000);

        Car upgradeAppropriateCar = factoryBMW.searchAppropriateCarAtWarehouse(
                Color.BLACK, Model.BMW, 2021, WheelSize.INCHES20, EngineVolume.SUBCOMPACT_1500);

        Salon salon = new Salon();
        salon.createNewCarOnFactory(factoryVolkswagen, Color.YELLOW, Model.VOLKSWAGEN, 2020,
                WheelSize.INCHES19, EngineVolume.MIDSIZE_3000);
        salon.changeColorInCar(changeColorService, newCarBMW, Color.RED);
        System.out.println(newCarBMW.toString());
    }
}


