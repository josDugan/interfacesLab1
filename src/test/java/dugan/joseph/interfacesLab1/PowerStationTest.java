package dugan.joseph.interfacesLab1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by joseph on 2/3/16.
 */
public class PowerStationTest {

    private PowerStation station;
    private Corolla corolla;
    private Cadillac cadillac;
    private Valari valari;

    @Before
    public void setUp() throws Exception {
        station = new PowerStation();
        corolla = new Corolla();
        cadillac = new Cadillac();
        valari = new Valari();
    }

    @After
    public void tearDown() throws Exception {
        station = null;
    }

    @Test
    public void givenThatFuelTankIsInitializedToFUEL_DELIEVERYwhenStationHasFuelDeliveryTotalFuelIsFUEL_DELIVERYTimesTwo() throws Exception {
        station.newFuelDelivery();

        int expected = 2 * FuelStation.FUEL_DELIVERY;
        int actual = station.getTotalFuel();
        assertEquals("Fuel delivery does not deliver correct amount of fuel", expected, actual);
    }


    @Test
    public void givenThatPowerStaitonIsConstructedWithFUEL_DELIVERYTotalFuelPowerStationHasFUEL_DELIEVERYTotalFuel() throws Exception {
        int expected = PowerStation.FUEL_DELIVERY;
        int actual = station.getTotalFuel();
        assertEquals("TotalFuel not initialized correctly", expected, actual);
    }

    @Test
    public void givenThatStationServicesAGasPoweredVehicleStationDoesNotFuelVehicleErgoVehiclesFueldLevelRemainsUnchanged() throws Exception {
        int expected = corolla.getFuelLevel() + FuelStation.FUEL_TANK_LOAD;

        station.fillTank(corolla);

        int actual = corolla.getFuelLevel();

        assertEquals("Fuel tank was filled", expected, actual);
    }

    @Test
    public void givenThatStationServicesElectricPoweredVehicleWhenStationFillsVehiclesTankVehiclesTankIsIncreasedByFULL_TANK_LOADAndSTtationTotalFuelDecreasesByFULL_TANK_LOAD() {
        int expectedCadillacFuelLevel = cadillac.getFuelLevel() + FuelStation.FUEL_TANK_LOAD;
        int expectedPowerStationTotalFuel = FuelStation.FUEL_DELIVERY - FuelStation.FUEL_TANK_LOAD;

        station.fillTank(cadillac);
        int actualCadillacFuelLevel = cadillac.getFuelLevel();
        assertEquals("Car not refueled properly", expectedCadillacFuelLevel, actualCadillacFuelLevel);
        int actualPowerStationTotalFuel = station.getTotalFuel();
        assertEquals("Station not debited fuel properly", expectedPowerStationTotalFuel, actualPowerStationTotalFuel);

    }

    @Test
    public void givenThatStationServicesSolarPoweredVehicleWhenStationFillsVehiclesTankVehiclesTankIsIncreasedByFULL_TANK_LOADAndSTtationTotalFuelDecreasesByFULL_TANK_LOAD() {
        int expectedCadillacFuelLevel = valari.getFuelLevel() + FuelStation.FUEL_TANK_LOAD;
        int expectedPowerStationTotalFuel = FuelStation.FUEL_DELIVERY - FuelStation.FUEL_TANK_LOAD;

        station.fillTank(valari);
        int actualCadillacFuelLevel = valari.getFuelLevel();
        assertEquals("Car not refueled properly", expectedCadillacFuelLevel, actualCadillacFuelLevel);
        int actualPowerStationTotalFuel = station.getTotalFuel();
        assertEquals("Station not debited fuel properly", expectedPowerStationTotalFuel, actualPowerStationTotalFuel);

    }
}