package needForSpeed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = Vehicle.DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double neededFuel = this.fuelConsumption * kilometers;
        if (hasEnoughFuel(neededFuel)) {
            this.fuel -= neededFuel;
        }
    }

    private boolean hasEnoughFuel(double neededFuel) {
        return this.fuel >= neededFuel;
    }
}
