import java.util.List;

public interface CourseDAO {

    void addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(String id);

    void updateCourse(Course course);

    void deleteCourse(String id);
}