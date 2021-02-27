package Lab_04_FindAndReverseTeam;

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
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460.0){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
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
