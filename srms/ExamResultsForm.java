import javax.swing.*;
import java.awt.*;

public class ExamResultsForm extends JFrame {

    private ExamResultsManager manager;

    private JTextField idField;
    private JTextField studentIdField;
    private JTextField courseIdField;
    private JTextField marksField;

    public ExamResultsForm(ExamResultsManager manager) {
        this.manager = manager;

        setTitle("Exam Results Form");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initUI();
    }

    private void initUI() {

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        panel.add(new JLabel("Result ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        panel.add(studentIdField);

        panel.add(new JLabel("Course ID:"));
        courseIdField = new JTextField();
        panel.add(courseIdField);

        panel.add(new JLabel("Marks:"));
        marksField = new JTextField();
        panel.add(marksField);

        JButton addBtn = new JButton("Add Result");

        addBtn.addActionListener(e -> addResult());

        panel.add(addBtn);

        add(panel);
    }

    private void addResult() {

        try {
            ExamResults result = new ExamResults(
                    idField.getText(),
                    studentIdField.getText(),
                    courseIdField.getText(),
                    Integer.parseInt(marksField.getText())
            );

            manager.addResult(result);

            JOptionPane.showMessageDialog(this, "Result Added Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}