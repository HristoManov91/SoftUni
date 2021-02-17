package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        Car carToRemove = null;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                carToRemove = car;
                break;
            }
        }
        return data.remove(carToRemove);
    }

    public Car getLatestCar(){
        Car oldestCar = null;
        for (Car car : data) {
            if (oldestCar != null){
                if (car.getYear() > oldestCar.getYear()){
                    oldestCar = car;
                }
            } else {
                oldestCar = car;
            }
        }
        return oldestCar;
    }

    public Car getCar(String manufacturer, String model){
        Car carToReturn = null;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                carToReturn = car;
                break;
            }
        }
        return carToReturn;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        //o	"The cars are parked in {parking type}:
        sb.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
