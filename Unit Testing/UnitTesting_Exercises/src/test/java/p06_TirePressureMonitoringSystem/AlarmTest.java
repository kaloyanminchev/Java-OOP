package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void defaultAlarmValueOnCreationIsOff() {
        Alarm alarm = new Alarm(new Sensor());
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOnAfterCheckingSensorWithLowerBound() {
        Sensor mockSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(16.5);

        Alarm alarm = new Alarm(mockSensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOnAfterCheckingSensorWithUpperBound() {
        Sensor mockSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(21.5);

        Alarm alarm = new Alarm(mockSensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOffAfterCheckingSensorWithinBounds() {
        Sensor mockSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(18d);

        Alarm alarm = new Alarm(mockSensor);

        alarm.check();

        assertFalse(alarm.getAlarmOn());
    }

}