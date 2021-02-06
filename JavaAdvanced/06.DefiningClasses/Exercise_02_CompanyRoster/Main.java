package Exercise_02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> employeeList = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;

            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            employeeList.putIfAbsent(department, new ArrayList<>());
            employeeList.get(department).add(employee);
        }
        String departmentHighestAverageSalary = "";
        double biggestAverageSalary = -1;
        for (Map.Entry<String, List<Employee>> department : employeeList.entrySet()) {
            double averageSalary = department.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            if (averageSalary > biggestAverageSalary) {
                departmentHighestAverageSalary = department.getKey();
                biggestAverageSalary = averageSalary;
            }
        }
        System.out.printf("Highest Average Salary: %s%n",departmentHighestAverageSalary);
        String finalDepartmentHighestAverageSalary = departmentHighestAverageSalary;
        employeeList.get(departmentHighestAverageSalary)
                .stream()
                .sorted((e1 , e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
