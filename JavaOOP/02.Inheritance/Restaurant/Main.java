package Restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Cake cake = new Cake("Nedelq" , BigDecimal.valueOf(5), 250.0 , 1000);
        System.out.println(cake.getName());
        System.out.println(cake.getPrice());
        System.out.println(cake.getGrams());
        System.out.println(cake.getCalories());
    }
}
