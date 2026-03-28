import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LecturerDBPersistence implements LecturerDAO {

    private Connection conn;

    // Constructor: establish DB connection
    public LecturerDBPersistence() {
        try {
            // Change DB name, username, password if needed
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/srms",
                    "root",
                    "password"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // CREATE
    // =========================
    @Override
    public void addLecturer(Lecturer lecturer) {
        String sql = "INSERT INTO lecturer (lecturerId, firstName, lastName, department) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lecturer.getLecturerId());
            ps.setString(2, lecturer.getFirstName());
            ps.setString(3, lecturer.getLastName());
            ps.setString(4, lecturer.getDepartment());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // READ ALL
    // =========================
    @Override
    public List<Lecturer> getAllLecturers() {
        List<Lecturer> list = new ArrayList<>();

        String sql = "SELECT * FROM lecturer";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Lecturer lecturer = new Lecturer(
                        rs.getString("lecturerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("department")
                );
                list.add(lecturer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // =========================
    // READ BY ID
    // =========================
    @Override
    public Lecturer getLecturerById(String id) {
        String sql = "SELECT * FROM lecturer WHERE lecturerId = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Lecturer(
                        rs.getString("lecturerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("department")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    public void updateLecturer(Lecturer lecturer) {
        String sql = "UPDATE lecturer SET firstName=?, lastName=?, department=? WHERE lecturerId=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lecturer.getFirstName());
            ps.setString(2, lecturer.getLastName());
            ps.setString(3, lecturer.getDepartment());
            ps.setString(4, lecturer.getLecturerId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void deleteLecturer(String id) {
        String sql = "DELETE FROM lecturer WHERE lecturerId=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}