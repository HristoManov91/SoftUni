package Exercise_07_Google;

public class Car {
    private String carModel;
    private String carSpeed;

    public Car(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public String getCarSpeed() {
        return this.carSpeed;
    }
}
