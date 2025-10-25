package main;

import java.sql.Connection;

import utils.DBConnection;

public class SkillSphereApp {
    public static void main(String[] args) {
        System.out.println("Starting SkillSphere Application!");

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("Application is connected to the database.");
        }
        else {
            System.out.println("Failed to connect to the database.");
        }

        DBConnection.closeConnection();
        System.out.println("SkillSphere Application Ended.");
    }
}
