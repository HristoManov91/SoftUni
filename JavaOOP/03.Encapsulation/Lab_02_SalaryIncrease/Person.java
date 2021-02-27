package Lab_02_SalaryIncrease;

public class Person {
    //•	firstName: String
    //•	lastName: String
    //•	age: int
    //•	toString() - override
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age , double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        if (this.getAge() < 30){
            this.setSalary(this.getSalary() + (this.getSalary() * (bonus / 100.00 / 2)));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * (bonus / 100.00)));
        }
    }

    @Override
    public String toString() {
        //Asen Ivanov gets 2640.0 leva
        return String.format("%s %s gets %s leva", this.firstName , this.lastName , this.salary);
    }
}
