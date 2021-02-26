package GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            long quantity = Long.parseLong(input[i + 1]);

            if (name.equals("Gold")) {
                if (capacity >= bag.currentWeight() + quantity) {
                    bag.setTotalGold(bag.getTotalGold() + quantity);
                }
            } else if (name.toLowerCase().endsWith("gem")){
                if (bag.getGemsAmount() + quantity <= bag.getTotalGold()
                        && bag.currentWeight() + quantity <= bag.getCapacity()){
                    bag.getGems().putIfAbsent(name , 0L);
                    bag.getGems().put(name , bag.getGems().get(name) + quantity);
                }
            } else if (name.length() == 3){
                if (bag.getCashAmount() + quantity <= bag.getGemsAmount()
                        && bag.currentWeight() + quantity <= bag.getCapacity()){
                    bag.getCash().putIfAbsent(name , 0L);
                    bag.getCash().put(name , bag.getCash().get(name) + quantity);
                }
            }
        }
        System.out.println(bag.printBagContent());
    }
}