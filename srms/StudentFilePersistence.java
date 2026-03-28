import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFilePersistence implements StudentDAO {

    private final String fileName = "students.txt";

    // =========================
    // ADD STUDENT
    // =========================
    @Override
    public void addStudent(Student student) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(student.getId() + "," +
                         student.getName() + "," +
                         student.getEmail());

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // GET ALL STUDENTS
    // =========================
    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        File file = new File(fileName);

        // If file doesn't exist yet, return empty list
        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 3) {

                    Student student = new Student(
                            parts[0],
                            parts[1],
                            parts[2]
                    );

                    students.add(student);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public Student getStudentById(String id) {

        List<Student> students = getAllStudents();

        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }

        return null;
    }

    // =========================
    // UPDATE STUDENT
    // =========================
    @Override
    public void updateStudent(Student updatedStudent) {

        List<Student> students = getAllStudents();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Student s : students) {

                if (s.getId().equals(updatedStudent.getId())) {
                    s = updatedStudent;
                }

                writer.write(s.getId() + "," +
                             s.getName() + "," +
                             s.getEmail());

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE STUDENT
    // =========================
    @Override
    public void deleteStudent(String id) {

        List<Student> students = getAllStudents();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Student s : students) {

                if (!s.getId().equals(id)) {

                    writer.write(s.getId() + "," +
                                 s.getName() + "," +
                                 s.getEmail());

                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}