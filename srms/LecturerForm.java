import javax.swing.*;
import java.awt.*;

public class LecturerForm extends JFrame {

    private LecturerManager lecturerManager;

    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField deptField;

    public LecturerForm(LecturerManager lecturerManager) {
        this.lecturerManager = lecturerManager;

        setTitle("Lecturer Form");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Lecturer ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        panel.add(lastNameField);

        panel.add(new JLabel("Department:"));
        deptField = new JTextField();
        panel.add(deptField);

        JButton addBtn = new JButton("Add Lecturer");

        addBtn.addActionListener(e -> {
            Lecturer l = new Lecturer(
                    idField.getText(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    deptField.getText()
            );
            lecturerManager.addLecturer(l);
            JOptionPane.showMessageDialog(this, "Lecturer Added");
        });

        panel.add(addBtn);

        add(panel);
    }
}