import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String[] input = scanner.nextLine().split("\\s+");
        String bombNumber = input[0];
        int bombPower = Integer.parseInt(input[1]);

        while (numbers.contains(bombNumber)) {
            int indexBomb = numbers.indexOf(bombNumber);
            for (int i = 0; i < bombPower; i++) {
                if (indexBomb + 1 <= numbers.size() - 1) {
                    numbers.remove(indexBomb + 1);
                }
                if (indexBomb - 1 >= 0) {
                    numbers.remove(indexBomb - 1);
                    indexBomb--;
                }
            }
            numbers.remove(indexBomb);
        }
        int sum = 0;
        List<Integer> result = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        for (Integer num : result) {
            sum += num;
        }
        System.out.println(sum);
    }
}
