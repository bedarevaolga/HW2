public class ChangeOption extends Service implements OptionChangable {

    @Override
    public void addOptionToList(Car car, String newOption) {
        car.addOptionToList(newOption);
    }

    @Override
    public void deleteOptionFromList(Car car, String option) {
        car.deleteOptionFromList(option);
    }
}
