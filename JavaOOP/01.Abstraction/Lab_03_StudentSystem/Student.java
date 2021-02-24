package Lab_03_StudentSystem;

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

    public int getAge() {
        return this.age;
    }

    public double getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" is ").append(this.getAge()).append(" years old. ");
        sb.append(commentForGrade(this.getGrade()));
        return sb.toString();
    }

    private String commentForGrade(double grade) {
        if (grade >= 5.00) {
            return "Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return "Average student.";
        } else {
            return "Very nice person.";
        }
    }
}
