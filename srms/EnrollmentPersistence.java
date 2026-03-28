import java.util.ArrayList;

public interface EnrollmentPersistence {

    void addEnrollment(Enrollment e);

    ArrayList<Enrollment> getAllEnrollments();

    void updateEnrollment(Enrollment e);

    void deleteEnrollment(String id);
}