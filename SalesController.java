package controller;

import database.DBConnection;
import java.sql.*;

public class SalesController {

    // Products load (ComboBox එකට)
    public static ResultSet getProducts() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT name, price, quantity FROM products");
    }

    // Sale save + stock update
    public static void addSale(String product, int qty, double total) throws Exception {
        Connection con = DBConnection.getConnection();

        // insert sale
        PreparedStatement pst = con.prepareStatement(
            "INSERT INTO sales(product_name, quantity, total) VALUES(?,?,?)"
        );
        pst.setString(1, product);
        pst.setInt(2, qty);
        pst.setDouble(3, total);
        pst.executeUpdate();

        // update product stock
        PreparedStatement pst2 = con.prepareStatement(
            "UPDATE products SET quantity = quantity - ? WHERE name = ?"
        );
        pst2.setInt(1, qty);
        pst2.setString(2, product);
        pst2.executeUpdate();
    }

    // View sales
    public static ResultSet getSales() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT * FROM sales");
    }
}
