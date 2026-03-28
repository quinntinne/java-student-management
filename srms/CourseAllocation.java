public class CourseAllocation {

    private String id;
    private String courseId;
    private String lecturerId;
    private int semester;
    private int year;

    // ✅ MATCHES your form
    public CourseAllocation(String id, String courseId, String lecturerId, int semester, int year) {
        this.id = id;
        this.courseId = courseId;
        this.lecturerId = lecturerId;
        this.semester = semester;
        this.year = year;
    }

    // Getters
    public String getId() { return id; }
    public String getCourseId() { return courseId; }
    public String getLecturerId() { return lecturerId; }
    public int getSemester() { return semester; }
    public int getYear() { return year; }
}