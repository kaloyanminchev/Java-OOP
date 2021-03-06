package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GunRepository implements Repository<Gun> {
    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(Gun model) {
        if (!this.models.contains(model)) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.models
                .stream()
                .filter(g -> g.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableList(this.models);
    }
}
