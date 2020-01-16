package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.factories.MotorcycleFactory;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static motocrossWorldChampionship.common.ExceptionMessages.*;
import static motocrossWorldChampionship.common.OutputMessages.*;

public class ChampionshipControllerImpl implements ChampionshipController {
    private static final int MIN_RIDERS_IN_RACE = 3;

    private Repository<Rider> riderRepository;
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Race> raceRepository;

    public ChampionshipControllerImpl(
            Repository<Rider> riderRepository,
            Repository<Motorcycle> motorcycleRepository,
            Repository<Race> raceRepository
    ) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {
        if (this.riderRepository.getByName(riderName) != null) {
            throw new IllegalArgumentException(String.format(RIDER_EXISTS, riderName));
        }
        Rider rider = new RiderImpl(riderName);
        this.riderRepository.add(rider);
        return String.format(RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        Motorcycle motorcycle = MotorcycleFactory.createMotorcycle(type, model, horsePower);
        if (this.motorcycleRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, model));
        }
        this.motorcycleRepository.add(motorcycle);
        return String.format(MOTORCYCLE_CREATED, motorcycle.getClass().getSimpleName(), model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        if (this.motorcycleRepository.getByName(motorcycleModel) == null) {
            throw new NullPointerException(String.format(MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }

        if (this.riderRepository.getByName(riderName) == null) {
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }

        this.riderRepository.getByName(riderName)
                .addMotorcycle(this.motorcycleRepository.getByName(motorcycleModel));

        return String.format(MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        if (this.raceRepository.getByName(raceName) == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (this.riderRepository.getByName(riderName) == null) {
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }

        this.raceRepository.getByName(raceName)
                .addRider(this.riderRepository.getByName(riderName));

        return String.format(RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        if (this.raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        this.raceRepository.add(new RaceImpl(name, laps));
        return String.format(RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (race.getRiders().size() < MIN_RIDERS_IN_RACE) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, MIN_RIDERS_IN_RACE));
        }

        int laps = race.getLaps();

        List<Rider> firstThreeRiders = race
                .getRiders()
                .stream()
                .sorted((r1, r2) ->
                        Double.compare(r2.getMotorcycle().calculateRacePoints(laps),
                                r1.getMotorcycle().calculateRacePoints(laps)))
                .limit(3)
                .collect(Collectors.toList());

        firstThreeRiders.get(0).winRace();
        this.raceRepository.remove(race);

        return String.format(RIDER_FIRST_POSITION, firstThreeRiders.get(0).getName(), raceName)
                + System.lineSeparator()
                + String.format(RIDER_SECOND_POSITION, firstThreeRiders.get(1).getName(), raceName)
                + System.lineSeparator()
                + String.format(RIDER_THIRD_POSITION, firstThreeRiders.get(2).getName(), raceName);
    }
}
