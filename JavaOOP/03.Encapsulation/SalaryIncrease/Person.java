package SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName , String lastName , int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person (String firstName , String lastName , int age , double salary){
        this(firstName, lastName, age);
        this.salary = salary;
    }

    public int getAge() {
        return this.age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva.", this.firstName , this.lastName , this.getSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary (double percentBonus){
        if (this.getAge() < 30){
            this.setSalary(this.getSalary() + (this.getSalary() * percentBonus / 200));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * percentBonus / 100));
        }
    }
}
