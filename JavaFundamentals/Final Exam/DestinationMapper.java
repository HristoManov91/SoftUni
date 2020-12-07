import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()){
            String destination = matcher.group("destination");
            destinations.add(destination);
            travelPoints += destination.length();
        }
        System.out.printf("Destinations: %s%n", destinations.toString().replaceAll("[\\[\\]]", ""));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
