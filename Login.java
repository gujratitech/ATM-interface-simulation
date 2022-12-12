package bankmanagement;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

        JButton login,signup,clear;
        JTextField cardTextField;
        JPasswordField pinTextField;
    Login(){


        setTitle("AUTOMATIC TAILOR MACHINE");
        setLayout(null);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image icon2 = icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label = new JLabel(icon3);
        label.setBounds(100,10,100,100);
        add(label);

       JLabel text  = new JLabel("Welcome To ATM");
       text.setFont(new Font("Osward", Font.BOLD,38));
       text.setBounds(220,40,400,40);
        add(text);

        JLabel cardno  = new JLabel("Card No.");
       cardno.setFont(new Font("Raleway", Font.BOLD,24));
       cardno.setBounds(120,150,150,40);
        add(cardno);

         cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(cardTextField);

        JLabel pin  = new JLabel("PIN");
       pin.setFont(new Font("Osward", Font.BOLD,24));
       pin.setBounds(120,220,400,40);
        add(pin);

         pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 15));

        add(pinTextField);

         login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        add(clear);

         signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);

        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,500);
        setVisible(true);
        setLocation(300,150);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource() == login){
            Connectivity conn = new Connectivity();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
              ResultSet rs =  conn.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null,"Incorrect cardnumber and pin");
              }
            }catch (Exception ae){
                System.out.println(ae);
            }
            
        } else if (e.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
         Login l =   new Login();
    }
}