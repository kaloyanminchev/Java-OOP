package motocrossWorldChampionship.factories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.motorcycles.PowerMotorcycle;
import motocrossWorldChampionship.entities.motorcycles.SpeedMotorcycle;

public class MotorcycleFactory {

    public static Motorcycle createMotorcycle(String type, String model, int horsePower) {
        Motorcycle motorcycle = null;
        switch (type) {
            case "Speed":
                motorcycle = new SpeedMotorcycle(model, horsePower);
                break;
            case "Power":
                motorcycle = new PowerMotorcycle(model, horsePower);
                break;
        }

        return motorcycle;
    }
}
