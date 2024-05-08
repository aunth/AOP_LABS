import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class lab10 {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        List<Student> students = readStudentsFromFile(inputFile);
        if (students != null) {
            // Display student data
            System.out.println("Student Grades:");
            for (Student student : students) {
                System.out.println(student.getName() + ": " + student.getGrade());
            }

            // Find the most successful student
            Student mostSuccessful = findMostSuccessfulStudent(students);
            System.out.println("Most Successful Student: " + mostSuccessful.getName() + " - Grade: " + mostSuccessful.getGrade());

            // Calculate average grade
            double averageGrade = calculateAverageGrade(students);
            System.out.println("Average Grade: " + averageGrade);

            // Write data to output file
            writeDataToFile(outputFile, students, mostSuccessful, averageGrade);
        } else {
            System.out.println("Failed to read student data from input file.");
        }
    }

    private static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+", 2);
                if (parts.length == 2) {
                    String name = parts[0];
                    try {
                        int grade = Integer.parseInt(parts[1]);
                        students.add(new Student(name, grade));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid grade for student " + name + ". Skipping.");
                    }
                } else {
                    System.out.println("Invalid format: " + line + ". Skipping.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return null;
        }
        return students;
    }

    private static Student findMostSuccessfulStudent(List<Student> students) {
        Student mostSuccessful = null;
        int maxGrade = Integer.MIN_VALUE;
        for (Student student : students) {
            if (student.getGrade() > maxGrade) {
                maxGrade = student.getGrade();
                mostSuccessful = student;
            }
        }
        return mostSuccessful;
    }

    private static double calculateAverageGrade(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return (double) total / students.size();
    }

    private static void writeDataToFile(String filename, List<Student> students, Student mostSuccessful, double averageGrade) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Student Grades:\n");
            for (Student student : students) {
                bw.write(student.getName() + ": " + student.getGrade() + "\n");
            }
            bw.write("Most Successful Student: " + mostSuccessful.getName() + " - Grade: " + mostSuccessful.getGrade() + "\n");
            bw.write("Average Grade: " + averageGrade + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static class Student {
        private String name;
        private int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }
    }
}
