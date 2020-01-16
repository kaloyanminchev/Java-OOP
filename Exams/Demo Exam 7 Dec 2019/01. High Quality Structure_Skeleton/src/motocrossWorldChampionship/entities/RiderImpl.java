package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_NAME;
import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_INVALID;

public class RiderImpl implements Rider {
    private static final int MINIMUM_NAME_LENGTH = 5;

    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    public RiderImpl(String name) {
        this.setName(name);
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, MINIMUM_NAME_LENGTH));
        }
        this.name = name;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null) {
            throw new NullPointerException(MOTORCYCLE_INVALID);
        }
        this.motorcycle = motorcycle;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Rider)) {
            return false;
        }
        Rider rider = (Rider) obj;
        return this.getName().equals(rider.getName());
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
