package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.service.IngredientService;
import com.example.advquerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Main implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
//        selectShampoosBySize();
//
//        selectShampoosBySizeOrLabel();
//
//        selectShampoosByPrice();

//        selectIngredientByNameStartWith();

//        countShampoosByPriceLessThan();

//        selectShampoosByIngredientName();

//        selectShampoosByIngredientCount();
    }

    private void selectShampoosByIngredientCount() {
        System.out.println("Enter count of ingredients:");
        Long count = Long.parseLong(scanner.nextLine());

        shampooService.findAllByIngredientsCounts(count).stream().map(Shampoo::getBrand).forEach(System.out::println);
    }

    private void selectShampoosByIngredientName() {
        System.out.println("Enter ingredients:");
        List<String> ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        this.shampooService
                .findAllByIngredientsNames(ingredients)
                .stream()
                .map(Shampoo::getBrand)
                .forEach(System.out::println);
    }

    private void countShampoosByPriceLessThan() {
        System.out.println("Enter price:");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.println(shampooService.countAllByPriceLessThan(price));
    }

    private void selectIngredientByNameStartWith() {
        System.out.println("Enter param to start the name:");
        String param = scanner.nextLine();

        ingredientService
                .findAllByNameStartingWith(param)
                .stream()
                .map(Ingredient::getName)
                .forEach(System.out::println);
    }

    private void selectShampoosByPrice() {
        System.out.println("Enter a min price:");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        shampooService.findAllByPriceGreaterThanOrderByPriceDesc(price)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n",
                s.getBrand() , s.getSize() , s.getPrice()));
    }

    private void selectShampoosBySizeOrLabel() {
        System.out.println("Enter size and id:");
        Size size = Size.valueOf(scanner.nextLine());
        long id = Long.parseLong(scanner.nextLine());

        shampooService.findAllBySizeOrLabel_IdOrderByPrice(size , id)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n",
                        s.getBrand() , s.getSize() , s.getPrice()));
    }

    private void selectShampoosBySize() {
        System.out.println("Enter size:");
        Size size = Size.valueOf(scanner.nextLine());
        shampooService.findAllBySizeOrderById(size)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n",
                s.getBrand() , s.getSize() , s.getPrice()));
    }
}
