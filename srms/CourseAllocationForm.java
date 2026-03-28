import javax.swing.*;
import java.awt.*;

public class CourseAllocationForm extends JFrame {

    private CourseAllocationManager manager;

    private JTextField idField;
    private JTextField courseIdField;
    private JTextField lecturerIdField;
    private JTextField semesterField;
    private JTextField yearField;

    public CourseAllocationForm(CourseAllocationManager manager) {
        this.manager = manager;

        setTitle("Course Allocation Form");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initUI();
    }

    private void initUI() {

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        panel.add(new JLabel("Allocation ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Course ID:"));
        courseIdField = new JTextField();
        panel.add(courseIdField);

        panel.add(new JLabel("Lecturer ID:"));
        lecturerIdField = new JTextField();
        panel.add(lecturerIdField);

        panel.add(new JLabel("Semester:"));
        semesterField = new JTextField();
        panel.add(semesterField);

        panel.add(new JLabel("Year:"));
        yearField = new JTextField();
        panel.add(yearField);

        JButton addBtn = new JButton("Add Allocation");

        addBtn.addActionListener(e -> addAllocation());

        panel.add(addBtn);

        add(panel);
    }

    private void addAllocation() {

        try {
            CourseAllocation allocation = new CourseAllocation(
                    idField.getText(),
                    courseIdField.getText(),
                    lecturerIdField.getText(),
                    Integer.parseInt(semesterField.getText()),
                    Integer.parseInt(yearField.getText())
            );

            manager.addAllocation(allocation);

            JOptionPane.showMessageDialog(this, "Allocation Added Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}