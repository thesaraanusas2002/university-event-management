import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ResultManager manager = new ResultManager();

    public static void main(String[] args) {
        seedDemoData();

        boolean running = true;

        System.out.println("==============================================");
        System.out.println("       STUDENT RESULT MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        while (running) {
            showMenu();
            int choice = readInt("Select an option: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> manager.displayAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> showClassStatistics();
                case 7 -> {
                    running = false;
                    System.out.println("Thank you for using the system.");
                }
                default -> System.out.println("Invalid option. Please choose 1-7.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--------------- MENU ----------------");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Class Statistics");
        System.out.println("7. Exit");
        System.out.println("-------------------------------------");
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");

        String id = readNonEmpty("Student ID: ");
        if (manager.findStudent(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        String name = readNonEmpty("Student Name: ");
        double programming = readMark("Programming");
        double database = readMark("Database");
        double networking = readMark("Networking");
        double mathematics = readMark("Mathematics");
        double systemAnalysis = readMark("System Analysis");

        manager.addStudent(new Student(
                id, name, programming, database, networking,
                mathematics, systemAnalysis
        ));

        System.out.println("Student added successfully.");
    }

    private static void searchStudent() {
        String id = readNonEmpty("Enter student ID: ");
        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        displayStudent(student);
    }

    private static void updateStudent() {
        String id = readNonEmpty("Enter student ID to update: ");
        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter new marks:");
        double programming = readMark("Programming");
        double database = readMark("Database");
        double networking = readMark("Networking");
        double mathematics = readMark("Mathematics");
        double systemAnalysis = readMark("System Analysis");

        student.updateMarks(programming, database, networking, mathematics, systemAnalysis);
        System.out.println("Student marks updated successfully.");
    }

    private static void deleteStudent() {
        String id = readNonEmpty("Enter student ID to delete: ");

        if (manager.removeStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void showClassStatistics() {
        if (manager.size() == 0) {
            System.out.println("No student data available.");
            return;
        }

        Student top = manager.getTopStudent();

        System.out.println("\n--- Class Statistics ---");
        System.out.println("Number of Students : " + manager.size());
        System.out.printf("Class Average      : %.2f%n", manager.getClassAverage());

        if (top != null) {
            System.out.println("Top Student        : " + top.getName());
            System.out.printf("Top Average        : %.2f%n", top.getAverage());
        }
    }

    private static void displayStudent(Student student) {
        System.out.println("\n-----------------------------------------");
        System.out.println("Student ID : " + student.getStudentId());
        System.out.println("Name       : " + student.getName());
        System.out.println(student.getMarksSummary());
        System.out.printf("Total      : %.2f%n", student.getTotal());
        System.out.printf("Average    : %.2f%n", student.getAverage());
        System.out.println("Grade      : " + student.getGrade());
        System.out.println("Status     : " + student.getStatus());
        System.out.println("-----------------------------------------");
    }

    private static double readMark(String subject) {
        while (true) {
            double mark = readDouble(subject + " mark (0-100): ");
            if (mark >= 0 && mark <= 100) return mark;
            System.out.println("Marks must be between 0 and 100.");
        }
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("This field cannot be empty.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void seedDemoData() {
        manager.addStudent(new Student("2024/ICT/001", "Amal Perera",
                78, 72, 69, 81, 75));
        manager.addStudent(new Student("2024/ICT/002", "Nimali Silva",
                64, 71, 68, 60, 66));
        manager.addStudent(new Student("2024/ICT/003", "Kasun Fernando",
                55, 61, 58, 63, 57));
    }
}
