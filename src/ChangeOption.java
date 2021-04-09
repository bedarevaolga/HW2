public class ChangeOption extends Service implements OptionChangable {

    @Override
    public boolean addOptionToList(Car car, Option option) {
        if (car != null && option != null) {
            car.addOptionToList(option);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteOptionFromList(Car car, Option option) {
        if (car != null && option != null) {
            car.deleteOptionFromList(option);
            return true;
        } else {
            return false;
        }
    }
}
