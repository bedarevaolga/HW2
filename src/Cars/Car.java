package Cars;

import Enum.WheelSize;
import Enum.Model;
import Enum.Color;
import Enum.Option;
import Enum.EngineVolume;

import java.util.ArrayList;
import java.util.List;

public abstract class Car {

    protected Color color;
    protected final Model model;
    protected final int year;
    protected WheelSize wheelSize;
    protected final EngineVolume engineVolume;
    protected List<Option> optionList;

    Car(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        this.model = model;
        this.color = color;
        this.wheelSize = wheelSize;
        this.year = year;
        this.engineVolume = engineVolume;
    }

    public boolean changeColor(Color color) {
        if (color != null) {
            this.color = color;
            return true;
        }
        return false;
    }

    public boolean changeWheels(WheelSize newWheels) {
        if (newWheels != null) {
            this.wheelSize = newWheels;
            return true;
        }
        return false;
    }

    public boolean addOption(Option option) {
        if (option != null) {
            if (optionList == null) {
                optionList = new ArrayList<>();
            }
            optionList.add(option);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteOptionFromList(Option option) {
        if (option != null) {
            if (optionList != null && optionList.size() > 0) {
                return optionList.remove(option);
            }
        }
        return false;
    }

    public void infoAboutCar() {
        StringBuilder builder = new StringBuilder("Цвет авто: ")
                .append(color)
                .append(", Марка авто: ")
                .append(model)
                .append(", Год авто: ")
                .append(year)
                .append(", Размер колёс авто: ")
                .append(wheelSize)
                .append(", Объём двигателя авто: ")
                .append(engineVolume);
        if (optionList == null || optionList.size() == 0) {
            builder.append(", Список опций: отсутствуют");
        } else {
            builder.append(", Список опций: ")
                    .append(optionList);
        }
        System.out.println("Информация об авто: " + builder);
    }

    public Color getColor() {
        return color;
    }

    public WheelSize getWheelSize() {
        return wheelSize;
    }

    public EngineVolume getEngineVolume() {
        return engineVolume;
    }

    public Model getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

}

