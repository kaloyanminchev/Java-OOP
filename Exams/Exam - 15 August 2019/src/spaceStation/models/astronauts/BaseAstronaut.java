package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseAstronaut implements Astronaut {
    private static final double DECREASE_UNITS = 10;

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.equals("null") || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public void breath() {
        if (this.oxygen - DECREASE_UNITS < 0) {
            this.setOxygen(0);
        } else {
            this.setOxygen(this.oxygen - DECREASE_UNITS);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_ASTRONAUT_NAME, this.name))
                .append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_OXYGEN, this.oxygen))
                .append(System.lineSeparator());

        if (this.bag.getItems().size() == 0) {
            sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none"));
        } else {
            sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,
                    String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.bag.getItems())));
        }

        return sb.toString();
    }
}
