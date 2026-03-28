import java.util.List;

public interface EnrollmentDAO {

    void addEnrollment(Enrollment enrollment);

    List<Enrollment> getAllEnrollments();

    Enrollment getEnrollmentById(String id);  // ✅ MUST EXIST

    void updateEnrollment(Enrollment enrollment);

    void deleteEnrollment(String id);
}