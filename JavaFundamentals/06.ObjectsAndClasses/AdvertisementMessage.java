import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Phrases – {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."}
        //•	Events – {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"}
        //•	Authors – {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"}
        //•	Cities – {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
        String[] phrases = {"Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int countMessage = Integer.parseInt(scanner.nextLine());
        Random rd = new Random();
        for (int i = 0; i < countMessage; i++) {
            System.out.print(phrases[rd.nextInt(phrases.length)] + " ");
            System.out.print(events[rd.nextInt(events.length)] + " ");
            System.out.print(authors[rd.nextInt(authors.length)] + " - ");
            System.out.println(cities[rd.nextInt(cities.length)]);
        }
    }
}
