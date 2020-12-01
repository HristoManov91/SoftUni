import java.util.*;

public class DigitsLettersOrOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String , List<Character>> output = new LinkedHashMap<>();
        output.put("digits" , new ArrayList<>());
        output.put("letters" , new ArrayList<>());
        output.put("others" , new ArrayList<>());

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)){
                output.get("digits").add(symbol);
            } else if (Character.isLetter(symbol)){
                output.get("letters").add(symbol);
            } else {
                output.get("others").add(symbol);
            }
        }
        for (Map.Entry<String, List<Character>> type : output.entrySet()){
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < type.getValue().size(); i++) {
                result.append(type.getValue().get(i));
            }
            System.out.println(result);
        }
    }
}
