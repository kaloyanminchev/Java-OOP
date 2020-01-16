package aquarium.models.aquariums;

import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish f : this.fish) {
            f.eat();
        }
    }

    @Override
    public String getInfo() {
        String fishNames;
        if (this.fish.isEmpty()) {
            fishNames = "none";
        } else {
            List<String> names = new ArrayList<>();
            for (Fish f : this.fish) {
                names.add(f.getName());
            }
            fishNames = String.join(" ", names);
        }

        String result = String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()) +
                System.lineSeparator() +
                String.format("Fish: %s", fishNames) +
                System.lineSeparator() +
                String.format("Decorations: %d", this.decorations.size()) +
                System.lineSeparator() +
                String.format("Comfort: %d", this.decorations.stream().mapToInt(Decoration::getComfort).sum());

        return result.trim();
    }
}
