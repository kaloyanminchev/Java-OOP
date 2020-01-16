package aquarium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void setUp() {
        this.aquarium = new Aquarium("Aqualand", 2);
        this.fish = new Fish("Nemo");
    }

    @Test(expected = NullPointerException.class)
    public void initConstructorShouldThrowExceptionIfNameIsNull() {
        this.aquarium = new Aquarium(null, 20);
    }

    @Test(expected = NullPointerException.class)
    public void initConstructorShouldThrowExceptionIfNameIsEmpty() {
        this.aquarium = new Aquarium("  ", 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initConstructorShouldThrowExceptionIfCapacityBelowZero() {
        this.aquarium = new Aquarium("Nemo", -1);
    }

    @Test
    public void getNameMethodShouldReturnAquariumName() {
        assertEquals("Aqualand", this.aquarium.getName());
    }

    @Test
    public void getCapacityMethodShouldReturnCapacityOfAquarium() {
        assertEquals(2, this.aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowExceptionIfAquariumIsFull() {
        this.aquarium.add(this.fish);
        this.aquarium.add(this.fish);
        this.aquarium.add(this.fish);
    }

    @Test
    public void addMethodShouldIncreaseCount() {
        this.aquarium.add(this.fish);
        this.aquarium.add(new Fish("Coco"));

        assertEquals(2, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeMethodShouldThrowExceptionIfFishIsAbsent() {
        this.aquarium.add(this.fish);
        this.aquarium.add(new Fish("Coco"));
        this.aquarium.remove("Pepi");
    }

    @Test
    public void removeMethodShouldRemoveFishByGivenName() {
        this.aquarium.add(this.fish);
        this.aquarium.add(new Fish("Coco"));
        this.aquarium.remove("Nemo");

        assertEquals(1, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellMethodShouldThrowExceptionIfFishIsAbsent() {
        this.aquarium.add(this.fish);
        this.aquarium.add(new Fish("Coco"));
        this.aquarium.sellFish("Pepi");
    }

    @Test
    public void sellMethodShouldSetFishAvailable() {
        this.aquarium.add(this.fish);
        this.aquarium.add(new Fish("Coco"));
        this.aquarium.sellFish("Nemo");

        assertFalse(this.fish.isAvailable());
    }

    @Test
    public void reportMethodShouldReturnAllFishesInAquarium() {
        this.aquarium.add(this.fish);
        this.aquarium.add(new Fish("Coco"));

        String names = String.join(", ", "Nemo", "Coco");
        String output = String.format("Fish available at %s: %s", this.aquarium.getName(), names);

        assertEquals(output, this.aquarium.report());
    }
}

