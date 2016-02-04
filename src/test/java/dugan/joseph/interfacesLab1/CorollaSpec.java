package dugan.joseph.interfacesLab1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by joseph on 2/3/16.
 */
public class CorollaSpec {
    private final static int FUEl_UNIT = 100;
    private final static int DISTANCE = 5;
    private final static Car.FuelType GAS = Car.FuelType.GAS;

    private Corolla car;

    @Before
    public void setUp() {
        car = new Corolla();
    }

    @Test
    public void givenThatFuelLevelIs0WhenFuelLevelIsSetToFUEL_UNITFuelLevelIsFUEL_UNIT() {
        car.setFuelLevel(0);

        car.setFuelLevel(FUEl_UNIT);
        int expected = FUEl_UNIT;
        int actual = car.getFuelLevel();
        assertEquals("Car fuel level is not set correctly", expected, actual);
    }

    @Test
    public void givenThatCorollaIsContructedWithFuelTypeGASCarHasFuelTypeGAS() {
        Car.FuelType expected = GAS;
        Car.FuelType actual = car.getFuelType();
        assertEquals("Corolla not constructed correctly", expected, actual);
    }

    @Test
    public void whenCarTurnsOnThenOnShouldBeTrue() {
        car.turnOn();

        boolean actual = car.getOn();
        assertTrue("Car is not turned on", actual);
    }

    @Test
    public void givenCarTurnedOnWhenCarTurnsOffOnShouldBeFase() {
        car.turnOn();

        car.turnOff();

        boolean actual = car.getOn();
        assertTrue("Car is not turned off", !actual);
    }

    @Test
    public void givenFuelLevelIsZeroWhenCarIsRefueledWithFuelUnitCarGetFuelLevelIsFuelUnit() {
        car.setFuelLevel(0);

        car.refuel();
        int expected = FUEl_UNIT;
        int actual = car.getFuelLevel();
        assertEquals("Fuel level is not as expectd", expected, actual);
    }

    @Test
    public void  givenCarHasFuelLevel10AndCarIsOnWhenCarIsDrivenDistance5FuelLevelIs95() {
        car.refuel();
        car.turnOn();
        car.drive(DISTANCE);

        int expected = 95;
        int actual = car.getFuelLevel();
        assertEquals("After driving expected distance, car does not have expected fuel", expected, actual);
    }

    @After
    public void teardown(){
        car = null;
    }


}
