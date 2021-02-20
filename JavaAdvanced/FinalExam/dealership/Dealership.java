package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }

    public boolean buy (String manufacturer, String model){
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
        //o	" The cars are in a car dealership {name}:
        sb.append("The cars are in a car dealership ").append(this.name).append(":").append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
