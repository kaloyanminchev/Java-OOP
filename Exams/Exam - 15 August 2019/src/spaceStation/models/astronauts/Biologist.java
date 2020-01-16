package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_UNITS = 70;
    private static final double DECREASE_UNITS = 5;

    public Biologist(String name) {
        super(name, INITIAL_UNITS);
    }

    @Override
    public void breath() {
        if (this.getOxygen() - DECREASE_UNITS < 0) {
            this.setOxygen(0);
        } else {
            this.setOxygen(this.getOxygen() - DECREASE_UNITS);
        }
    }
}
