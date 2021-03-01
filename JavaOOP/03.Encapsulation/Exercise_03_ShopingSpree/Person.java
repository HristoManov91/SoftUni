package Exercise_03_ShopingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public double getMoney() {
        return this.money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void buyProduct(Product product){
        if (this.money >= product.getCost()){
            money -= product.getCost();
            products.add(product);
            System.out.printf("%s bought %s%n", this.getName() , product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", this.getName() , product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - ");
        if (this.getProducts().isEmpty()){
            sb.append("Nothing bought");
        } else {
            sb.append(this.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
        return sb.toString();
    }
}
