import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");

        String regexHealth = "[^0-9+\\-\\/*.]";
        Pattern patternHealth = Pattern.compile(regexHealth);

        String regexDamage = "[-+]?\\d+\\.?\\d?";
        Pattern patternDamage = Pattern.compile(regexDamage);

        String regexSpecialSymbols = "[\\/|*]";
        Pattern patternSpecialSymbols = Pattern.compile(regexSpecialSymbols);

        Map<String , List<Double>> demonsInformation = new LinkedHashMap<>();

        for (String element : input) {
            demonsInformation.put(element , new ArrayList<>());
            Matcher matcherHealth = patternHealth.matcher(element);
            double health = 0;
            while (matcherHealth.find()){
                int current = ((matcherHealth.group()).charAt(0));
                health += current;
            }
            demonsInformation.get(element).add(health);

            Matcher matcherDamage = patternDamage.matcher(element);
            double damage = 0;
            while (matcherDamage.find()){
                String current = (matcherDamage.group());
                if (current.charAt(0) == '-'){
                    double number = Double.parseDouble(current.substring(1));
                    damage -= number;
                } else {
                    damage += Double.parseDouble(current);
                }
            }

            Matcher matcherSpecialSymbols = patternSpecialSymbols.matcher(element);
            while (matcherSpecialSymbols.find()){
                if (matcherSpecialSymbols.group().equals("*")){
                    damage *= 2;
                } else {
                    damage /= 2;
                }
            }
            demonsInformation.get(element).add(1 , damage);
        }
        demonsInformation
                .entrySet()
                .stream()
                .sorted()
                .forEach(d -> System.out.printf("%s - %.0f health, %.2f damage%n", d.getKey() , d.getValue().get(0) ,
                        d.getValue().get(1)));
    }
}
