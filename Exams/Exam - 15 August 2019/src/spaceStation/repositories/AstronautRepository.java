package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private List<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public void add(Astronaut astronaut) {
        this.astronauts.add(astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        return this.astronauts.remove(astronaut);
    }

    @Override
    public Astronaut findByName(String name) {
        Astronaut resultAstronaut = null;
        for (Astronaut astronaut : this.astronauts) {
            if (astronaut.getName().equals(name)) {
                resultAstronaut = astronaut;
            }
        }
        return resultAstronaut;
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableList(this.astronauts);
    }
}
