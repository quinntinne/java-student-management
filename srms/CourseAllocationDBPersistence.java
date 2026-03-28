import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseAllocationDBPersistence implements CourseAllocationDAO {

    private Connection conn;

    // =========================
    // CONNECT TO DATABASE
    // =========================
    public CourseAllocationDBPersistence() {
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
    public void addAllocation(CourseAllocation allocation) {

        String sql = "INSERT INTO course_allocation (id, courseId, lecturerId, semester, year) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, allocation.getId());
            ps.setString(2, allocation.getCourseId());
            ps.setString(3, allocation.getLecturerId());
            ps.setInt(4, allocation.getSemester());
            ps.setInt(5, allocation.getYear());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // GET ALL
    // =========================
    @Override
    public List<CourseAllocation> getAllAllocations() {

        List<CourseAllocation> list = new ArrayList<>();

        String sql = "SELECT * FROM course_allocation";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                CourseAllocation allocation = new CourseAllocation(
                        rs.getString("id"),
                        rs.getString("courseId"),
                        rs.getString("lecturerId"),
                        rs.getInt("semester"),
                        rs.getInt("year")
                );

                list.add(allocation);
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
    public CourseAllocation getAllocationById(String id) {

        String sql = "SELECT * FROM course_allocation WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CourseAllocation(
                        rs.getString("id"),
                        rs.getString("courseId"),
                        rs.getString("lecturerId"),
                        rs.getInt("semester"),
                        rs.getInt("year")
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
    public void updateAllocation(CourseAllocation allocation) {

        String sql = "UPDATE course_allocation SET courseId=?, lecturerId=?, semester=?, year=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, allocation.getCourseId());
            ps.setString(2, allocation.getLecturerId());
            ps.setInt(3, allocation.getSemester());
            ps.setInt(4, allocation.getYear());
            ps.setString(5, allocation.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE
    // =========================
    @Override
    public void deleteAllocation(String id) {

        String sql = "DELETE FROM course_allocation WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}