public class LecturerManager {

    private LecturerDAO lecturerDAO;

    public LecturerManager() {
        lecturerDAO = new LecturerFilePersistence();
    }

    public void addLecturer(Lecturer lecturer) {
        lecturerDAO.addLecturer(lecturer);
    }
}