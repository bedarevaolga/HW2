import java.util.Scanner;

public class CaseMenu {

    private final Scanner scanner;

    public CaseMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    Salon salon = new Salon();
    ChangeColorService changeColorService = new ChangeColorService();
    ChangeWheelsService changeWheelsService = new ChangeWheelsService();
    ChangeOption changeOption = new ChangeOption();
    Factory factoryBMW = new FactoryBMW(changeWheelsService, changeColorService, changeOption);
    Factory factoryKia = new FactoryKia(changeWheelsService, changeColorService, changeOption);
    Factory factoryMazda = new FactoryMazda(changeWheelsService, changeColorService, changeOption);
    Factory factoryPorsche = new FactoryPorsche(changeWheelsService, changeColorService, changeOption);
    Factory factoryVolkswagen = new FactoryVolkswagen(changeWheelsService, changeColorService, changeOption);

    private void printMenu() {
        System.out.println("Вы в главном меню");
        System.out.println("1. Для изготовления нового автомобиля введите 1");
        System.out.println("2. Для замены цвета в авто со склада введите 2");
        System.out.println("3. Для замены колес в авто со склада введите 3");
        System.out.println("4. Для добавления опций в авто со склада введите 4");
        System.out.println("5. Для удаления опций в авто со склада введите 5");
        System.out.println("6. Для выхода из приложения введите 6");
    }

    public void start() {
        if (this.scanner != null) {
            int key;
            printMenu();
            do {
                key = getInt();
                switch (key) {
                    case 1:
                        System.out.println("Вы выбрали 1: Изготовление нового авто.");
                        choiceModel();
                        printMenu();
                        break;
                    case 2:
                        System.out.println("Вы выбрали 2: Замена цвета в авто.");
                        Car customerCar1 = choiceCarAtWarehouse();
                        if (customerCar1 != null) {
                            System.out.println("Выбор замены: ");
                            Color newColor = choiceColor();
                            if (customerCar1.color != newColor) {
                                // не знаю насколько это необходимо, но решила не менять цвет авто на такой же
                                salon.changeColorInCar(changeColorService, customerCar1, newColor);
                            } else {
                                System.out.println("Услуга не выполнена, вы выбрали уже имеющийся цвет," +
                                        " не вижу смысла делать бесполезную работу))");
                            }
                        } else {
                            System.out.println(" Услуга не выполнена, начните сначала");
                        }
                        printMenu();
                        break;
                    case 3:
                        System.out.println("Вы выбрали : Замена колес в авто.");
                        Car customerCar2 = choiceCarAtWarehouse();
                        if (customerCar2 != null) {
                            System.out.println("Выбор замены: ");
                            WheelSize newWheelSize = choiceWheelSize();
                            if (customerCar2.wheelSize != newWheelSize) {
                                // см. case 2
                                salon.changeWheelsInCar(changeWheelsService, customerCar2, newWheelSize);
                            } else {
                                System.out.println("Услуга не выполнена, вы выбрали уже имеющийся колеса," +
                                        " не вижу смысла делать бесполезную работу))");
                            }
                        } else {
                            System.out.println(" Услуга не выполнена, начните сначала");
                        }
                        printMenu();
                        break;
                    case 4:
                        System.out.println(" Вы выбрали : добавлениe опций в авто со склада");
                        Car customerCar3 = choiceCarAtWarehouse();
                        if (customerCar3 != null) {
                            if (salon.addOptionInCar(changeOption, customerCar3, choiceNewOption())) {
                                customerCar3.infoAboutCar();
                            }
                        } else {
                            System.out.println(" Услуга не выполнена, начните сначала");
                        }
                        printMenu();
                        break;
                    case 5:
                        System.out.println("Вы выбрали : удаление опций в авто со склада");
                        Car customerCar4 = choiceCarAtWarehouse();
                        if (customerCar4 != null) {
                            Option option = choiceNewOption();
                            if (salon.deleteOptionInCar(changeOption, customerCar4, option)) {
                                customerCar4.infoAboutCar();
                            } else {
                                System.out.println(" Услуга не выполнена, начните сначала");
                            }
                        } else {
                            System.out.println(" Услуга не выполнена, начните сначала");
                        }
                        printMenu();
                        break;
                    case 6:
                        scanner.close();
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...\n");
                }
            } while (key != 6);
        }
    }

    public int getInt() {
        System.out.print("Введите цифру");
        while (!scanner.hasNextInt()) {
            System.out.print("Вы ввели не цифру!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public Car choiceModel() {
        System.out.println("Выберите марку авто");
        int key;
        System.out.println("1. Для изготовления нового автомобиля " + Model.BMW + " введите 1");
        System.out.println("2. Для изготовления нового автомобиля " + Model.KIA + " введите 2");
        System.out.println("3. Для изготовления нового автомобиля " + Model.MAZDA + " введите 3");
        System.out.println("4. Для изготовления нового автомобиля " + Model.PORSCHE + " введите 4");
        System.out.println("5. Для изготовления нового автомобиля " + Model.VOLKSWAGEN + " введите 5");
        System.out.println("6. Вернуться в меню");

        do {
            key = getInt();
            switch (key) {
                case 1:
                    System.out.println("Вы выбрали 1: Изготовление нового авто BMW.");
                    return salon.createNewCarOnFactory(factoryBMW, choiceColor(), Model.BMW, 2021,
                            choiceWheelSize(), choiceEngineVolume());
                case 2:
                    System.out.println("Вы выбрали 2: Изготовление нового авто Kia.");
                    return salon.createNewCarOnFactory(factoryKia, choiceColor(), Model.KIA, 2021,
                            choiceWheelSize(), choiceEngineVolume());
                case 3:
                    System.out.println("Вы выбрали 3: Изготовление нового авто Mazda.");
                    return salon.createNewCarOnFactory(factoryMazda, choiceColor(), Model.MAZDA, 2021,
                            choiceWheelSize(), choiceEngineVolume());
                case 4:
                    System.out.println("Вы выбрали 4: Изготовление нового авто Porsche.");
                    return salon.createNewCarOnFactory(factoryPorsche, choiceColor(), Model.PORSCHE, 2021,
                            choiceWheelSize(), choiceEngineVolume());
                case 5:
                    System.out.println("Вы выбрали 5: Изготовление нового авто Volkswagen.");
                    return salon.createNewCarOnFactory(factoryVolkswagen, choiceColor(), Model.VOLKSWAGEN, 2021,
                            choiceWheelSize(), choiceEngineVolume());
                case 6:
                    System.out.println("Вы выбрали 6: Вернуться в меню.");
                    start();
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 6);
        return null;
    }

    private void printColorMenu() {
        System.out.println("1. Для изготовления нового автомобиля " + Color.GREEN + " введите 1");
        System.out.println("2. Для изготовления нового автомобиля " + Color.RED + " введите 2");
        System.out.println("3. Для изготовления нового автомобиля " + Color.BLUE + " введите 3");
        System.out.println("4. Для изготовления нового автомобиля " + Color.BLACK + " введите 4");
        System.out.println("5. Для изготовления нового автомобиля " + Color.WHITE + " введите 5");
        System.out.println("6. Для изготовления нового автомобиля " + Color.YELLOW + " введите 6");
        System.out.println("7. Вернуться в меню");
    }

    public Color choiceColor() {
        System.out.println("Выберите цвет авто: ");
        int key;
        printColorMenu();
        do {
            key = getInt();
            switch (key) {
                case 1:
                    System.out.println("Вы выбрали 1: зеленый автомобиль.");
                    return Color.GREEN;
                case 2:
                    System.out.println("Вы выбрали 2: красный автомобиль.");
                    return Color.RED;
                case 3:
                    System.out.println("Вы выбрали 3:синий автомобиль.");
                    return Color.BLUE;
                case 4:
                    System.out.println("Вы выбрали 4: черный автомобиль.");
                    return Color.BLACK;
                case 5:
                    System.out.println("Вы выбрали 5: белый автомобиль.");
                    return Color.WHITE;
                case 6:
                    System.out.println("Вы выбрали 6: желтый автомобиль.");
                    return Color.YELLOW;
                case 7:
                    System.out.println("Вы выбрали 7: Вернуться в меню.");
                    start();
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 7);
        return null;
    }

    public void printWheelSize() {
        System.out.println("1. Для выбора размера колес нового автомобиля " + WheelSize.INCHES_17 + " введите 1");
        System.out.println("2. Для выбора размера колес нового автомобиля " + WheelSize.INCHES_18 + " введите 2");
        System.out.println("3. Для выбора размера колес нового автомобиля " + WheelSize.INCHES_19 + " введите 3");
        System.out.println("4. Для выбора размера колес нового автомобиля " + WheelSize.INCHES_20 + " введите 4");
        System.out.println("5. Вернуться в меню");
    }

    public WheelSize choiceWheelSize() {
        System.out.println("Выберите размер колес");
        int key;
        printWheelSize();
        do {
            key = getInt();
            switch (key) {
                case 1:
                    System.out.println("Вы выбрали 1: колеса 17 дюймов");
                    return WheelSize.INCHES_17;
                case 2:
                    System.out.println("Вы выбрали 2: колеса 18 дюймов");
                    return WheelSize.INCHES_18;
                case 3:
                    System.out.println("Вы выбрали 3: колеса 19 дюймов");
                    return WheelSize.INCHES_19;
                case 4:
                    System.out.println("Вы выбрали 4: колеса 20 дюймов");
                    return WheelSize.INCHES_20;
                case 5:
                    System.out.println("Вы выбрали 7: Вернуться в меню.");
                    start();
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 5);
        return null;
    }

    public EngineVolume choiceEngineVolume() {
        System.out.println("Выберите объем двигателя");
        int key;
        System.out.println("1. Для выбора  " + EngineVolume.MIDSIZE_3000 + " введите 1");
        System.out.println("2. Для выбора  " + EngineVolume.LARGE_SIZE_3500 + " введите 2");
        System.out.println("3. Для выбора  " + EngineVolume.MINI_CAR_1100 + " введите 3");
        System.out.println("4. Для выбора  " + EngineVolume.SUBCOMPACT_1500 + " введите 4");
        System.out.println("5. Вернуться в меню");
        do {
            key = getInt();
            switch (key) {
                case 1:
                    System.out.println("Вы выбрали 1: Объем двигателя 3000");
                    return EngineVolume.MIDSIZE_3000;
                case 2:
                    System.out.println("Вы выбрали 2: Объем двигателя 3500");
                    return EngineVolume.LARGE_SIZE_3500;
                case 3:
                    System.out.println("Вы выбрали 3: Объем двигателя 1100");
                    return EngineVolume.MINI_CAR_1100;
                case 4:
                    System.out.println("Вы выбрали 4: Объем двигателя 1500");
                    return EngineVolume.SUBCOMPACT_1500;
                case 5:
                    System.out.println("Вы выбрали 5: Вернуться в меню.");
                    start();
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 5);
        return null;
    }

    public void printFactories() {
        System.out.println("1. Завод " + Model.BMW + " введите 1");
        System.out.println("2. Завод " + Model.KIA + " введите 2");
        System.out.println("3. Завод " + Model.MAZDA + " введите 3");
        System.out.println("4. Завод " + Model.PORSCHE + " введите 4");
        System.out.println("5. Завод " + Model.VOLKSWAGEN + " введите 5");
        System.out.println("6. Вернуться в меню");
    }

    public Car choiceCarAtWarehouse() {
        System.out.println("На скдладе какого завода находится авто для изменений? " +
                "(Следующие вопросы будут о машине, которая находится на складе)");
        int key;
        printFactories();
        do {
            key = getInt();
            switch (key) {
                case 1:
                    if (factoryBMW.warehouse.size() > 0) {
                        System.out.println("Вы выбрали авто на складе завода БМВ");
                        return factoryBMW.searchCarAtWarehouse(choiceColor(), Model.BMW, choiceYear(),
                                choiceWheelSize(), choiceEngineVolume());
                    }
                    System.out.println("Склад завода BMW пуст");
                    return null;
                case 2:
                    if (factoryKia.warehouse.size() > 0) {
                        System.out.println("Вы выбрали авто на складе завода Kia");
                        return factoryKia.searchCarAtWarehouse(choiceColor(), Model.KIA, choiceYear(),
                                choiceWheelSize(), choiceEngineVolume());
                    }
                    System.out.println("Склад завода Kia пуст");
                    return null;
                case 3:
                    if (factoryMazda.warehouse.size() > 0) {
                        System.out.println("Вы выбрали авто на складе завода Mazda");
                        return factoryMazda.searchCarAtWarehouse(choiceColor(), Model.MAZDA, choiceYear(),
                                choiceWheelSize(), choiceEngineVolume());
                    }
                    System.out.println("Склад завода Mazda пуст");
                    return null;
                case 4:
                    if (factoryPorsche.warehouse.size() > 0) {
                        System.out.println("Вы выбрали авто на складе завода Porsche");
                        return factoryPorsche.searchCarAtWarehouse(choiceColor(), Model.PORSCHE, choiceYear(),
                                choiceWheelSize(), choiceEngineVolume());
                    }
                    System.out.println("Склад завода Porsche пуст");
                    return null;
                case 5:
                    if (factoryVolkswagen.warehouse.size() > 0) {
                        System.out.println("Вы выбрали авто на складе завода Volkswagen");
                        return factoryVolkswagen.searchCarAtWarehouse(choiceColor(), Model.VOLKSWAGEN, choiceYear(),
                                choiceWheelSize(), choiceEngineVolume());
                    }
                    System.out.println("Склад завода Volkswagen пуст");
                    return null;
                case 6:
                    System.out.println("Вы выбрали 6: Вернуться в меню.");
                    start();
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 6);
        return null;
    }

    public int choiceYear() {
        System.out.println(" Выберите год авто");
        int key;
        System.out.println("1. 2019 - введите 1");
        System.out.println("2. 2020 - введите 2");
        System.out.println("3. 2021 - введите 3");
        System.out.println("4. Вернуться в меню");

        do {
            key = getInt();
            switch (key) {
                case 1:
                    System.out.println("Вы выбрали авто 2019г");
                    return 2019;
                case 2:
                    System.out.println("Вы выбрали авто 2020г");
                    return 2020;
                case 3:
                    System.out.println("Вы выбрали авто 2021г");
                    return 2021;
                case 4:
                    System.out.println("Вы выбрали 4: Вернуться в меню.");
                    start();
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 4);
        return 0;
    }

    public void printOptionList() {
        System.out.println("Выберите опцию");
        System.out.println("1. Для выбора  " + Option.HEATED_SEATS + " введите 1");
        System.out.println("2. Для выбора  " + Option.AUTO_LOCK_DOOR + " введите 2");
        System.out.println("3. Для выбора  " + Option.TIRE_PRESSURE_SENSORS + " введите 3");
        System.out.println("4. Вернуться в меню");
    }

    public Option choiceNewOption() {
        int key;
        printOptionList();
        do {
            key = getInt();
            switch (key) {
                case 1:
                    System.out.println("Вы выбрали 1: Подогрев сидений");
                    return Option.HEATED_SEATS;
                case 2:
                    System.out.println("Вы выбрали 2: автоблокировка дверей");
                    return Option.AUTO_LOCK_DOOR;
                case 3:
                    System.out.println("Вы выбрали 3: датчики давления в шинах");
                    return Option.TIRE_PRESSURE_SENSORS;
                case 4:
                    System.out.println("Вы выбрали 4: Вернуться в меню.");
                    start();
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 4);
        return null;
    }
}



