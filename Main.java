import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Student");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student GPA: ");
        double gpa = scanner.nextDouble();

        studentList.add(new Student(id, name, gpa));
        System.out.println("Student added successfully!");
    }

    private static void viewStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No student record found.");
            return;
        }
        System.out.println("\n--- Student Record---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search:");
        int id = scanner.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.println("Record Found: " + s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found. ");

        }
    }

}