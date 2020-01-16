package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private static final DecimalFormat formatter =
            new DecimalFormat("#.##");
    private double fuelQuantity;
    private double consumption;

    protected VehicleImpl(double fuelQuantity, double consumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setConsumption(consumption);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getConsumption() {
        return this.consumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setConsumption(double litersPerKilometer) {
        this.consumption = litersPerKilometer;
    }

    @Override
    public String drive(double distance) {
        if (canDrive(distance)) {
            this.fuelQuantity -= this.consumption * distance;
            return String.format("travelled %s km", formatter.format(distance));
        } else {
            return "needs refueling";
        }
    }

    private boolean canDrive(double distance) {
        return this.fuelQuantity > this.consumption * distance;
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.fuelQuantity);
    }
}
