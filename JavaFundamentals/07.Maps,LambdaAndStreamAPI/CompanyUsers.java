import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , List<String>> companyUsers = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String idEmployee = tokens[1];
            if (companyUsers.containsKey(companyName)){
                if (!companyUsers.get(companyName).contains(idEmployee)){
                    companyUsers.get(companyName).add(idEmployee);
                }
            } else {
                companyUsers.putIfAbsent(companyName, new ArrayList<>());
                companyUsers.get(companyName).add(idEmployee);
            }
            input = scanner.nextLine();
        }
        companyUsers
                .entrySet()
                .stream()
                .forEach(c -> {
                    System.out.println(c.getKey());
                    c.getValue()
                            .stream()
                            .forEach(s -> System.out.println("-- " + s));
                });
    }
}
