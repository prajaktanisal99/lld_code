import vehicletype.Vehicle;
import vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final int floor;
    private final int capacity;
    List<ParkingSpot> spots;

    Level(int floor, int capacity) {
        this.floor = floor;
        this.capacity = capacity;
        spots = new ArrayList<>();

        int cars = (int) (capacity * 0.6);
        int motorcycles = (int) (capacity * 0.2);

        for (int i = 1; i <= motorcycles ; i++) {
            spots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        for (int i = motorcycles + 1; i <= motorcycles + cars ; i++) {
            spots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for (int i = motorcycles + cars + 1; i <= capacity ; i++) {
            spots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            System.out.println(spot.isAvailable() + " : " + spot.type + " : " + vehicle.getType());
            if (spot.isAvailable() && spot.type == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.type == vehicle.getType()) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (ParkingSpot spot : spots) {
            System.out.println("\t " + spot.spotNumber + " for " + spot.type + " is available? " + spot.isAvailable());
        }
    }

    public int getFloor() {
        return floor;
    }
}
