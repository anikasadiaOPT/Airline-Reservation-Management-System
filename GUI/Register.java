package GUI;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Register extends JFrame implements ActionListener{
    Font arial = new Font("Arial", Font.BOLD, 20);
    Font arialA = new Font("Arial", Font.PLAIN, 15);

    JLabel reglbl;
    JLabel namelbl;
    JTextField nametxt;
    JLabel usernamelbl;
    JTextField usernametxt;
    JLabel emailLbl;
    JTextField emailtxt;
    JLabel passlbl;
    JPasswordField pswrdfld;
    JLabel doblbl;
    JTextField dobtxt;
    JCheckBox termsBox;
    JButton regbtn;
    JLabel nameError;
    JLabel usernameError;
    JLabel emailError;
    JLabel passError;
    JLabel dobError, termsError;

    public Register(){
        this.setTitle("Registration");
        this.setSize(480, 500);
        this.setResizable(false);
        this.setLocation(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\Airline Reservation System\\Images\\Icon.png");
        this.setIconImage(icon.getImage());

        reglbl = new JLabel("Registration");
        reglbl.setBounds(150, 20, 200, 50);
        reglbl.setFont(arial);
        this.add(reglbl);

        namelbl = new JLabel("Enter Name: ");
        namelbl.setBounds(50, 60, 150, 50);
        namelbl.setFont(arialA);
        this.add(namelbl);

        nametxt = new JTextField();
        nametxt.setBounds(50, 100, 250, 25);
        nametxt.setFont(arialA);
        this.add(nametxt);

        usernamelbl = new JLabel("Enter Username: ");
        usernamelbl.setBounds(50, 110, 150, 50);
        usernamelbl.setFont(arialA);
        this.add(usernamelbl);

        usernametxt = new JTextField();
        usernametxt.setBounds(50, 150, 250, 25);
        usernametxt.setFont(arialA);
        this.add(usernametxt);

        emailLbl = new JLabel("Enter Email Address: (ex. xyz@gmail.com)");
        emailLbl.setBounds(50, 165, 350, 50);
        emailLbl.setFont(arialA);
        this.add(emailLbl);

        emailtxt = new JTextField();
        emailtxt.setBounds(50, 200, 250, 25);
        emailtxt.setFont(arialA);
        this.add(emailtxt);

        
        passlbl = new JLabel("Password: ");
        passlbl.setBounds(50, 220, 400, 50);
        passlbl.setFont(arialA);
        this.add(passlbl);

        pswrdfld = new JPasswordField();
        pswrdfld.setBounds(50, 260, 250, 25);
        pswrdfld.setFont(arialA);
        this.add(pswrdfld);

        doblbl = new JLabel("Date of Birth: (ex. DD/MM/YYYY)");
        doblbl.setBounds(50, 280, 300, 50);
        doblbl.setFont(arialA);
        this.add(doblbl);

        dobtxt = new JTextField();
        dobtxt.setBounds(50, 320, 250, 25);
        dobtxt.setFont(arialA);
        this.add(dobtxt);

        termsBox = new JCheckBox("I agree to the terms and conditions");
        termsBox.setBounds(50, 350, 300, 30);
        this.add(termsBox);
//
nameError = new JLabel("");
nameError.setBounds(310, 100, 150, 25);
nameError.setForeground(Color.RED);
this.add(nameError);

usernameError = new JLabel("");
usernameError.setBounds(310, 150, 150, 25);
usernameError.setForeground(Color.RED);
this.add(usernameError);

emailError = new JLabel("");
emailError.setBounds(310, 200, 150, 25);
emailError.setForeground(Color.RED);
this.add(emailError);

passError = new JLabel("");
passError.setBounds(310, 260, 150, 25);
passError.setForeground(Color.RED);
this.add(passError);

dobError = new JLabel("");
dobError.setBounds(310, 320, 150, 25);
dobError.setForeground(Color.RED);
this.add(dobError);


        termsError = new JLabel("");
        termsError.setBounds(50, 380, 300, 25);
        termsError.setForeground(Color.RED);
        this.add(termsError);

        // Register button




//
        regbtn = new JButton("Register");
        regbtn.setBounds(280, 410, 100, 25);
        regbtn.addActionListener(this);
        this.add(regbtn);

        this.setVisible(true);
    }
    @Override
public void actionPerformed(ActionEvent e){
    if(e.getSource() == regbtn){
        // Reset error labels
        nameError.setText(""); 
        usernameError.setText(""); 
        emailError.setText("");
        passError.setText("");
        dobError.setText(""); 
        termsError.setText("");

        boolean valid = true;

        if(nametxt.getText().trim().isEmpty()) {
            nameError.setText("!");
            valid = false;
        }
        if(usernametxt.getText().trim().isEmpty()) {
            usernameError.setText("!");
            valid = false;
        }
        String email = emailtxt.getText().trim();
        if (email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            emailError.setText("Invalid email format");
            valid = false;
        }
        String password = String.valueOf(pswrdfld.getPassword()).trim();
        if (password.isEmpty()) {
            passError.setText("Password is required");
            valid = false;
        } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            passError.setText("Password must be at least 8 characters, include uppercase, lowercase, digit, and special character");
            valid = false;
        }
        if(dobtxt.getText().trim().isEmpty()) {
            dobError.setText("!");
            valid = false;
        }
        if(!termsBox.isSelected()) {
            termsError.setText("You must agree to continue");
            valid = false;
        }

        if(valid){
            // All fields are valid – open SeatSelectionGUI
            Login l = new Login();
            this.dispose(); // optional: close current window
        }
    }
}

}
