package Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] stoneNumbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(stoneNumbers);

        List<Integer> stones = new ArrayList<>();
        for (int stone : lake) {
            stones.add(stone);
        }

        System.out.println(Arrays.toString(stones.toArray()).replaceAll("[\\[\\]]" , ""));
    }
}
