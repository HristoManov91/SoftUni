import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexForDecrypt = "(?i)[star]";
        Pattern patternForDecrypting = Pattern.compile(regexForDecrypt);

        String regexForDecryptingMessage = "@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<typeAttack>[A|D])![^@\\-!:>]*->(?<soldiers>\\d+)";
        Pattern pattern = Pattern.compile(regexForDecryptingMessage);

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyerPlanets = new ArrayList<>();

        int countEncryptingMessage = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countEncryptingMessage; i++) {
            int countSecretSymbols = 0;
            String encryptingMessage = scanner.nextLine();
            Matcher matcherSecretSymbols = patternForDecrypting.matcher(encryptingMessage);
            while (matcherSecretSymbols.find()) {
                countSecretSymbols++;
            }

            StringBuilder decryptingMessage = new StringBuilder();
            for (int j = 0; j < encryptingMessage.length(); j++) {
                decryptingMessage.append((char) (encryptingMessage.charAt(j) - countSecretSymbols));
            }

            Matcher matcher = pattern.matcher(decryptingMessage);
            if (matcher.find()) {
                String planet = matcher.group("planet");
                String typeAttack = matcher.group("typeAttack");
                if (typeAttack.equals("A")) {
                    attackedPlanets.add(planet);
                } else {
                    destroyerPlanets.add(planet);
                }
            }
        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        attackedPlanets.stream().sorted().forEach(p -> System.out.println("-> " + p));

        System.out.println("Destroyed planets: " + destroyerPlanets.size());
        destroyerPlanets.stream().sorted().forEach(p -> System.out.println("-> " + p));
    }
}
