package ShopingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException(ConstantMessages.NEGATIVE_MONEY_EXCEPTION_MESSAGE);
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product);
            this.setMoney(this.money - product.getCost());
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        String productsOutput = this.products.isEmpty()
                ? "Nothing bought"
                : this.products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        return name + " - " + productsOutput;
////        StringBuilder sb = new StringBuilder();
////        sb.append(this.getName()).append(" - ");
////        if (this.getProducts().size() == 0) {
////            sb.append("Nothing bought");
////        } else {
////            for (int i = 0; i < this.getProducts().size(); i++) {
////                if (i == this.getProducts().size() - 1) {
////                    sb.append(this.getProducts().get(i).getName());
////                    break;
////                }
////                sb.append(this.getProducts().get(i).getName()).append(", ");
////            }
//    }
    }
}
