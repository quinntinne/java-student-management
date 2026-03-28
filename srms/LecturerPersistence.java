import java.util.ArrayList;

public interface LecturerPersistence {

    void addLecturer(Lecturer l);

    ArrayList<Lecturer> getAllLecturers();

    void updateLecturer(Lecturer l);

    void deleteLecturer(String id);
}