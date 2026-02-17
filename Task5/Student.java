import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;
    private String department;

    public Student(String name, int rollNumber, String grade, String department) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.department = department;
    }

    // Getters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public String getGrade() { return grade; }
    public String getDepartment() { return department; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber +
               ", Name: " + name +
               ", Grade: " + grade +
               ", Dept: " + department;
    }
}