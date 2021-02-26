package StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public String commentaryToGrade(Double grade) {
        if (grade >= 5.00) {
            return " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return " Average student.";
        } else {
            return " Very nice person.";
        }
    }

    @Override
    public String toString() {
        return String.format("%s is %d years old.%s", this.name, this.age, commentaryToGrade(this.grade));
    }
}
