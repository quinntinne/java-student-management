import java.util.List;

public interface LecturerDAO {

    void addLecturer(Lecturer lecturer);

    List<Lecturer> getAllLecturers();

    Lecturer getLecturerById(String id);

    void updateLecturer(Lecturer lecturer);

    void deleteLecturer(String id);
}