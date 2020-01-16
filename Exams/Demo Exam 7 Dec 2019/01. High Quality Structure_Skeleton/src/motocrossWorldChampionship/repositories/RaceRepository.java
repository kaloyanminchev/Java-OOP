package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.RACE_EXISTS;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public void add(Race race) {
        if (this.races.contains(race)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, race.getName()));
        }
        this.races.add(race);
    }

    @Override
    public boolean remove(Race race) {
        return this.races.remove(race);
    }

    @Override
    public Race getByName(String name) {
        return this.races.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }
}
