package model;

public class Enrollment {
    private int enrollmentId;
    private int userId;
    private int courseId;
    private double progress;
    private String status;
    private String enrolledAt;

    public Enrollment() {}

    public Enrollment(int userId, int courseId) {
        this.userId = userId;
        this.courseId = courseId;
        this.progress = 0;
        this.status = "Enrolled";
    }

    // Getters & Setters
    public int getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(int enrollmentId) { this.enrollmentId = enrollmentId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public double getProgress() { return progress; }
    public void setProgress(double progress) { this.progress = progress; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getEnrolledAt() { return enrolledAt; }
    public void setEnrolledAt(String enrolledAt) { this.enrolledAt = enrolledAt; }
}
