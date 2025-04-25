package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon; // Add this import statement
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// import GUI.Register;
// import GUI.Login;
// import FileManagement.LoginManagement;

public class HomeFrame extends JFrame implements ActionListener{
    Font arialA = new Font("Arial", Font.BOLD, 40);
    Font arialB = new Font("Arial", Font.BOLD, 50);

    JPanel panel;
    ImageIcon image, icon;
    JButton loginBtn, regBtn;
    JLabel welcomeLabel, skyServeLabel, toLabel;
    JLabel background;

    public HomeFrame(){
        this.setTitle("Sky Serve");
        this.setSize(900, 500);
        this.setLocation(300, 100);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        image = new ImageIcon("Images\\Airline.png"); // Replace with your PNG image path
        background = new JLabel(image); // JLabel to hold the background image
        background.setBounds(0, 0, this.getWidth(), this.getHeight());

        background.setLayout(null); // Allow adding components on it
        this.setContentPane(background); 

        welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(100, 50, 250, 100);
        welcomeLabel.setFont(arialB);
        welcomeLabel.setForeground(Color.decode("#000111"));
        this.add(welcomeLabel);


        toLabel = new JLabel();
        toLabel.setText("To");
        toLabel.setForeground(Color.WHITE);
        toLabel.setBounds(170, 120, 200, 50);
        toLabel.setFont(arialA);
        toLabel.setForeground(Color.decode("#000111")); // Correct usage of Color.decode
        this.add(toLabel);

        skyServeLabel = new JLabel();
        skyServeLabel.setText("SKY SERVE");
        skyServeLabel.setForeground(Color.WHITE);
        skyServeLabel.setBounds(100, 170, 300, 50);
        skyServeLabel.setFont(arialA);
        skyServeLabel.setForeground(Color.decode("#000111"));
        this.add(skyServeLabel);

        regBtn = new JButton("Register");
        regBtn.setBounds(600, 10, 100, 25);
        regBtn.addActionListener(this);
        this.add(regBtn);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(740, 10, 100, 25);
        loginBtn.addActionListener(this);
        this.add(loginBtn);


        ImageIcon icon = new ImageIcon("Images\\Icon.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.decode("#00254d"));
        this.setLayout(null);
        
        //this.add(background);
        this.setVisible(true);

    }
     @Override
     public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginBtn){
            System.out.println("Login button clicked");
            try{
                Login login = new Login(); 
                this.dispose();
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == regBtn){
            System.out.println("Register button clicked");
            try{
                Register reg = new Register();
            this.dispose();
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
