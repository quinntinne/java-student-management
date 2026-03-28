import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDBPersistence implements EnrollmentDAO {

    private Connection conn;

    public EnrollmentDBPersistence() {
        try {
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
    // ADD
    // =========================
    @Override
    public void addEnrollment(Enrollment enrollment) {

        String sql = "INSERT INTO enrollment (id, studentId, courseId) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, enrollment.getId());
            ps.setString(2, enrollment.getStudentId());
            ps.setString(3, enrollment.getCourseId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<Enrollment> getAllEnrollments() {

        List<Enrollment> list = new ArrayList<>();

        String sql = "SELECT * FROM enrollment";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Enrollment e = new Enrollment(
                        rs.getString("id"),
                        rs.getString("studentId"),
                        rs.getString("courseId")
                );

                list.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // =========================
    // GET BY ID
    // =========================
    @Override
    public Enrollment getEnrollmentById(String id) {

        String sql = "SELECT * FROM enrollment WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Enrollment(
                        rs.getString("id"),
                        rs.getString("studentId"),
                        rs.getString("courseId")
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
    public void updateEnrollment(Enrollment enrollment) {

        String sql = "UPDATE enrollment SET studentId=?, courseId=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, enrollment.getStudentId());
            ps.setString(2, enrollment.getCourseId());
            ps.setString(3, enrollment.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void deleteEnrollment(String id) {

        String sql = "DELETE FROM enrollment WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}