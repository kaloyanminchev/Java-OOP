package motocrossWorldChampionship.entities.motorcycles;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;

public class PowerMotorcycle extends MotorcycleImpl {
    private static final double CUBIC_CENTIMETERS = 450;
    private static final int MIN_HORSEPOWER = 70;
    private static final int MAX_HORSEPOWER = 100;

    public PowerMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < MIN_HORSEPOWER || horsePower > MAX_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
//        super.setHorsePower(horsePower);
    }
}
