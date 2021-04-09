package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table{
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber , int capacity , double pricePerPerson){
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        for (BakedFood foodOrder : this.foodOrders) {
            this.price += foodOrder.getPrice();
        }

        for (Drink drinkOrder : drinkOrders) {
            this.price += drinkOrder.getPrice();
        }

        return this.price += getNumberOfPeople() * getPricePerPerson();
    }

    @Override
    public void clear() {
        this.drinkOrders.clear();
        this.foodOrders.clear();
        this.numberOfPeople = 0;
        this.price = 0;
        isReserved = false;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        //"Table: {table number}"
        //"Type: {table type}"
        //"Capacity: {table capacity}"
        //"Price per Person: {price per person for the current table}"
        sb.append(String.format("Table: %d", getTableNumber())).append(System.lineSeparator());
        sb.append(String.format("Type: %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Capacity: %d", getCapacity())).append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f", getPricePerPerson()));

        return sb.toString().trim();
    }
}
