package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    Signup3( String formno){
         this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,250,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupacc = new ButtonGroup();
        groupacc.add(r1);
        groupacc.add(r2);
        groupacc.add(r3);
        groupacc.add(r4);

        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD,22));
        cardno.setBounds(100,300,200,30);
        add(cardno);
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        JLabel carddetial = new JLabel("Your 16 digit card no");
        carddetial.setFont(new Font("Raleway", Font.BOLD,12));
        carddetial.setBounds(100,330,300,20);
        add(carddetial);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        JLabel pidetail = new JLabel("Your 4 Digit pin no.");
        pidetail.setFont(new Font("Raleway", Font.BOLD,12));
        pidetail.setBounds(100,400,300,20);
        add(pidetail);

        JLabel servicesreq = new JLabel("Services Required:");
        servicesreq.setFont(new Font("Raleway", Font.BOLD,22));
        servicesreq.setBounds(100,450,400,30);
        add(servicesreq);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & Sms Elerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,500,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E- Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);


        c7 = new JCheckBox("I here by declares that the above entered details are valid to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100,650,550,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD,14));
        submit.setBounds(650,650,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD,14));
        cancel.setBounds(760,650,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);


        setSize(850,850);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";

            }else if (r3.isSelected()) {
                accountType = "Current Account";

            }else if (r4.isSelected()) {
                accountType = "Recurring Account";

            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
                
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";

            } else if (c4.isSelected()) {
                facility = facility + "Emial & SMS Alerts";

            } else if (c5.isSelected()) {
                facility = facility + "Cheque Book";

            } else if (c6.isSelected()) {
                facility = facility + "E- Statement";

            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required" );
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null,"Declaration is Required");
                } else if (facility.equals("")) {
                    JOptionPane.showMessageDialog(null,"Services is Required");
                }
                else{
                    Connectivity c = new Connectivity();
                    String query1 = "insert into signup3 values('"+formno+"', '"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Cardnumber" +cardnumber+ "\n Pin:" + pinnumber);
                }
            }catch (Exception ae){
                System.out.println(ae);
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup3("");
    }
}
