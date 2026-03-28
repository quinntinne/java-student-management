public class CourseManager {

    private CourseDAO courseDAO;

    public CourseManager() {
        courseDAO = new CourseFilePersistence();
    }

    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }
}