package Car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int horsepower;
    List<Part> parts;

    public Car (String brand , String model , int horsepower){//викане на друг конструктор в конструктор
        this(brand, model);//тази операция винаги е на 1во място
        this.horsepower = horsepower;
    }

    public Car(String brand , String model){
        this(brand);//този конструктор вика по малкият конструктор
        this.model = model;
    }

    public Car(String brand){
        this.brand = brand;
        this.parts = new ArrayList<>();
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override//анотация
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand() ,
                this.getModel() != null ? this.getModel() : "unknown" ,
                this.getHorsepower() != 0 ? this.getHorsepower() : -1);
    }
}
