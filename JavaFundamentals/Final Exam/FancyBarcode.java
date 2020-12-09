import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                String barcode = matcher.group("barcode");
                StringBuilder productGroup = new StringBuilder();
                for (int j = 0; j < barcode.length(); j++) {
                    if (Character.isDigit(barcode.charAt(j))){
                        productGroup.append(barcode.charAt(j));
                    }
                }
                if (productGroup.length() == 0){
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", productGroup);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
