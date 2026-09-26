package controller;

import database.DBConnection;
import java.sql.*;

public class ProductController {

    public static ResultSet getAllProducts() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT * FROM products");
    }

    public static void addProduct(String name, double price, int qty) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(
            "INSERT INTO products(name,price,quantity) VALUES(?,?,?)");
        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setInt(3, qty);
        pst.executeUpdate();
    }

    public static void updateProduct(int id, String name, double price, int qty) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(
            "UPDATE products SET name=?,price=?,quantity=? WHERE id=?");
        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setInt(3, qty);
        pst.setInt(4, id);
        pst.executeUpdate();
    }

    public static void deleteProduct(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(
            "DELETE FROM products WHERE id=?");
        pst.setInt(1, id);
        pst.executeUpdate();
    }
}