import java.util.Arrays;

public class Car {
    Color color;
    final Model model;
    final int year;
    WheelSize wheelSize;
    final EngineVolume engineVolume;
    String[] optionList = new String[0];

    public Car(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        this.model = model;
        this.color = color;
        this.wheelSize = wheelSize;
        this.year = year;
        this.engineVolume = engineVolume;
    }

    public void changeColor(Color newColor) {
        color = newColor;
    }

    public void changeWheels(WheelSize newWheels) {
        wheelSize = newWheels;
    }

    public void addOptionToList(String newOption) {
        optionList = Arrays.copyOf(optionList, optionList.length + 1);
        optionList[optionList.length - 1] = newOption;
    }

    public void deleteOptionFromList(String option) {
        for (int a = 0; a < optionList.length; a++) {
            if (optionList[a].equalsIgnoreCase(option)) {
                for (int b = a; b < optionList.length - 1; b++) {
                    optionList[a] = optionList[a + 1];
                }
                optionList = Arrays.copyOf(optionList, optionList.length - 1);
            }
        }
    }

    public void carInformation() {
        System.out.println("Информация об автомобиле: ");
        System.out.println("Цвет авто: " + color);
        System.out.println("модель авто: " + model);
        System.out.println("год авто: " + year);
        System.out.println("размер колес: " + wheelSize);
        System.out.println("объем двигателя: " + engineVolume);
        if (optionList.length > 0) {
            System.out.println("Список опций: " + Arrays.toString(optionList));
        } else {
            System.out.println("Список опций: отсутствуют");
        }
        System.out.println();
    }
}


