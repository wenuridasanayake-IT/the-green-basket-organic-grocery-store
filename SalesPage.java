package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.SalesController;
import java.sql.ResultSet;

public class SalesPage extends JFrame {

    JComboBox<String> cmbProducts;
    JTextField txtQty;
    JTable table;
    DefaultTableModel model;

    public SalesPage() {
        setTitle("Sales");
        setSize(500,350);
        setLayout(null);

        cmbProducts = new JComboBox<>();
        cmbProducts.setBounds(20,20,150,25);
        add(cmbProducts);

        txtQty = new JTextField();
        txtQty.setBounds(190,20,80,25);
        add(txtQty);

        JButton btnSell = new JButton("Sell");
        btnSell.setBounds(290,20,80,25);
        add(btnSell);

        model = new DefaultTableModel(
            new String[]{"ID","Product","Qty","Total"}, 0
        );
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,70,440,200);
        add(sp);

        loadProducts();
        loadSales();

        btnSell.addActionListener(e -> makeSale());

        setVisible(true);
    }

    void loadProducts() {
        try {
            ResultSet rs = SalesController.getProducts();
            while(rs.next()) {
                cmbProducts.addItem(rs.getString("name"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    void loadSales() {
        try {
            model.setRowCount(0);
            ResultSet rs = SalesController.getSales();
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("product_name"),
                    rs.getInt("quantity"),
                    rs.getDouble("total")
                });
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    void makeSale() {
        try {
            String product = cmbProducts.getSelectedItem().toString();
            int qty = Integer.parseInt(txtQty.getText());

            double price = 100; // simple demo price
            double total = qty * price;

            SalesController.addSale(product, qty, total);
            JOptionPane.showMessageDialog(this, "Sale Successful");

            loadSales();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

