package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel changepin = new JLabel("Change your pin");
        changepin.setForeground(Color.WHITE);
        changepin.setFont(new Font("System",Font.BOLD,16));
        changepin.setBounds(260,280,500,35);
        image.add(changepin);

        JLabel pintext = new JLabel("New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,330,180,25);
        image.add(pintext);
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(310,330,190,25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,370,180,25);
        image.add(repintext);
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(310,370,190,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,470,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,510,150,30);
        back.addActionListener(this);
        image.add(back);




        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == change) {

            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter new PIN");
                }
                Connectivity c = new Connectivity();
                String query1 = "update bank set pin = '"+repin+"' where pin = '"+pinnumber+"'" ;
                String query2 = "update login set pin = '"+repin+"' where pin = '"+pinnumber+"'" ;
                String query3 = "update signup3 set pin = '"+repin+"' where pin = '"+pinnumber+"'" ;
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                new Transactions(rpin).setVisible(true);

            } catch (Exception ae) {
                System.out.println(ae);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
