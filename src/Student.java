public class Student {
    private String studentId;
    private String name;
    private double programming;
    private double database;
    private double networking;
    private double mathematics;
    private double systemAnalysis;

    public Student(String studentId, String name, double programming,
                   double database, double networking, double mathematics,
                   double systemAnalysis) {
        this.studentId = studentId;
        this.name = name;
        this.programming = programming;
        this.database = database;
        this.networking = networking;
        this.mathematics = mathematics;
        this.systemAnalysis = systemAnalysis;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }

    public double getTotal() {
        return programming + database + networking + mathematics + systemAnalysis;
    }

    public double getAverage() {
        return getTotal() / 5.0;
    }

    public String getGrade() {
        double average = getAverage();
        if (average >= 75) return "A";
        if (average >= 65) return "B";
        if (average >= 55) return "C";
        if (average >= 40) return "S";
        return "F";
    }

    public String getStatus() {
        return getAverage() >= 40 ? "PASS" : "FAIL";
    }

    public void updateMarks(double programming, double database,
                            double networking, double mathematics,
                            double systemAnalysis) {
        this.programming = programming;
        this.database = database;
        this.networking = networking;
        this.mathematics = mathematics;
        this.systemAnalysis = systemAnalysis;
    }

    public String getMarksSummary() {
        return String.format(
            "Programming: %.2f | Database: %.2f | Networking: %.2f | Mathematics: %.2f | System Analysis: %.2f",
            programming, database, networking, mathematics, systemAnalysis
        );
    }
}
