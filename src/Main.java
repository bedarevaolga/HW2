public class Main {
    public static void main(String[] args) {


        CarPorsche porsche = new CarPorsche(Color.BLACK, 2021, WheelSize.INCHES17, EngineVolume.LARGESIZE_3500);

        if (!porsche.changeColor(Color.RED)) {
            System.out.println("Услуга не выполнена. Выберите цвет из списка");
        }

        try {
            porsche.changeWheels(WheelSize.INCHES19);
        } catch (NullPointerException e) {
            System.out.println("Услуга не выполнена. Выберите колеса из списка");
        }

        if (!porsche.addOptionToList(Option.HEATEDSEATS)) {
            System.out.println("Услуга не выполнена. Выберите опцию из списка");
        }

        if (!porsche.deleteOptionFromList(Option.HEATEDSEATS)) {
            System.out.println("Услуга не выполнена. Выберите опцию из списка");
        }

        porsche.infoAboutCar();

        ChangeColorService changeColorService = new ChangeColorService();
        if (!changeColorService.changeColor(porsche, Color.GREEN)) {
            System.out.println("Услуга не выполнена");
        }

        ChangeWheelsService changeWheelsService = new ChangeWheelsService();
        if (!changeWheelsService.changeWheels(porsche, WheelSize.INCHES20)) {
            System.out.println("Услуга не выполнена");
        }

        ChangeOption changeOption = new ChangeOption();
        if (!changeOption.addOptionToList(porsche, Option.HEATEDSEATS)) {
            System.out.println("Услуга не выполнена");
        }

        porsche.infoAboutCar();

        Factory factoryBMW = new FactoryBMW(changeWheelsService, changeColorService, changeOption);
        Factory factoryVolkswagen = new FactoryVolkswagen(changeWheelsService, changeColorService, changeOption);

        factoryBMW.printCarOption();

        try {
            Car newCarBMW = factoryBMW.createNewCar(Color.GREEN, Model.BMW, 2021,
                    WheelSize.INCHES20, EngineVolume.LARGESIZE_3500);
        } catch (NullPointerException e) {
            System.out.println("Невозможно изготовить такой автомобиль, выберите параметры из списка");
        } catch (IllegalArgumentException e) {
            System.out.println("Невозможно изготовить такой автомобиль, неверный год автомобиля");
        }

        Car customerCar = factoryVolkswagen.searchCarAtWarehouse(Color.GREEN, Model.VOLKSWAGEN, 2020,
                WheelSize.INCHES19, EngineVolume.MIDSIZE_3000);

        try {
            Car upgradeAppropriateCar = factoryBMW.searchAppropriateCarAtWarehouse(
                    Color.BLACK, Model.BMW, 2021, WheelSize.INCHES20, EngineVolume.SUBCOMPACT_1500);
        } catch (NullPointerException e) {
            System.out.println("Даное авто не подходит для изменений");
        }

        Salon salon = new Salon();
        try {
            salon.createNewCarOnFactory(factoryVolkswagen, Color.YELLOW, Model.VOLKSWAGEN, 2020,
                    WheelSize.INCHES19, EngineVolume.MIDSIZE_3000);
        } catch (NullPointerException e) {
            System.out.println("Данное авто изготовить нельзя, выберите параметры из списка");
        } catch (IllegalArgumentException e) {
            System.out.println("Невозможно изготовить такой автомобиль, неверный год автомобиля");
        }

        if (!salon.changeColorInCar(changeColorService, customerCar, Color.RED)) {
            System.out.println("Услуга не выполнена, выберите параметры из списка");
        }

        if (!salon.changeWheelsInCar(changeWheelsService, customerCar, WheelSize.INCHES17)) {
            System.out.println("Услуга не выполнена, выберите параметры из списка");
        }

        if (!salon.addOptionInCar(changeOption, customerCar, Option.AUTOLOCKDOOR)) {
            System.out.println("Услуга не выполнена, выберите параметры из списка");
        }

        if (!salon.deleteOptionInCar(changeOption, customerCar, Option.AUTOLOCKDOOR)) {
            System.out.println("Услуга не выполнена, выберите параметры из списка");
        }

        customerCar.infoAboutCar();
    }
}


