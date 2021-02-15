package Exercise_05_ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name , int age , String town){
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.name.compareTo(other.getName());
        if (result == 0){
            result = Integer.compare(this.age , other.getAge());
        }
        if (result == 0){
            result = this.town.compareTo(other.getTown());
        }
        return result;
    }
}
