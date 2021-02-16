import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            liquids.offer(i);
        }

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (Integer ingredient : arr) {
            ingredients.push(ingredient);
        }

        int countBread = 0;
        int countCake = 0;
        int countPastry = 0;
        int countFruitPie = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;
            switch (sum){
                case 25:
                    countBread++;
                    break;
                case 50:
                    countCake++;
                    break;
                case 75:
                    countPastry++;
                    break;
                case 100:
                    countFruitPie++;
                    break;
                default:
                    ingredients.push(ingredient + 3);
                    break;
            }
        }
        if (countBread > 0 && countCake > 0 && countPastry > 0 && countFruitPie > 0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        printLiquids(liquids);
        printIngredients(ingredients);

        //o	"Bread: {amount}"
        //o	"Cake: {amount}"
        //o	"Fruit Pie: {amount}"
        //o	"Pastry: {amount}"
        System.out.println("Bread: " + countBread);
        System.out.println("Cake: " + countCake);
        System.out.println("Fruit Pie: " + countFruitPie);
        System.out.println("Pastry: " + countPastry);
    }

    private static void printIngredients(ArrayDeque<Integer> ingredients) {
        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!ingredients.isEmpty()){
                if (ingredients.size() == 1){
                    sb.append(ingredients.pop());
                } else {
                    sb.append(ingredients.pop()).append(", ");
                }
            }
            System.out.println("Ingredients left: " + sb);
        }
    }

    private static void printLiquids(ArrayDeque<Integer> liquids) {
        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!liquids.isEmpty()){
                if (liquids.size() == 1){
                    sb.append(liquids.poll());
                } else {
                    sb.append(liquids.poll()).append(", ");
                }
            }
            System.out.println("Liquids left: " + sb);
        }
    }
}
