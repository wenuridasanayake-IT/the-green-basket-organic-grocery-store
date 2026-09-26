package view;

import javax.swing.*;
import controller.ProductController;

public class AddProduct extends JFrame {

    JTextField name, price, qty;

    public AddProduct() {
        setTitle("Add Product");
        setSize(300,250);
        setLayout(null);

        add(label("Name",20,30));
        name = field(100,30);

        add(label("Price",20,70));
        price = field(100,70);

        add(label("Qty",20,110));
        qty = field(100,110);

        JButton save = new JButton("Save");
        save.setBounds(100,150,80,30);
        add(save);

        save.addActionListener(e -> {
            try {
                ProductController.addProduct(
                    name.getText(),
                    Double.parseDouble(price.getText()),
                    Integer.parseInt(qty.getText())
                );
                JOptionPane.showMessageDialog(this,"Product Added");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        setVisible(true);
    }

    JLabel label(String t,int x,int y){
        JLabel l=new JLabel(t); l.setBounds(x,y,80,25); return l;
    }
    JTextField field(int x,int y){
        JTextField f=new JTextField(); f.setBounds(x,y,150,25); add(f); return f;
    }
}