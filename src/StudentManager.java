
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private static final ArrayList<String> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Manager ===");
            System.out.println("1. Create student");
            System.out.println("2. View students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createStudent();
                case "2" -> viewStudents();
                case "3" -> updateStudent();
                case "4" -> deleteStudent();
                case "5" -> running = false;
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        System.out.println("Thank you for using Student Manager!");
        scanner.close();
    }

    private static void createStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        students.add(name);
        System.out.println("Student created successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudent List:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    private static void updateStudent() {
        viewStudents();

        if (students.isEmpty()) {
            return;
        }

        System.out.print("Enter student number to update: ");
        int index = readStudentIndex();

        if (index == -1) {
            return;
        }

        System.out.print("Enter new student name: ");
        String newName = scanner.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        students.set(index, newName);
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        viewStudents();

        if (students.isEmpty()) {
            return;
        }

        System.out.print("Enter student number to delete: ");
        int index = readStudentIndex();

        if (index == -1) {
            return;
        }

        students.remove(index);
        System.out.println("Student deleted successfully!");
    }

    private static int readStudentIndex() {
        try {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 1 || number > students.size()) {
                System.out.println("Invalid student number.");
                return -1;
            }

            return number - 1;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }
}
