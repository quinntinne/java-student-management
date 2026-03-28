import java.util.List;

public interface StudentDAO {

    void addStudent(Student student);

    Student getStudentById(String id);

    void updateStudent(Student student);

    void deleteStudent(String id);

    List<Student> getAllStudents();
}