import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Car {
    protected Color color;
    protected final Model model;
    protected final int year;
    protected WheelSize wheelSize;
    protected final EngineVolume engineVolume;
    protected List<String> optionList = new ArrayList<>();

     Car(Color color, Model model, int year, WheelSize wheelSize, EngineVolume engineVolume) {
        this.model = model;
        this.color = color;
        this.wheelSize = wheelSize;
        this.year = year;
        this.engineVolume = engineVolume;
    }

    public void changeColor(Color color) {
         this.color = color;
    }

    public void changeWheels(WheelSize newWheels) {
        wheelSize = newWheels;
    }

    public void addOptionToList(String string) {
        optionList.add(string);
    }

    public void deleteOptionFromList(String string) {
        optionList.remove(string);
    }

    public String  toString() {
        return "Информация об автомобиле:" + '\n' +
                "Цвет авто: " + color +
                ", модель авто: " + model +
                ", год авто: " + year +
                ", размер колес: " + wheelSize +
                ", объем двигателя: " + engineVolume +
                (optionList.size() > 0 ? ", список опций: " + optionList : ",список опций: отсутствуют");
    }

    public boolean compareCarAtWarehouse(Color color, Model model, int year,
                                         WheelSize wheelSize, EngineVolume engineVolume) {
        return this.year == year &&
                this.wheelSize == wheelSize &&
                this.engineVolume == engineVolume &&
                this.color == color &&
                this.model == model;
    }

    public boolean searchCarForChanges(Color color, Model model, int year,
                                       WheelSize wheelSize, EngineVolume engineVolume) {
        return this.year == year &&
                this.engineVolume == engineVolume &&
                this.model == model;
    }

    Color setColor(Color color) {
        this.color = color;
        return color;
    }

    WheelSize setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
        return wheelSize;
    }
}


