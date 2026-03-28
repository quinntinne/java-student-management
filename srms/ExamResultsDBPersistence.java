import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamResultsDBPersistence implements ExamResultsDAO {

    private Connection conn;

    // =========================
    // CONNECT
    // =========================
    public ExamResultsDBPersistence() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/srms",
                    "root",
                    "password"   // change if needed
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // ADD
    // =========================
    @Override
    public void addResult(ExamResults result) {

        String sql = "INSERT INTO exam_results (id, studentId, courseId, marks) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, result.getId());
            ps.setString(2, result.getStudentId());
            ps.setString(3, result.getCourseId());
            ps.setInt(4, result.getMarks());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<ExamResults> getAllResults() {

        List<ExamResults> list = new ArrayList<>();

        String sql = "SELECT * FROM exam_results";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                ExamResults result = new ExamResults(
                        rs.getString("id"),
                        rs.getString("studentId"),
                        rs.getString("courseId"),
                        rs.getInt("marks")
                );

                list.add(result);
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
    public ExamResults getResultById(String id) {

        String sql = "SELECT * FROM exam_results WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new ExamResults(
                        rs.getString("id"),
                        rs.getString("studentId"),
                        rs.getString("courseId"),
                        rs.getInt("marks")
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
    public void updateResult(ExamResults result) {

        String sql = "UPDATE exam_results SET studentId=?, courseId=?, marks=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, result.getStudentId());
            ps.setString(2, result.getCourseId());
            ps.setInt(3, result.getMarks());
            ps.setString(4, result.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void deleteResult(String id) {

        String sql = "DELETE FROM exam_results WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}