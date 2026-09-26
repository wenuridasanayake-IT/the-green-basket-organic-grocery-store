package view;

import javax.swing.*;
import javax.swing.table.*;
import controller.ProductController;
import java.sql.*;

public class ViewProducts extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewProducts() {
        setTitle("View Products");
        setSize(500,300);

        model = new DefaultTableModel(
            new String[]{"ID","Name","Price","Qty"},0);
        table = new JTable(model);

        load();

        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");

        update.addActionListener(e -> update());
        delete.addActionListener(e -> delete());

        JPanel p = new JPanel();
        p.add(update); p.add(delete);

        add(new JScrollPane(table),"Center");
        add(p,"South");
        setVisible(true);
    }

    void load() {
        try {
            ResultSet rs = ProductController.getAllProducts();
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void update() {
        int r = table.getSelectedRow();
        if(r==-1) return;

        try {
            ProductController.updateProduct(
                Integer.parseInt(model.getValueAt(r,0).toString()),
                model.getValueAt(r,1).toString(),
                Double.parseDouble(model.getValueAt(r,2).toString()),
                Integer.parseInt(model.getValueAt(r,3).toString())
            );
            JOptionPane.showMessageDialog(this,"Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void delete() {
        int r = table.getSelectedRow();
        if(r==-1) return;

        try {
            ProductController.deleteProduct(
                Integer.parseInt(model.getValueAt(r,0).toString()));
            model.removeRow(r);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}