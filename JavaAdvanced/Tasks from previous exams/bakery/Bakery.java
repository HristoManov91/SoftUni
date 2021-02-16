package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void add (Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove (String name){
        int index = -1;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        if (index != -1){
            this.employees.remove(index);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee oldestEmployee = this.employees.get(0);
        for (int i = 1; i < this.employees.size(); i++) {
            if (this.employees.get(i).getAge() > oldestEmployee.getAge()){
                oldestEmployee = this.employees.get(i);
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name){
        Employee employeeToReturn = null;
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)){
                employeeToReturn = employee;
            }
        }
        return employeeToReturn;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(getName()).append(":").append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
