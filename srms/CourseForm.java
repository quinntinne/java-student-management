import javax.swing.*;
import java.awt.*;

public class CourseForm extends JFrame {

    private CourseManager courseManager;

    private JTextField idField;
    private JTextField nameField;

    public CourseForm(CourseManager courseManager) {
        this.courseManager = courseManager;

        setTitle("Course Form");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Course ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Course Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        JButton addBtn = new JButton("Add Course");

        addBtn.addActionListener(e -> addCourse());

        panel.add(addBtn);

        add(panel);
    }

    private void addCourse() {
        String id = idField.getText();
        String name = nameField.getText();

        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        Course course = new Course(id, name);
        courseManager.addCourse(course);

        JOptionPane.showMessageDialog(this, "Course Added Successfully");

        idField.setText("");
        nameField.setText("");
    }
}