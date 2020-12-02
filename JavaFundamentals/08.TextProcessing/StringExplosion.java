import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        int bombPower = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>'){
                sb.append('>');
                int power = Integer.parseInt(String.valueOf((input.charAt(i + 1))));
                bombPower += power;
            } else if ( bombPower == 0){
                sb.append(input.charAt(i));
            } else {
                bombPower--;
            }
        }
        System.out.println(sb);
    }
}
