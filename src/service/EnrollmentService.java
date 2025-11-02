package service;

import dao.EnrollmentDAO;
import model.Course;

import java.util.List;

public class EnrollmentService {
    private final EnrollmentDAO enrollmentDAO;

    public EnrollmentService() {
        this.enrollmentDAO = new EnrollmentDAO();
    }

    public String enrollCourse(int userId, int courseId) {
        boolean success = enrollmentDAO.enrollCourse(userId, courseId);
        return success ? "Enrollment successful." : "Enrollment failed or already enrolled.";
    }

    public List<Course> getEnrolledCoursesByUser(int userId) {
        return enrollmentDAO.getEnrolledCoursesByUser(userId);
    }
}
