import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentManager studentManager = new StudentManager();

            MainFrame mainFrame = new MainFrame(studentManager);
            mainFrame.setVisible(true);
        });
    }
}