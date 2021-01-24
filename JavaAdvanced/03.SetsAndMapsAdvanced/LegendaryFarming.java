import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        boolean legendaryItemObtained = false;

        while (!legendaryItemObtained) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);
                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        int newCount = keyMaterials.get(material) - 250;
                        keyMaterials.put(material, newCount);
                        i = input.length;
                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                legendaryItemObtained = true;
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                legendaryItemObtained = true;
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                legendaryItemObtained = true;
                                break;
                        }
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
            }
        }
        keyMaterials
                .entrySet()
                .stream()
                .sorted((l, r) -> {
                    int result = r.getValue().compareTo(l.getValue());
                    if (result == 0) {
                        result = l.getKey().compareTo(r.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        for (Map.Entry<String, Integer> junkMaterial : junkMaterials.entrySet()) {
            System.out.println(junkMaterial.getKey() + ": " + junkMaterial.getValue());
        }
    }
}
