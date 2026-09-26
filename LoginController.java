package controller;

import database.DBConnection;
import java.sql.*;

public class LoginController {

    public static boolean login(String user, String pass) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }
}