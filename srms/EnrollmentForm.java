import javax.swing.*;
import java.awt.*;

public class EnrollmentForm extends JFrame {

    private EnrollmentManager enrollmentManager;

    private JTextField idField;
    private JTextField studentIdField;
    private JTextField courseIdField;
    private JTextField semesterField;
    private JTextField yearField;

    public EnrollmentForm(EnrollmentManager enrollmentManager) {
        this.enrollmentManager = enrollmentManager;

        setTitle("Enrollment Form");
        setSize(400, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Enrollment ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        panel.add(studentIdField);

        panel.add(new JLabel("Course ID:"));
        courseIdField = new JTextField();
        panel.add(courseIdField);

        panel.add(new JLabel("Semester:"));
        semesterField = new JTextField();
        panel.add(semesterField);

        panel.add(new JLabel("Year:"));
        yearField = new JTextField();
        panel.add(yearField);

        JButton addBtn = new JButton("Add Enrollment");

        addBtn.addActionListener(e -> {
            Enrollment en = new Enrollment(
                    idField.getText(),
                    studentIdField.getText(),
                    courseIdField.getText(),
                    Integer.parseInt(semesterField.getText()),
                    Integer.parseInt(yearField.getText()),
                    "2026-01-01"
            );

            enrollmentManager.addEnrollment(en);
            JOptionPane.showMessageDialog(this, "Enrollment Added");
        });

        panel.add(addBtn);

        add(panel);
    }
}