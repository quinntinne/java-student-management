import java.util.ArrayList;

public interface StudentPersistence {

    void addStudent(Student s);

    ArrayList<Student> getAllStudents();

    void updateStudent(Student s);

    void deleteStudent(String id);
}