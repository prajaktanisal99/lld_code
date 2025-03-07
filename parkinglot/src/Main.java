import vehicletype.Car;
import vehicletype.MotorCycle;
import vehicletype.Truck;
import vehicletype.Vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        System.out.println("\nParking lot system!");

        ParkingLot parkingLot = new ParkingLot();

        parkingLot.addLevel(new Level(2, 5));
        parkingLot.addLevel(new Level(1, 5));

        Vehicle car1 = new Car("car1");
        Vehicle truck1 = new Truck("truck1");
        Vehicle truck2 = new Truck("truck2");
        Vehicle motorcycle1 = new MotorCycle("motorcycle1");

        parkingLot.displayAvailability();

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(truck2);
        parkingLot.parkVehicle(motorcycle1);

        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(truck2);
        parkingLot.unparkVehicle(motorcycle1);

        parkingLot.displayAvailability();
    }
}