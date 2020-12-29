package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEmployee = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();
        Map<String , List<Double>> departmentSalary = new HashMap<>();

        for (int i = 0; i < countEmployee; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            departmentSalary.putIfAbsent(department , new ArrayList<>());
            departmentSalary.get(department).add(salary);

            if (tokens.length == 4){
                Employee employee = new Employee(name , salary , position , department);
                employeeList.add(employee);
            } else if (tokens.length == 5){
                if (tokens[4].contains("@")){
                    String email = tokens[4];
                    Employee employee = new Employee(name , salary , position , department , email);
                    employeeList.add(employee);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    Employee employee = new Employee(name , salary , position , department , age);
                    employeeList.add(employee);
                }
            } else {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                Employee employee = new Employee(name , salary , position , department , email , age);
                employeeList.add(employee);
            }
        }
        double bigAverageSalary = 0;
        String departmentBiggestAverageSalary = "";
        for (Map.Entry<String, List<Double>> department : departmentSalary.entrySet()){
            double averageSalary = department.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            if (averageSalary > bigAverageSalary){
                bigAverageSalary = averageSalary;
                departmentBiggestAverageSalary = department.getKey();
            }
        }
        System.out.println("Highest Average Salary: " + departmentBiggestAverageSalary);
        String finalDepartmentBiggestAverageSalary = departmentBiggestAverageSalary;
        employeeList
                .stream()
                .filter(e -> e.getDepartment().equals(finalDepartmentBiggestAverageSalary))
                .sorted((e1 , e2) -> Double.compare(e2.getSalary() , e1.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
