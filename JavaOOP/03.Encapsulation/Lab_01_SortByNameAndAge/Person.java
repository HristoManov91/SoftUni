package Lab_01_SortByNameAndAge;

public class Person {
    //•	firstName: String
    //•	lastName: String
    //•	age: int
    //•	toString() - override
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    @Override
    public String toString() {
        //Asen Harizanoov is 44 years old.
        return String.format("%s %s is %d years old.", this.firstName , this.lastName , this.age);
    }
}
