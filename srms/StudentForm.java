import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;

    private StudentManager studentManager;

    public StudentForm(StudentManager manager) {

        this.studentManager = manager;

        setTitle("Student Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        // Labels and fields
        add(new JLabel("Student ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        // Buttons
        JButton addButton = new JButton("Add Student");
        JButton clearButton = new JButton("Clear");

        add(addButton);
        add(clearButton);

        // =========================
        // ADD BUTTON ACTION
        // =========================
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Student student = new Student(
                            idField.getText(),
                            nameField.getText(),
                            emailField.getText()
                    );

                    studentManager.addStudent(student);

                    JOptionPane.showMessageDialog(null, "Student Added Successfully");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // =========================
        // CLEAR BUTTON
        // =========================
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                nameField.setText("");
                emailField.setText("");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}