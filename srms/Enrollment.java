import java.io.Serializable;

public class Enrollment implements Serializable {

    private String enrollmentId;
    private String studentId;
    private String courseId;
    private int semester;
    private int year;
    private String enrollmentDate;

    public Enrollment(String enrollmentId, String studentId, String courseId,
                      int semester, int year, String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.year = year;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public int getSemester() {
        return semester;
    }

    public int getYear() {
        return year;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    // Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return enrollmentId + " - Student: " + studentId +
               ", Course: " + courseId +
               ", Semester: " + semester +
               ", Year: " + year +
               ", Date: " + enrollmentDate;
    }
}