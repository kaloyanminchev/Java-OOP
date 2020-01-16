package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_EXISTS;

public class MotorcycleRepository implements Repository<Motorcycle> {
    private Collection<Motorcycle> models;

    public MotorcycleRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(Motorcycle motorcycle) {
        if (this.models.contains(motorcycle)) {
            throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, motorcycle.getModel()));
        }
        this.models.add(motorcycle);
    }

    @Override
    public boolean remove(Motorcycle motorcycle) {
        return this.models.remove(motorcycle);
    }

    @Override
    public Motorcycle getByName(String model) {
        return this.models.stream().filter(m -> m.getModel().equals(model)).findFirst().orElse(null);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }
}
