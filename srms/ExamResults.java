public class ExamResults {

    private String id;
    private String studentId;
    private String courseId;
    private int marks;

    public ExamResults(String id, String studentId, String courseId, int marks) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.marks = marks;
    }

    public String getId() { return id; }
    public String getStudentId() { return studentId; }
    public String getCourseId() { return courseId; }
    public int getMarks() { return marks; }
}