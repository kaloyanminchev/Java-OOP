package spaceStation.core;

import spaceStation.factories.AstronautFactory;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int exploredPlanetsCount;


    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
        this.exploredPlanetsCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = AstronautFactory.createAstronaut(type, astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        Collections.addAll(planet.getItems(), items);
        this.planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> chosenAstronauts =
                this.astronautRepository
                        .getModels()
                        .stream()
                        .filter(a -> a.getOxygen() > 60)
                        .collect(Collectors.toList());

        if (chosenAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = this.planetRepository.findByName(planetName);
        this.mission.explore(planet, chosenAstronauts);
        this.exploredPlanetsCount++;

        long deadAstronauts = chosenAstronauts
                .stream()
                .filter(a -> a.getOxygen() == 0)
                .count();

        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(REPORT_PLANET_EXPLORED, this.exploredPlanetsCount))
                .append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO);

        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            builder.append(System.lineSeparator())
                    .append(astronaut.toString());
        }

        return builder.toString();
    }
}
