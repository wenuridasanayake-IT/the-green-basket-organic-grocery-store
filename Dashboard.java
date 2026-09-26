package view;

import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Dashboard");
        setSize(300,250);
        setLayout(null);

        JButton add = new JButton("Add Product");
        add.setBounds(70,40,150,30);
        add(add);

        JButton view = new JButton("View Products");
        view.setBounds(70,90,150,30);
        add(view);
        
        JButton sales = new JButton("Sales");
        sales.setBounds(70,140,150,30);
        add(sales);

        sales.addActionListener(e -> new SalesPage());
        add.addActionListener(e -> new AddProduct());
        view.addActionListener(e -> new ViewProducts());

        setVisible(true);
    }
}