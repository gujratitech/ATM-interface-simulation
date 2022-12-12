package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit,exit,balanceenq,pinchange,ministat,fastcash,withdraw;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);
        JLabel text = new JLabel("SELECT WITHDRWAWAL AMOUNT");
        text.setBounds(225,200,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16 ));
        image.add(text);
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,313,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(355,313,150,30);
        withdraw.addActionListener(this);

        image.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,348,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministat = new JButton("Rs 2000");
        ministat.setBounds(355,348,150,30);
        ministat.addActionListener(this);

        image.add(ministat);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,385,150,30);
        pinchange.addActionListener(this);

        image.add(pinchange);

        balanceenq = new JButton("Rs 10000");
        balanceenq.setBounds(355,382,150,30);
        balanceenq.addActionListener(this);

        image.add(balanceenq);

        exit = new JButton("Back");
        exit.setBounds(355,415,150,30);
        exit.addActionListener(this);

        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Connectivity conn = new Connectivity();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource() !=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs" + amount + "Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch (Exception ae){
                System.out.println(ae);
            }
        }
    }



    public static void main(String[] args) {
        new Fastcash ("");
    }
}
