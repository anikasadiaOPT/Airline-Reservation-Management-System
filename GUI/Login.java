package GUI;
import Entities_All.SeatSelection;
import FileManagement.LoginManagement;
import Entities_All.User;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;



public class Login extends JFrame implements ActionListener{
    Font arial = new Font("Arial", Font.BOLD, 20);
    Font arialA = new Font("Arial", Font.PLAIN, 15);

    JLabel loginLbl;
    JLabel usernameLbl;
    JLabel emailLbl;
    JLabel passwordLbl;
    JTextField usernameTxt;
    JTextField emailTxt;
    JPasswordField passwordTxt;
    JButton loginBtn;
    LoginManagement loginManagement;

    public Login(){

        loginManagement = new LoginManagement();

        this.setTitle("Login");
        this.setSize(420, 420);
        this.setResizable(false);
        this.setLocation(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\Airline Reservation System\\Images\\Icon.png");
        this.setIconImage(icon.getImage());

        loginLbl = new JLabel("Login");
        loginLbl.setBounds(180, 20, 100, 50);
        loginLbl.setFont(arial);
        this.add(loginLbl);

        usernameLbl = new JLabel("Enter Username: ");
        usernameLbl.setBounds(90, 60, 150, 50);
        usernameLbl.setFont(arialA);
        this.add(usernameLbl);

        usernameTxt = new JTextField();
        usernameTxt.setBounds(90, 100, 200, 25);
        usernameTxt.setFont(arialA);
        this.add(usernameTxt);

        emailLbl = new JLabel("Enter Email: ");
        emailLbl.setBounds(90, 130, 150, 50);
        emailLbl.setFont(arialA);
        this.add(emailLbl);

        emailTxt = new JTextField();
        emailTxt.setBounds(90, 170, 200, 25);
        emailTxt.setFont(arialA);
        this.add(emailTxt);

        passwordLbl = new JLabel("Enter Password: ");
        passwordLbl.setBounds(90, 200, 150, 50);
        passwordLbl.setFont(arialA);
        this.add(passwordLbl);

        passwordTxt = new JPasswordField();
        passwordTxt.setBounds(90, 240, 200, 25);
        passwordTxt.setFont(arialA);
        this.add(passwordTxt);
 
        loginBtn = new JButton("login");
        loginBtn.setBounds(250, 280, 70, 25);
        loginBtn.addActionListener(this);
        this.add(loginBtn);

        this.setVisible(true);
    }
    @Override 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginBtn){
            String username = usernameTxt.getText().trim();
            String email = emailTxt.getText().trim(); 
            String password = new String(passwordTxt.getPassword().trim());

            if ((username.isEmpty()) || (email.isEmpty()) || (password.isEmpty())) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!");
                return;
            }

            loginManagement.addUser(username, email, password);
            //int response = JOptionPane.showConfirmDialog(this, "User registered successfully!", "Success", JOptionPane.OK_CANCEL_OPTION);
            boolean isValid = loginManagement.validateUser(username, email, password);
            if (isValid) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                SeatSelectionGUI seatSelection = new SeatSelectionGUI();
                seatSelection.setVisible(true);
                this.dispose(); // Close the login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials! Please try again.");
            }
            /*if (response == JOptionPane.OK_OPTION) {
                usernameTxt.setText("");
                emailTxt.setText(""); 
                passwordTxt.setText("");

                SeatSelectionGUI seatSelection = new SeatSelectionGUI();
                seatSelection.setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Registration failed. Please try again.");
            }*/
        }   
    }
        // private void saveSeatData(User user) {
        //     LoginManagement loginManagement = new LoginManagement();
        //     loginManagement.writeUserToFile(user, true);
        // }

    }

