package motocrossWorldChampionship.entities.motorcycles;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_MODEL;

public abstract class MotorcycleImpl implements Motorcycle {
    private static final int MINIMUM_MODEL_LENGTH = 4;

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < MINIMUM_MODEL_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, MINIMUM_MODEL_LENGTH));
        }
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters / this.horsePower * laps;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Motorcycle)) {
            return false;
        }

        Motorcycle other = (Motorcycle) o;
        return this.getModel().equals(other.getModel());
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
