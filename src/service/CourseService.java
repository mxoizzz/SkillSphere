package service;

import dao.CourseDAO;
import model.Course;
import java.util.List;

public class CourseService {
    private final CourseDAO courseDAO;

    public CourseService() {
        this.courseDAO = new CourseDAO();
    }

    public String addCourse(Course course) {
        if (course.getTitle() == null || course.getTitle().trim().isEmpty()) {
            return "Title cannot be empty.";
        }
        if (course.getMentorId() <= 0) {
            return "Invalid mentor.";
        }
        boolean success = courseDAO.addCourse(course);
        return success ? "Course added successfully." : "Failed to add course.";
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public List<Course> getCoursesByMentor(int mentorId) {
        return courseDAO.getCoursesByMentor(mentorId);
    }
}
