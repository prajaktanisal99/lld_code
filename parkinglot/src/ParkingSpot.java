import vehicletype.Vehicle;
import vehicletype.VehicleType;

public class ParkingSpot {

    int spotNumber;
    VehicleType type;
    Vehicle parkedVehicle;

    ParkingSpot(int spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.type = type;
    }

    public boolean isAvailable() {
        return this.parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        parkedVehicle = vehicle;
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }
}
