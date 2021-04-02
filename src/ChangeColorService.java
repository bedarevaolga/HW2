public class ChangeColorService extends Service implements ColorChangeable{

    @Override
    public void changeColor(Car car, Color color) {
        car.changeColor(color);
    }
}
