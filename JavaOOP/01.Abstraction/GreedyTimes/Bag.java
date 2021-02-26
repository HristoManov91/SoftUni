package GreedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private Map<String , Long> gems;
    private long totalGold;
    private Map<String , Long> cash;

    public Bag (long capacity){
        this.capacity = capacity;
        this.gems = new LinkedHashMap<>();
        this.totalGold = 0;
        this.cash = new LinkedHashMap<>();
    }

    public long getCapacity() {
        return capacity;
    }

    public Map<String, Long> getGems() {
        return gems;
    }

    public long getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(long totalGold) {
        this.totalGold = totalGold;
    }

    public Map<String, Long> getCash() {
        return cash;
    }

    public long currentWeight() {
        long sum = 0;
        if (!getGems().isEmpty()){
            sum += getGemsAmount();
        }
        if (!getCash().isEmpty()){
            sum += getCashAmount();
        }
        sum += getTotalGold();
        return sum;
    }

    public long getGemsAmount(){
        if (!getGems().isEmpty()){
            return getGems().values().stream().mapToLong(e -> e).sum();
        }
        return 0;
    }

    public long getCashAmount(){
        if (!getCash().isEmpty()){
            return getCash().values().stream().mapToLong(e -> e).sum();
        }
        return 0;
    }

    public String printBagContent(){
        StringBuilder sb = new StringBuilder();
        sb.append("<Gold> $").append(getTotalGold()).append(System.lineSeparator());
        sb.append("##Gold - ").append(getTotalGold()).append(System.lineSeparator());
        if (!getGems().isEmpty()) {
            sb.append("<Gem> $").append(getGemsAmount()).append(System.lineSeparator());
            getGems().entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        int result = e2.getKey().compareTo(e1.getKey());
                        if (result == 0){
                            result = e1.getValue().compareTo(e2.getValue());
                        }
                        return result;
                    })
                    .forEach(e -> sb.append(String.format("##%s - %d%n", e.getKey(), e.getValue())));
        }
        if (!getCash().isEmpty()) {
            sb.append("<Cash> $").append(getCashAmount()).append(System.lineSeparator());
            getCash().entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        int result = e2.getKey().compareTo(e1.getKey());
                        if (result == 0){
                            result = e1.getValue().compareTo(e2.getValue());
                        }
                        return result;
                    })
                    .forEach(e -> sb.append(String.format("##%s - %d%n", e.getKey(), e.getValue())));
        }
        return sb.toString().trim();
    }
}
