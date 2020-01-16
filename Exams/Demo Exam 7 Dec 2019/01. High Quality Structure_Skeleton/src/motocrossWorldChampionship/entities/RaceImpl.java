package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private static final int MINIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_LAPS = 1;

    private String name;
    private int laps;
    private Collection<Rider> riders;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return Collections.unmodifiableCollection(this.riders);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, MINIMUM_NAME_LENGTH));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < MINIMUM_LAPS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, MINIMUM_LAPS));
        }
        this.laps = laps;
    }

    @Override
    public void addRider(Rider rider) {
        if (rider == null) {
            throw new NullPointerException(RIDER_INVALID);
        }

        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(RIDER_NOT_PARTICIPATE, rider.getName()));
        }

        if (this.riders.contains(rider)) {
            throw new IllegalArgumentException(String.format(RIDER_ALREADY_ADDED, rider.getName(), this.name));
        }

        this.riders.add(rider);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Race)) {
            return false;
        }
        Race race = (Race) obj;
        return this.getName().equals(race.getName());
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
