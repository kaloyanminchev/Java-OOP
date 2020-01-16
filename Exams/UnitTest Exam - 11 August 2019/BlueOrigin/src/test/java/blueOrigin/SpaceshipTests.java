package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceshipTests {
    private static final String NAME = "Apolo";
    private static final int CAPACITY = 2;
    private Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("Apolo", CAPACITY);
        this.astronaut = new Astronaut("Armstrong", 0.8d);
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnExceptionWhenNameIsNull() {
        this.spaceship = new Spaceship(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnExceptionWhenNameIsEmpty() {
        this.spaceship = new Spaceship("", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithNegativeCapacity() {
        this.spaceship = new Spaceship(NAME, -1);
    }

    @Test
    public void shouldReturnNameOfSpaceship() {
        assertEquals(NAME, this.spaceship.getName());
    }

    @Test
    public void shouldReturnCapacityOfSpaceship() {
        assertEquals(CAPACITY, this.spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldReturnExceptionWhenSizeAndCapacityAreEqual() {
        this.spaceship.add(this.astronaut);
        this.spaceship.add(new Astronaut("Mark", 0.6d));
        this.spaceship.add(new Astronaut("John", 0.7d));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldReturnExceptionAstronautIsPresent() {
        this.spaceship.add(this.astronaut);
        this.spaceship.add(this.astronaut);
    }

    @Test
    public void shouldReturnTheCountOfAstronautsInTheSpaceship() {
        this.spaceship.add(this.astronaut);

        assertEquals(1, this.spaceship.getCount());
    }

    @Test
    public void shouldReturnTrueWhenAstronautIsRemoved() {
        this.spaceship.add(this.astronaut);
        this.spaceship.add(new Astronaut("John", 0.7d));
        this.spaceship.remove(this.astronaut.getName());

        assertEquals(1, this.spaceship.getCount());
//        assertTrue("Astronaut is removed!", this.spaceship.remove("John"));
    }
}
