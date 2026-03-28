import java.util.ArrayList;
import java.util.List;

public class LecturerFilePersistence implements LecturerDAO {

    private List<Lecturer> lecturers = new ArrayList<>();

    @Override
    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturers;
    }

    @Override
    public Lecturer getLecturerById(String id) {
        for (Lecturer l : lecturers) {
            if (l.getLecturerId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public void updateLecturer(Lecturer lecturer) {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getLecturerId().equals(lecturer.getLecturerId())) {
                lecturers.set(i, lecturer);
                return;
            }
        }
    }

    @Override
    public void deleteLecturer(String id) {
        lecturers.removeIf(l -> l.getLecturerId().equals(id));
    }
}