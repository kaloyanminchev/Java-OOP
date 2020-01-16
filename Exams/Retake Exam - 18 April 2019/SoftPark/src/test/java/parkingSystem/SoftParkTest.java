package parkingSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoftParkTest {
    private SoftPark softPark;
    private Car car;

    @Before
    public void setUp() {
        this.softPark = new SoftPark();
        this.car = new Car("Opel", "TX8899XH");
    }

    @Test
    public void testConstructorShouldAddElevenCars() {
        int actual = this.softPark.getParking().size();

        assertEquals(12, actual);
    }

    @Test
    public void shouldReturnCollectionOfParkedCars() {
        assertEquals("UnmodifiableMap", this.softPark.getParking().getClass().getSimpleName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getParkingShouldReturnUnmodifiableCollection() {
        this.softPark.getParking().put("D3", this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkSpotIsAbsent() {
        this.softPark.parkCar("A5", this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkSpotIsNotNull() {
        this.softPark.parkCar("A1", this.car);
        this.softPark.parkCar("A1", new Car("BMW", "CA5544BH"));
    }

    @Test(expected = IllegalStateException.class)
    public void parkCarShouldThrowExceptionIfCarExists() {
        this.softPark.parkCar("A1", this.car);
        this.softPark.parkCar("A2", this.car);
    }

    @Test
    public void shouldReturnMessageIfParkCarCorrectly() {
        String message = String.format("Car:%s parked successfully!", this.car.getRegistrationNumber());

        assertEquals(message, this.softPark.parkCar("A1", this.car));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkSpotIsAbsent() {
        this.softPark.removeCar("A5", this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfCarOnParkSpotArgumentIsDifferentThanCarArgument() {
        this.softPark.parkCar("A1", this.car);
        this.softPark.removeCar("A2", this.car);
    }

    @Test
    public void shouldRemoveCarCorrectly() {
        this.softPark.parkCar("A1", this.car);
        String message = String.format("Remove car:%s successfully!", this.car.getRegistrationNumber());

        assertEquals(message, this.softPark.removeCar("A1", this.car));
    }
}