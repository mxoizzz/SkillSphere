package model;

public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private int roleId;
    private String profileInfo;
    private String resumePath;
    private String createdAt;
    private String updatedAt;

    public User(){}
    public User(int userId, String name, String email, String password, int roleId, String profileInfo, String resumePath, String createdAt, String updatedAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.profileInfo = profileInfo;
        this.resumePath = resumePath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getProfileInfo() {
        return profileInfo;
    }
    public void setProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }
    public String getResumePath() {
        return resumePath;
    }
    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", profileInfo='" + profileInfo + '\'' +
                ", resumePath='" + resumePath + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
