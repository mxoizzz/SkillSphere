package dao;

import model.Course;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public boolean enrollCourse(int userId, int courseId) {
        String query = "INSERT INTO enrollments (user_id, course_id, progress, status, enrolled_at) VALUES (?, ?, 0, 'Enrolled', NOW())";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public List<Course> getEnrolledCoursesByUser(int userId) {
        List<Course> courses = new ArrayList<>();
        String query = """
            SELECT c.* FROM enrollments e
            JOIN courses c ON e.course_id = c.course_id
            WHERE e.user_id = ?
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("course_id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setMentorId(rs.getInt("mentor_id"));
                c.setPrice(rs.getDouble("price"));
                c.setStatus(rs.getString("status"));
                c.setCreatedAt(rs.getString("created_at"));
                c.setUpdatedAt(rs.getString("updated_at"));
                courses.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return courses;
    }
}
