package dugan.joseph.interfacesLab1;

/**
 * Created by joseph on 2/3/16.
 */
public abstract class Car implements Driveable {
    final static int FULL_TANK = 100;
    private int fuelLevel;
    private FuelType fuelType;
    private boolean on;

    Car() {
        fuelLevel = 0;
        on = false;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void refuel();

    enum FuelType {
        GAS, ELECTRICITY, SOLAR
    }

    public boolean getOn() {
        return on;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelLevel(int newFuelLevel) {
        fuelLevel = newFuelLevel;
    }

    public void setFuelType(FuelType newFuelType) {
        fuelType = newFuelType;
    }

    public void setOn(boolean onOff) {
        on = onOff;
    }

    public String toString() {
        String state;
        if (on)
            state = "on";
        else
            state = "off";
        return "Car is " + state + " with fuel level " + fuelLevel;
    }

    public void print() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Car[] cars = new Car[] {new Corolla(), new Cadillac(), new Valari()};
        FuelStation gas = new GasStation();
        FuelStation nonGas = new PowerStation();

        for (Car car : cars) {
            car.print();
            car.refuel();
            car.turnOn();;
            car.print();
            car.drive(50);
            car.turnOff();
            car.print();
            if (car.getFuelType().equals(FuelType.GAS))
                gas.fillTank(car);
            else
                nonGas.fillTank(car);
            car.print();
            car.turnOn();
            car.drive(50);
            car.turnOff();
            car.print();
        }
    }

}

abstract class FuelStation {
    final static int FUEL_DELIVERY = 1000;
    final static int FUEL_TANK_LOAD = 100;
    private int totalFuel;
    FuelStation() {
        totalFuel = FUEL_DELIVERY;
    }

    public abstract void fillTank(Car car);

    public int getTotalFuel() {
        return totalFuel;
    }

    public void newFuelDelivery() {
        totalFuel += FUEL_DELIVERY;
    }

    public void removeTotalFuelByTankfillAmount(int amount) {
        totalFuel -= amount;
    }

}

class GasStation extends FuelStation {

    @Override
    public void fillTank(Car car) {
        if (car.getFuelType().equals(Car.FuelType.GAS)) {
            car.refuel();
            removeTotalFuelByTankfillAmount(Car.FULL_TANK);
        }
        else
            System.out.println("This is not a gas-powered vehicle. Go to the PowerStation.");

    }
}

class PowerStation extends FuelStation {

    @Override
    public void fillTank(Car car) {
        Car.FuelType type = car.getFuelType();
        if (!type.equals(Car.FuelType.ELECTRICITY) || !type.equals(Car.FuelType.SOLAR)) {
            car.refuel();
            removeTotalFuelByTankfillAmount(Car.FULL_TANK);
        }
        else {
            System.out.println("This is not a solar-powered or electric-powered vehicle. Go to the gas station.");
        }
    }
}

interface Driveable {
    void drive(int distance);
}

class Corolla extends Car {

    public Corolla() {
        setFuelType(FuelType.GAS);
    }

    public void turnOn() {
        setOn(true);
    }

    public void turnOff() {
        setOn(false);
    }

    public void refuel() {
        if (!getOn())
            setFuelLevel(FULL_TANK);
        else
            System.out.println("Car must be turned off to fuel");
    }

    public void drive(int distance) {
        if (getOn())
            setFuelLevel(getFuelLevel() - distance);
        else
            System.out.println("Car must be turned on to drive");
    }
}

class Cadillac extends Car {

    public Cadillac() {
        setFuelType(FuelType.ELECTRICITY);
    }

    public void turnOn() {
        setOn(true);
    }

    public void turnOff() {
        setOn(false);
    }

    public void refuel() {
        if (!getOn())
            setFuelLevel(FULL_TANK);
        else
            System.out.println("Car must be turned off to fuel");
    }

    public void drive(int distance) {
        if (getOn())
            setFuelLevel(getFuelLevel() - distance);
        else
            System.out.println("Car must be turned on to drive");
    }
}

class Valari extends Car {

    public Valari() {
        setFuelType(FuelType.SOLAR);
    }

    public void turnOn() {
        setOn(true);
    }

    public void turnOff() {
        setOn(false);
    }

    public void refuel() {
        if (!getOn())
            setFuelLevel(FULL_TANK);
        else
            System.out.println("Car must be turned off to fuel");
    }

    public void drive(int distance) {
        if (getOn())
            setFuelLevel(getFuelLevel() - distance);
        else
            System.out.println("Car must be turned on to drive");
    }

}
