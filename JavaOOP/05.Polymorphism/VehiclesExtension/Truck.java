package VehiclesExtension;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.6;

    public Truck (Double fuelQuantity, Double fuelConsumption , Double fuelCapacity) {
        super(fuelQuantity , fuelConsumption + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION , fuelCapacity);
    }

    @Override
    public void refueling (Double fuel) {
        super.refueling(fuel * 0.95);
    }
}
