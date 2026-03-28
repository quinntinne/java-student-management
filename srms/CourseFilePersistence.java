import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseFilePersistence implements CourseDAO {

    private static final String FILE_NAME = "courses.txt";

    // ✅ Add course
    @Override
    public void addCourse(Course course) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(course.getId() + "," + course.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Get all courses
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    Course course = new Course(parts[0], parts[1]);
                    courses.add(course);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }

    // ✅ Get by ID
    @Override
    public Course getCourseById(String id) {
        List<Course> courses = getAllCourses();

        for (Course c : courses) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    // ✅ Update course
    @Override
    public void updateCourse(Course course) {
        List<Course> courses = getAllCourses();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Course c : courses) {
                if (c.getId().equals(course.getId())) {
                    writer.write(course.getId() + "," + course.getName());
                } else {
                    writer.write(c.getId() + "," + c.getName());
                }
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete course
    @Override
    public void deleteCourse(String id) {
        List<Course> courses = getAllCourses();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Course c : courses) {
                if (!c.getId().equals(id)) {
                    writer.write(c.getId() + "," + c.getName());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}