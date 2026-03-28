public class EnrollmentManager {

    private EnrollmentDAO dao;

    public EnrollmentManager() {
        dao = new EnrollmentDBPersistence();  // ✅ this must exist
    }

    public void addEnrollment(Enrollment enrollment) {
        dao.addEnrollment(enrollment);
    }

    public Enrollment getEnrollmentById(String id) {
        return dao.getEnrollmentById(id);  // ✅ now works
    }

    public void updateEnrollment(Enrollment enrollment) {
        dao.updateEnrollment(enrollment);
    }

    public void deleteEnrollment(String id) {
        dao.deleteEnrollment(id);
    }
}