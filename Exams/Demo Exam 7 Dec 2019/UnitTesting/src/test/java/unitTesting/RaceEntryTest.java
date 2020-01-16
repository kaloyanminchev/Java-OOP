package unitTesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaceEntryTest {
    private static final UnitMotorcycle MOTORCYCLE
            = new UnitMotorcycle("Mercedes", 1200, 3000d);
    private static final UnitRider RIDER
            = new UnitRider("Hamilton", MOTORCYCLE);

    private RaceEntry raceEntry;

    @Before
    public void setUp() {
        this.raceEntry = new RaceEntry();
    }

    @Test(expected = NullPointerException.class)
    public void addRiderShouldReturnExceptionIfRiderIsNull() {
        this.raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderShouldReturnExceptionIfRiderIsPresent() {
        this.raceEntry.addRider(RIDER);
        this.raceEntry.addRider(RIDER);
    }

    @Test
    public void shouldAddRiderIfRiderIsAbsent() {
        String message = String.format("Rider %s added in race.", RIDER.getName());

        assertEquals(message, this.raceEntry.addRider(RIDER));
    }

    @Test
    public void shouldReturnAverageHorsePower() {
        this.raceEntry.addRider(RIDER);
        UnitRider testRider
                = new UnitRider("Raikonen", new UnitMotorcycle("Ferrari", 600, 2700));
        this.raceEntry.addRider(testRider);

        assertEquals(900, this.raceEntry.calculateAverageHorsePower(), 0.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldReturnExceptionIfSizeLessThanMinimum() {
        this.raceEntry.addRider(RIDER);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void getRidersShouldReturnAllRiders() {
        this.raceEntry.addRider(RIDER);
        UnitRider testRider
                = new UnitRider("Raikonen", new UnitMotorcycle("Ferrari", 600, 2700));
        this.raceEntry.addRider(testRider);

        assertEquals("UnmodifiableCollection", this.raceEntry.getRiders().getClass().getSimpleName());
    }
}
