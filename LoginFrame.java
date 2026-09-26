package view;

import javax.swing.*;
import controller.LoginController;

public class LoginFrame extends JFrame {

    JTextField user;
    JPasswordField pass;

    public LoginFrame() {
        setTitle("Login");
        setSize(300,200);
        setLayout(null);

        add(label("Username",20,30));
        user = field(110,30);

        add(label("Password",20,70));
        pass = new JPasswordField();
        pass.setBounds(110,70,150,25);
        add(pass);

        JButton login = new JButton("Login");
        login.setBounds(100,110,80,30);
        add(login);

        login.addActionListener(e -> {
            if(LoginController.login(user.getText(), pass.getText())) {
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid Login");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    JLabel label(String t,int x,int y){
        JLabel l=new JLabel(t); l.setBounds(x,y,80,25); return l;
    }
    JTextField field(int x,int y){
        JTextField f=new JTextField(); f.setBounds(x,y,150,25); add(f); return f;
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}