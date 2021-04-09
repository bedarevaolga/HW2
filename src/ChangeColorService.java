public class ChangeColorService extends Service implements ColorChangeable {

    @Override
    public boolean changeColor(Car car, Color color) {
        if (car != null && color != null) {
            car.changeColor(color);
            return true;
        } else {
            return false;
        }
    }
}