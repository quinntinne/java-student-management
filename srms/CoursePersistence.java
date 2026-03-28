import java.util.ArrayList;

public interface CoursePersistence {

    void addCourse(Course c);

    ArrayList<Course> getAllCourses();

    void updateCourse(Course c);

    void deleteCourse(String id);
}