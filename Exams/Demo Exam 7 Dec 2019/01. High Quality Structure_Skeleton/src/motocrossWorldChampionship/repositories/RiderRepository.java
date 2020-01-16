package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.RIDER_EXISTS;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> riders;

    public RiderRepository() {
        this.riders = new ArrayList<>();
    }

    @Override
    public void add(Rider rider) {
        if(this.riders.contains(rider)) {
            throw new IllegalArgumentException(String.format(RIDER_EXISTS, rider.getName()));
        }
        this.riders.add(rider);
    }

    @Override
    public boolean remove(Rider rider) {
        return this.riders.remove(rider);
    }

    @Override
    public Rider getByName(String name) {
        return this.riders.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.riders);
    }
}
