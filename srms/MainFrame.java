import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // =========================
    // Application Layer (Managers)
    // =========================
    private StudentManager studentManager;
    private CourseManager courseManager;
    private LecturerManager lecturerManager;
    private EnrollmentManager enrollmentManager;
    private ExamResultsManager examResultsManager;
    private CourseAllocationManager courseAllocationManager;

    // =========================
    // Constructor
    // =========================
    public MainFrame(StudentManager studentManager) {

        // Inject Student Manager from Main
        this.studentManager = studentManager;

        // Initialize other managers
        this.courseManager = new CourseManager();
        this.lecturerManager = new LecturerManager();
        this.enrollmentManager = new EnrollmentManager();
        this.examResultsManager = new ExamResultsManager();
        this.courseAllocationManager = new CourseAllocationManager();

        // Frame settings
        setTitle("Student Record Management System");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build UI
        initUI();
    }

    // =========================
    // UI Initialization
    // =========================
    private void initUI() {

        setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("SYSTEM DASHBOARD", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(titleLabel, BorderLayout.NORTH);

        // Center panel with buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 20, 20));

        // Buttons
        JButton studentBtn = new JButton("Student Module");
        JButton courseBtn = new JButton("Course Module");
        JButton lecturerBtn = new JButton("Lecturer Module");
        JButton enrollmentBtn = new JButton("Enrollment Module");
        JButton resultsBtn = new JButton("Exam Results Module");
        JButton allocationBtn = new JButton("Course Allocation Module");

        // =========================
        // Button Actions
        // =========================

        studentBtn.addActionListener(e -> {
            new StudentForm(studentManager).setVisible(true);
        });

        courseBtn.addActionListener(e -> {
            new CourseForm(courseManager).setVisible(true);
        });

        lecturerBtn.addActionListener(e -> {
            new LecturerForm(lecturerManager).setVisible(true);
        });

        enrollmentBtn.addActionListener(e -> {
            new EnrollmentForm(enrollmentManager).setVisible(true);
        });

        resultsBtn.addActionListener(e -> {
            new ExamResultsForm(examResultsManager).setVisible(true);
        });

        allocationBtn.addActionListener(e -> {
            new CourseAllocationForm(courseAllocationManager).setVisible(true);
        });

        // Add buttons to panel
        panel.add(studentBtn);
        panel.add(courseBtn);
        panel.add(lecturerBtn);
        panel.add(enrollmentBtn);
        panel.add(resultsBtn);
        panel.add(allocationBtn);

        add(panel, BorderLayout.CENTER);
    }
}