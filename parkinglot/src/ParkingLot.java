import vehicletype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    List<Level> levels;

    ParkingLot() {
        levels = new ArrayList<>();
    }

    public synchronized void addLevel(Level level) {
        if (levels.isEmpty() || !levels.contains(level)) {
            levels.add(level);
        } else {
            System.out.println("Floor Already Added!!");
        }
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle " + vehicle.getIdentifier() + " parked.");
                return;
            }
        }
        System.out.println("Unable to park.");
    }

    public synchronized void unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                System.out.println("Vehicle " + vehicle.getIdentifier() + " unparked.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void displayAvailability() {
        for (Level level : levels) {
            System.out.println("Floor " + level.getFloor());
            level.displayAvailability();
        }
    }
}