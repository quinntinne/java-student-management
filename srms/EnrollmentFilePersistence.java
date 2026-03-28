import java.io.*;
import java.util.ArrayList;

public class EnrollmentFilePersistence implements EnrollmentPersistence {

    private final String FILE_NAME = "enrollments.dat";

    @Override
    public void addEnrollment(Enrollment e) {
        ArrayList<Enrollment> list = getAllEnrollments();
        list.add(e);
        saveToFile(list);
    }

    @Override
    public ArrayList<Enrollment> getAllEnrollments() {
        ArrayList<Enrollment> list = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            list = (ArrayList<Enrollment>) ois.readObject();
        } catch (Exception e) {
            // file may not exist yet
        }

        return list;
    }

    @Override
    public void updateEnrollment(Enrollment updated) {
        ArrayList<Enrollment> list = getAllEnrollments();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEnrollmentId().equals(updated.getEnrollmentId())) {
                list.set(i, updated);
                break;
            }
        }

        saveToFile(list);
    }

    @Override
    public void deleteEnrollment(String id) {
        ArrayList<Enrollment> list = getAllEnrollments();

        list.removeIf(e -> e.getEnrollmentId().equals(id));

        saveToFile(list);
    }

    private void saveToFile(ArrayList<Enrollment> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}