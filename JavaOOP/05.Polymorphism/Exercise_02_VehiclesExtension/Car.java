package Exercise_02_VehiclesExtension;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption , Double tankCapacity) {
        super(fuelQuantity , fuelConsumption + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION , tankCapacity);
    }
}
