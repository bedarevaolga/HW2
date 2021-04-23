package Enum;

public enum Option {

    HEATED_SEATS("Подогрев сидений"),
    AUTO_LOCK_DOOR("автоблокировка дверей"),
    TIRE_PRESSURE_SENSORS("датчики давления в шинах");

    private final String option;

    Option(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
