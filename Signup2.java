package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    long random;
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    String formno;
    JComboBox religion, occupation,incomecategory,category,education;
    Signup2(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionaldetails = new JLabel("Page 2: Personal Details" );
        additionaldetails.setFont(new Font("Raleway", Font.BOLD,24));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
//        nameTextField = new JTextField();
//        nameTextField.setFont(new Font("Raleway,",Font.BOLD, 14));
//        nameTextField.setBounds(300,140,400,30);
        add(name);
        String valreligion[] = {"Select Religion","Hindu","Muslim", "Christian", "Jain", "Other"};
        religion= new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        String valcategory[] = {"Select Category","General","OBC", "SC", "ST", "Other"};
        category= new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
//        fnameTextField = new JTextField();
//        fnameTextField.setFont(new Font("Raleway,",Font.BOLD, 14));
//        fnameTextField.setBounds(300,190,400,30);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        String income[] = {"Select Income","Null","<150000", "<250000", "<500000", "Upto 1000000"};
        incomecategory= new JComboBox(income);
        incomecategory.setBounds(300,240,400,30);
        incomecategory.setBackground(Color.WHITE);
        add(incomecategory);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        String educationvalues[] = {"Select ","Non-Graduate","Graduate", "Post-Graduate", "Doctorate", "Others"};
        education= new JComboBox(educationvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel maritalstatus = new JLabel("Occupation:");
        maritalstatus.setFont(new Font("Raleway", Font.BOLD,20));
        maritalstatus.setBounds(100,390,200,30);
        add(maritalstatus);

        String occupationvalues[] = {"Select","Salaried ","Self-employed","Businessman", "Student", "Retired", "Others"};
        occupation= new JComboBox(occupationvalues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

//        married = new JRadioButton("Married");
//        married.setBounds(300,390,120,30);
//        married.setBackground(Color.WHITE);
//        add(married);
//
//        unmarried = new JRadioButton("Unmarried");
//        unmarried.setBounds(450,390,120,30);
//        unmarried.setBackground(Color.WHITE);
//        add(unmarried);
//
//        other = new JRadioButton("Others");
//        other.setBounds(630,390,100,30);
//        other.setBackground(Color.WHITE);
//        add(other);

//        ButtonGroup maritalgroup = new ButtonGroup();
//        maritalgroup.add(married);
//        maritalgroup.add(unmarried);
//        maritalgroup.add(other);

        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        pan = new JTextField();
        pan.setFont(new Font("Raleway,",Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway,",Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(300,540,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("NO");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("NO");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup emaritalgroup = new ButtonGroup();
        maritalgroup.add(eyes);
        maritalgroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,630,100,40);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String formno ="" + random; //long
        String sreligion = (String)religion.getSelectedItem();
        String scategory =  (String)category.getSelectedItem();
        String sincome = (String) incomecategory.getSelectedItem();
        String sedu = (String) education.getSelectedItem();
        String soccu = (String) occupation.getSelectedItem();
        String seniorciti = null;
        if(syes.isSelected()){
            seniorciti = "YES";
        } else if (sno.isSelected()) {
            seniorciti = "NO";
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "YES";
        } else if (eno.isSelected()) {
            existingaccount = "NO";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();


        try{
                Connectivity c = new Connectivity();
                String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+sedu+"','"+soccu+"','"+span+"','"+saadhar+"', '"+seniorciti+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);

                //Signup3 Object
            setVisible(false);
            new Signup3(formno).setVisible(true);


        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String args[]){
        new Signup2("");
    }
}
