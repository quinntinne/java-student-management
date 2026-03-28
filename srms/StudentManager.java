public class StudentManager {

    private StudentDAO studentDAO;

    public StudentManager() {
        studentDAO = new StudentFilePersistence();
        // OR switch to DB:
        // studentDAO = new StudentDBPersistence();
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public Student getStudentById(String id) {
        return studentDAO.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(String id) {
        studentDAO.deleteStudent(id);
    }
}