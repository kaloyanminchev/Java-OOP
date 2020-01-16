package spaceStation.factories;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;

public class AstronautFactory {

    public static Astronaut createAstronaut(String type, String name) {
        Astronaut astronaut = null;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(name);
                break;
            case "Geodesist":
                astronaut = new Geodesist(name);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(name);
                break;
        }
        return astronaut;
    }
}
