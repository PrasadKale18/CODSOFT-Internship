import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystems {
    private List<Student> students;
    private String dataFileName = "students.txt";

    public StudentManagementSystems() {
        students = new ArrayList<>();
        loadStudentData();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveStudentData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFileName))) {
            for (Student student : students) {
                writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStudentData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int rollNumber = Integer.parseInt(parts[1]);
                    String grade = parts[2];
                    students.add(new Student(name, rollNumber, grade));
                }
            }
        } catch (IOException e) {
            // Handle file not found or other IO errors.
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystems sms = new StudentManagementSystems();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    sms.saveStudentData();
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Student foundStudent = sms.findStudentByRollNumber(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student Found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.println("All Students:");
                    sms.displayAllStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
