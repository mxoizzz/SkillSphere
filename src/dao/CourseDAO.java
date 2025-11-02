package dao;

import model.Course;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public boolean addCourse(Course course) {
        String query = "INSERT INTO courses (title, description, mentor_id, price, status, created_at, updated_at) " +
                       "VALUES (?, ?, ?, ?, ?, NOW(), NOW())";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, course.getTitle());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getMentorId());
            ps.setDouble(4, course.getPrice());
            ps.setString(5, course.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Course c = extractCourseFromResultSet(rs);
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return list;
    }

    public List<Course> getCoursesByMentor(int mentorId) {
        List<Course> list = new ArrayList<>();
        String query = "SELECT * FROM courses WHERE mentor_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, mentorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractCourseFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return list;
    }

    private Course extractCourseFromResultSet(ResultSet rs) throws SQLException {
        Course c = new Course();
        c.setCourseId(rs.getInt("course_id"));
        c.setTitle(rs.getString("title"));
        c.setDescription(rs.getString("description"));
        c.setMentorId(rs.getInt("mentor_id"));
        c.setPrice(rs.getDouble("price"));
        c.setStatus(rs.getString("status"));
        c.setCreatedAt(rs.getString("created_at"));
        c.setUpdatedAt(rs.getString("updated_at"));
        return c;
    }
}
