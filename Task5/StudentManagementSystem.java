import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    private List<Student> students;
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        students = loadFromFile();
    }

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully!");
    }

    // Remove Student
    public void removeStudent(int rollNumber) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            students.remove(student);
            saveToFile();
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Search Student
    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    // Display All Students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Save to File
    private void saveToFile() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data!");
        }
    }

    // Load from File
    private List<Student> loadFromFile() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter number only.");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    sms.addStudent(new Student(name, roll, grade, dept));
                    break;

                case 2:
                    System.out.print("Enter Roll Number to edit: ");
                    int editRoll = sc.nextInt();
                    Student student = sms.searchStudent(editRoll);

                    if (student != null) {
                        sc.nextLine();
                        System.out.print("Enter new Name: ");
                        student.setName(sc.nextLine());

                        System.out.print("Enter new Grade: ");
                        student.setGrade(sc.nextLine());

                        System.out.print("Enter new Department: ");
                        student.setDepartment(sc.nextLine());

                        sms.saveToFile();
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to remove: ");
                    int removeRoll = sc.nextInt();
                    sms.removeStudent(removeRoll);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = sc.nextInt();
                    Student found = sms.searchStudent(searchRoll);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    sms.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}