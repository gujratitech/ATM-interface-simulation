package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,exit,balanceenq,pinchange,ministat,fastcash,withdraw;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(225,200,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16 ));
        image.add(text);
        deposit = new JButton("Deposit");
        deposit.setBounds(170,313,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBounds(355,313,150,30);
        withdraw.addActionListener(this);

        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,348,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministat = new JButton("Mini Statement");
        ministat.setBounds(355,348,150,30);
        ministat.addActionListener(this);

        image.add(ministat);

        pinchange = new JButton("Change Pin");
        pinchange.setBounds(170,385,150,30);
        pinchange.addActionListener(this);

        image.add(pinchange);

        balanceenq = new JButton("Balance Enquiry");
        balanceenq.setBounds(355,382,150,30);
        balanceenq.addActionListener(this);

        image.add(balanceenq);

        exit = new JButton("Exit");
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
            System.exit(0);
        } else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (e.getSource() == withdraw) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (e.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        } else if (e.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
            
        }
    }



    public static void main(String[] args) {
        new Transactions("");
    }
}
