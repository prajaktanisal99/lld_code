package vehicletype;

public class Vehicle {
    private final VehicleType type;
    private final String identifier;

    Vehicle(String identifier, VehicleType type) {
        this.type = type;
        this.identifier = identifier;
    }

    public VehicleType getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }
}
