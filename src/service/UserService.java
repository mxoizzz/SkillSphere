package service;

import java.util.List;

import dao.UserDAO;
import model.User;
import utils.PasswordUtils;

public class UserService {

    private UserDAO userDAO;
    public UserService() {
        this.userDAO = new UserDAO();
    }

    public String registerUser(User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return "Name cannot be empty.";
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return "Email cannot be empty.";
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            return "Password cannot be empty.";
        }

        User existingUser = userDAO.getUserByEmail(user.getEmail());
        if (existingUser != null) {
            return "Email is already registered.";
        }

        user.setPassword(PasswordUtils.hashPassword(user.getPassword()));

        boolean isRegistered = userDAO.registerUser(user);
        return isRegistered ? "User registered successfully." : "Registration failed. Please try again.";
    }

    public User loginUser(String email, String password){
        User user = userDAO.getUserByEmail(email);
        if (user == null) return null;

        boolean valid = PasswordUtils.checkPassword(password, user.getPassword());
        return valid ? user : null;
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public String updateUserProfile(User user) {
        if(user.getUserId() <= 0){
            return "Invalid user ID.";
        }

        boolean isUpdated = userDAO.updateUserProfile(user);
        return isUpdated ? "Profile updated successfully." : "Profile update failed. Please try again.";
    }
}
