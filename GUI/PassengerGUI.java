package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import Entities_All.*;
import FileManagement.PassengerManagement;
import javax.swing.table.DefaultTableModel;

public class PassengerGUI extends JFrame implements ActionListener{

    Font arial = new Font("Arial", Font.BOLD, 20);
    Font arialA = new Font("Arial", Font.PLAIN, 15);

    JLabel reglbl;
	JLabel plLbl;
    JLabel nameLbl;
    JLabel passengerIdLbl;
    JLabel genderLbl;
    JLabel emailLbl;
	JLabel phoneNumberLbl;
    JLabel passportNumberLbl;
    JLabel flightNumberLbl;
	JLabel nationalityLbl;
	JLabel emergencyContactLbl;
    JLabel preferredMealLbl;
    JLabel dobLbl;
    JLabel searchLbl;

	JTextField txtPl;
    JTextField txtName;
    JTextField txtPassengerId;
    JRadioButton rbMale, rbFemale;
    JTextField txtEmail;
	JTextField txtPhoneNumber;
    JTextField txtPassportNumber;
    JTextField txtFlightNumber;
	JTextField txtNationality;
	JTextField txtEmergencyContact;
    JComboBox<String> mealItem;
    JTextField txtDob;
    JTextField txtSearch;

    JButton submit;
    JButton search;
    JButton update;
    JButton delete;
    ButtonGroup genderGroup;
    DefaultTableModel tmodel;
    JButton backBtn;
    public PassengerGUI(){
        setSize(1400,700);
        setResizable(true);
        setLayout(null);

        reglbl = new JLabel("Passenger Registration");
        reglbl.setBounds(200, 20, 500, 50);
        reglbl.setFont(arial);
        this.add(reglbl);

        plLbl = new JLabel("Enter Sl: ");
        plLbl.setBounds(50, 80, 150, 30);
        plLbl.setFont(arialA);
        this.add(plLbl);

        txtPl = new JTextField(6);
        txtPl.setBounds(200, 80, 250, 25);
        txtPl.setFont(arialA);
        this.add(txtPl);

        nameLbl = new JLabel("Enter Name: ");
        nameLbl.setBounds(50, 110, 150, 30);
        nameLbl.setFont(arialA);
        this.add(nameLbl);

        txtName = new JTextField(6);
        txtName.setBounds(200, 110, 250, 25);
        txtName.setFont(arialA);
        this.add(txtName);

        passengerIdLbl = new JLabel("Enter Passenger ID: ");
        passengerIdLbl.setBounds(50, 210, 150, 30);
        passengerIdLbl.setFont(arialA);
        this.add(passengerIdLbl);

        txtPassengerId = new JTextField(6);
        txtPassengerId.setBounds(200, 210, 250, 25);
        txtPassengerId.setFont(arialA);
        this.add(txtPassengerId);

        genderLbl = new JLabel("Gender: ");
        genderLbl.setBounds(50, 160, 150, 50);
        genderLbl.setFont(arialA);
        this.add(genderLbl);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 170, 80, 25);
        rbMale.setFont(arialA);
        this.add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(290, 170, 80, 25);
        rbFemale.setFont(arialA);
        this.add(rbFemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        emailLbl = new JLabel("Enter Email: ");
        emailLbl.setBounds(50, 260, 150, 30);
        emailLbl.setFont(arialA);
        this.add(emailLbl);

        txtEmail = new JTextField(6);
        txtEmail.setBounds(200, 260, 250, 25);
        txtEmail.setFont(arialA);
        this.add(txtEmail);

        phoneNumberLbl = new JLabel("Enter Phone Number: ");
        phoneNumberLbl.setBounds(50, 300, 150, 30);
        phoneNumberLbl.setFont(arialA);
        this.add(phoneNumberLbl);

        txtPhoneNumber = new JTextField(6);
        txtPhoneNumber.setBounds(200, 300, 250, 25);
        txtPhoneNumber.setFont(arialA);
        this.add(txtPhoneNumber);

        passportNumberLbl = new JLabel("Passport Number: ");
        passportNumberLbl.setBounds(50, 340, 150, 30);
        passportNumberLbl.setFont(arialA);
        this.add(passportNumberLbl);

        txtPassportNumber = new JTextField(6);
        txtPassportNumber.setBounds(200, 340, 250, 25);
        txtPassportNumber.setFont(arialA);
        this.add(txtPassportNumber);

        flightNumberLbl = new JLabel("Enter Flight Number: ");
        flightNumberLbl.setBounds(50, 380, 150, 30);
        flightNumberLbl.setFont(arialA);
        this.add(flightNumberLbl);

        txtFlightNumber = new JTextField(6);
        txtFlightNumber.setBounds(200, 380, 250, 25);
        txtFlightNumber.setFont(arialA);
        this.add(txtFlightNumber);

        nationalityLbl = new JLabel("Nationality: ");
        nationalityLbl.setBounds(50, 420, 150, 30);
        nationalityLbl.setFont(arialA);
        this.add(nationalityLbl);

        txtNationality = new JTextField(6);
        txtNationality.setBounds(200, 420, 250, 25);
        txtNationality.setFont(arialA);
        this.add(txtNationality);

        emergencyContactLbl = new JLabel("Emergency Contact: ");
        emergencyContactLbl.setBounds(50, 460, 150, 30);
        emergencyContactLbl.setFont(arialA);
        this.add(emergencyContactLbl);

        txtEmergencyContact = new JTextField(6);
        txtEmergencyContact.setBounds(200, 460, 250, 25);
        txtEmergencyContact.setFont(arialA);
        this.add(txtEmergencyContact);

        preferredMealLbl = new JLabel("Preferred Meal Item: ");
        preferredMealLbl.setBounds(50, 500, 150, 30);
        preferredMealLbl.setFont(arialA);
        this.add(preferredMealLbl);

        String[] mealOptions = {"", "Vegetarian", "Non-Vegetarian", "Vegan", "Gluten-Free", "Halal", "Kosher"};
        mealItem = new JComboBox<>(mealOptions);
        mealItem.setBounds(200, 500, 250, 25);
        mealItem.setFont(arialA);
        this.add(mealItem);


        dobLbl = new JLabel("Date of Birth: ");
        dobLbl.setBounds(50, 540, 150, 30);
        dobLbl.setFont(arialA);
        this.add(dobLbl);

        txtDob = new JTextField(6);
        txtDob.setBounds(200, 540, 250, 25);
        txtDob.setFont(arialA);
        this.add(txtDob);

        searchLbl = new JLabel("Search by Pl:");
        searchLbl.setBounds(50, 580, 150, 30);
        searchLbl.setFont(arialA);
        this.add(searchLbl);

        txtSearch = new JTextField(6);
        txtSearch.setBounds(200, 580, 250, 25);
        txtSearch.setFont(arialA);
        this.add(txtSearch);
		

        submit = new JButton("Register");
        submit.setBounds(470, 100, 120, 30);
        this.add(submit);
        submit.addActionListener(this);

        update = new JButton("Update");
        update.setBounds(470, 140, 120, 30);
        this.add(update);
        update.addActionListener(this);

        delete = new JButton("Delete");
        delete.setBounds(470, 180, 120, 30);
        this.add(delete);
        delete.addActionListener(this);

        search = new JButton("Search");
        search.setBounds(470, 220, 120, 30);
        this.add(search);
        search.addActionListener(this);
        
        backBtn = new JButton("Back");
        backBtn.setBounds(470, 270, 120, 30);
        this.add(backBtn);
        backBtn.addActionListener(this);

        //tables
        tmodel  = new DefaultTableModel();
        tmodel.addColumn("PlNo");
        tmodel.addColumn("Name");
        tmodel.addColumn("PassengerId");
		tmodel.addColumn("Gender");
        tmodel.addColumn("Email");
        tmodel.addColumn("PhoneNumber");
        tmodel.addColumn("PassportNumber");
		tmodel.addColumn("FlightNumber");
        tmodel.addColumn("Nationality");
		tmodel.addColumn("EmergencyContact");
        tmodel.addColumn("PreferredMeal");
        tmodel.addColumn("Dob");

        JTable psngrTable = new JTable(tmodel);
        JScrollPane tableScroll = new JScrollPane(psngrTable);
        tableScroll.setBounds(610, 10, 720, 200);
        add(tableScroll);
		
        loadData();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            registerClicked();
        }
        else if(e.getSource() == search){
            searchClicked();
        }
        else if(e.getSource() == delete){
            deleteClicked();
        }
        else if(e.getSource() == update){
            updateClicked();
        }
        else if(e.getSource() == backBtn){
            SeatSelectionGUI s = new SeatSelectionGUI();
            this.dispose();
        }
    }

    private void loadData(){    
        PassengerManagement pm = new PassengerManagement();
        Passenger[] passengers = pm.getAllPassengers();
        System.out.println(passengers.length);
        //tmodel.setRowCount(0);
        for (int i = 0; i < passengers.length; i++) {
            Passenger p = passengers[i];
            //tmodel.addRow(p.getTableRow());
            if (p != null) {
                tmodel.addRow(p.getTableRow());
            }
        }
    }
    /*private void showPassengerTable() {
        JFrame tableFrame = new JFrame("Passenger Information");
        tableFrame.setSize(800, 600);
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTable table = new JTable(tmodel);
        JScrollPane scrollPane = new JScrollPane(table);
        tableFrame.add(scrollPane, BorderLayout.CENTER);  
        tableFrame.setVisible(true);
    }*/
    

    public void registerClicked(){
        String pl = txtPl.getText();
        String name = txtName.getText();
        String passengerId = txtPassengerId.getText();
        String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "Not Specified";
        String email = txtEmail.getText();
		String phoneNumber = txtPhoneNumber.getText();
        String passportNumber = txtPassportNumber.getText();
        String flightNumber = txtFlightNumber.getText();
		String nationality = txtNationality.getText();
		String emergencyContact = txtEmergencyContact.getText();
        String preferredMeal = (String) mealItem.getSelectedItem();
        String dob = txtDob.getText();
        
        Object[] row = new Object[]{pl,name,passengerId,gender,email,phoneNumber,passportNumber,flightNumber,nationality,emergencyContact,preferredMeal,dob};
        tmodel.addRow(row);

        Passenger p = new Passenger(Integer.parseInt(pl), name, passengerId, gender, email, phoneNumber, passportNumber, flightNumber, nationality, emergencyContact, preferredMeal, dob);
        PassengerManagement pm = new PassengerManagement();
        pm.writePassenger(p,true);
        JOptionPane.showMessageDialog(null,"Passenger Inserted");
    }
   
    public void searchClicked() {
        String pl = txtSearch.getText();
        PassengerManagement pm = new PassengerManagement();
        //tmodel.setRowCount(0);        
        Passenger p = pm.searchPassenger(Integer.parseInt(pl));
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Passenger not found!");    
        }else{
            txtPl.setText(p.getPl() + " ");
            txtName.setText(p.getName());
            txtPassengerId.setText(p.getPassengerId());

            if (p.getGender().equals("Male")) {
                rbMale.setSelected(true);
            } else {
                rbFemale.setSelected(true);
            }
            txtEmail.setText(p.getEmail());
            txtPhoneNumber.setText(p.getPhoneNumber());
            txtPassportNumber.setText(p.getPassportNumber());
            txtFlightNumber.setText(p.getFlightNumber());
            txtNationality.setText(p.getNationality());
            txtEmergencyContact.setText(p.getEmergencyContact());
            mealItem.setSelectedItem(p.getPreferredMeal());
            txtDob.setText(p.getDob());

                Object[] row = new Object[]{
                p.getPl(),
                p.getName(),
                p.getPassengerId(),
                p.getGender(),
                p.getEmail(),
                p.getPhoneNumber(),
                p.getPassportNumber(),
                p.getFlightNumber(),
                p.getNationality(),
                p.getEmergencyContact(),
                p.getPreferredMeal(),
                p.getDob()};
               // tmodel.addRow(row);
        }
            //tmodel.addRow(row);
            //showPassengerTable();
        }
       

    public void deleteClicked(){
        String pl = txtPl.getText();
        PassengerManagement pm = new PassengerManagement();
        pm.deletePassenger(Integer.parseInt(pl));
        refreshTable();
        JOptionPane.showMessageDialog(null,"Passenger Deleted");
    }
    public void updateClicked(){
        String pl = txtPl.getText();   
        String name = txtName.getText();
        String passengerId = txtPassengerId.getText();
        String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "Not Specified";
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();
		String passportNumber = txtPassportNumber.getText();
        String flightNumber = txtFlightNumber.getText();
		String nationality = txtNationality.getText();
        String emergencyContact = txtEmergencyContact.getText();
        String preferredMeal = (String) mealItem.getSelectedItem();
        String dob = txtDob.getText();
        Passenger p = new Passenger(pl, name, passengerId, gender, email, phoneNumber, passportNumber, flightNumber, nationality, emergencyContact, preferredMeal, dob);
        PassengerManagement pm = new PassengerManagement();
        pm.updatePassenger(p);
        refreshTable();
        JOptionPane.showMessageDialog(null,"Passenger Updated");
        //showPassengerTable();
    }
    // public void refreshTable(){
    //     tmodel.getDataVector().removeAllElements();
    //     PassengerManagement pm = new PassengerManagement();
    //     Passenger[] passengers = pm.getAllPassengers();
    //     for(int i = 0; i < passengers.length; i++){
	// 		Passenger p = passengers[i];
    //         tmodel.addRow(p.getTableRow());
    //     }
    // }
    public void refreshTable() {
        // Clear the current table data
        tmodel.setRowCount(0); // Clear existing rows
    
        // Create a StudentManager to fetch the updated student list
        PassengerManagement pm = new PassengerManagement();
        Passenger[] passengers = pm.getAllPassengers();
    
        // Check if the passengers array is not null
        if (passengers != null) {
            for (Passenger p : passengers) {
                tmodel.addRow(p.getTableRow()); // Add each passenger to the table model
            }
        }
    }   
}


