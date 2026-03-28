@Override
public List<Course> getAllCourses() {
    List<Course> list = new ArrayList<>();

    String sql = "SELECT * FROM course";

    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Course course = new Course(
                rs.getString("id"),
                rs.getString("name")
            );
            list.add(course);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}