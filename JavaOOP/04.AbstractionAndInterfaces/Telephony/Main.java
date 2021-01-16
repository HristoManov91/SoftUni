package Telephony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputNumbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> inputUrls = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        
        Smartphone smartphone = new Smartphone(inputNumbers , inputUrls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}
