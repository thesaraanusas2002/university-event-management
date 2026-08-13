import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResultManager {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public boolean removeStudent(String studentId) {
        Student student = findStudent(studentId);
        return student != null && students.remove(student);
    }

    public int size() {
        return students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getClassAverage() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student student : students) {
            total += student.getAverage();
        }
        return total / students.size();
    }

    public Student getTopStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getAverage))
                .orElse(null);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-14s %-22s %-10s %-8s %-8s%n",
                "Student ID", "Name", "Average", "Grade", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-14s %-22s %-10.2f %-8s %-8s%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getAverage(),
                    student.getGrade(),
                    student.getStatus());
        }

        System.out.println("--------------------------------------------------------------------------------");
    }
}
