package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

public class gui extends JFrame implements ActionListener, ItemListener {

    JPanel panel;
    JLabel title, selectPlaneLabel, seatTypeLabel, timeLabel, ticketCountLabel, fromLabel, toLabel, dateLabel, idLabel, nameLabel, priceLabel;
    JTextField idField, nameField;
    JButton proceedButton, backButton;
    JRadioButton planeOption1, planeOption2, planeOption3, planeOption4;
    JRadioButton seatWindowAisle, seatMiddle;
    ButtonGroup planeGroup, seatGroup;
    JComboBox<String> timeBox, ticketBox, fromBox, toBox, dateBox;

    public gui() {
        super("Airline Ticket Selling System");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel(null);
        panel.setBackground(new Color(230, 240, 250)); // Light theme
        add(panel);

        // Title
        title = new JLabel("Airline Ticket Booking");
        title.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 30));
        title.setForeground(new Color(55, 80, 125));
        title.setBounds(380, 20, 400, 40);
        panel.add(title);

        // Select Plane Section
        selectPlaneLabel = new JLabel("Select Airplane:");
        selectPlaneLabel.setFont(new Font("Arial", Font.BOLD, 22));
        selectPlaneLabel.setBounds(30, 80, 200, 30);
        panel.add(selectPlaneLabel);

        planeOption1 = createRadioButton("A320", 50, 120);
        planeOption2 = createRadioButton("Airbus1neo", 200, 120);
        planeOption3 = createRadioButton("Boeing757", 50, 160);
        planeOption4 = createRadioButton("Biman Bangladesh", 200, 160);

        planeGroup = new ButtonGroup();
        planeGroup.add(planeOption1);
        planeGroup.add(planeOption2);
        planeGroup.add(planeOption3);
        planeGroup.add(planeOption4);

        panel.add(planeOption1);
        panel.add(planeOption2);
        panel.add(planeOption3);
        panel.add(planeOption4);

        // Seat Type Section
        seatTypeLabel = new JLabel("Select Seat Type:");
        seatTypeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        seatTypeLabel.setBounds(30, 210, 200, 30);
        panel.add(seatTypeLabel);

        seatWindowAisle = createRadioButton("Window/Aisle (Tk. 2900)", 50, 250);
        seatMiddle = createRadioButton("Middle (Tk. 2200)", 300, 250);

        seatGroup = new ButtonGroup();
        seatGroup.add(seatWindowAisle);
        seatGroup.add(seatMiddle);

        panel.add(seatWindowAisle);
        panel.add(seatMiddle);

        // Other Details
        timeLabel = createLabel("Time:", 30, 300);
        timeBox = createComboBox(new String[]{" ", "11:00 AM", "01:00 PM", "03:15 PM", "04:00 PM", "04:20 PM", "04:45 PM", "05:00 PM", "05:30 PM", "06:00 PM", "07:15 PM", "08:00 PM", "08:10 PM"}, 200, 300);

        ticketCountLabel = createLabel("Tickets:", 30, 350);
        ticketBox = createComboBox(new String[]{" ", "1", "2", "3", "4", "5", "6"}, 200, 350);

        fromLabel = createLabel("From:", 30, 400);
        fromBox = createComboBox(new String[]{" ", "France", "Germany", "Canada", "USA"}, 200, 400);

        toLabel = createLabel("To:", 30, 450);
        toBox = createComboBox(new String[]{" ", "France", "Germany", "Canada", "USA"}, 200, 450);

        dateLabel = createLabel("Date:", 30, 500);
        dateBox = createComboBox(new String[]{" ","01-01-2025", "12-01-2025", "21-01-2025", "22-05-2025", "23-10-2025"}, 200, 500);

        panel.add(timeLabel);
        panel.add(timeBox);
        panel.add(ticketCountLabel);
        panel.add(ticketBox);
        panel.add(fromLabel);
        panel.add(fromBox);
        panel.add(toLabel);
        panel.add(toBox);
        panel.add(dateLabel);
        panel.add(dateBox);

        // ID & Name Section
        idLabel = createLabel("ID:", 30, 550);
        idField = createTextField(200, 550);
        nameLabel = createLabel("Name:", 30, 600);
        nameField = createTextField(200, 600);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);

        // Buttons
        proceedButton = createButton("Proceed", 750, 550, Color.GREEN);
        proceedButton.addActionListener(this);
        backButton = createButton("Back", 750, 600, Color.RED);
        backButton.addActionListener(this);

        panel.add(proceedButton);
        panel.add(backButton);

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(x, y, 150, 30);
        return label;
    }

    private JComboBox<String> createComboBox(String[] items, int x, int y) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox.setBounds(x, y, 150, 30);
        return comboBox;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBounds(x, y, 150, 30);
        return textField;
    }

    private JButton createButton(String text, int x, int y, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBounds(x, y, 150, 40);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private JRadioButton createRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Arial", Font.PLAIN, 16));
        radioButton.setBounds(x, y, 200, 30);
        radioButton.setFocusPainted(false);
        radioButton.setOpaque(false);
        return radioButton;
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == proceedButton) {
        String selectedPlane = getSelectedButtonText(planeGroup);
        String seatType = getSelectedButtonText(seatGroup);
        String time = (String) timeBox.getSelectedItem();
        String date = (String) dateBox.getSelectedItem();
        String from = (String) fromBox.getSelectedItem();
        String to = (String) toBox.getSelectedItem();
        String tickets = (String) ticketBox.getSelectedItem();
        String passengerId = idField.getText();
        String passengerName = nameField.getText();

        // Validation
        if (selectedPlane == null || seatType == null || time == null || date == null ||
            from == null || to == null || tickets == null || passengerId.isEmpty() || passengerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all details.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate price
        int ticketCount = Integer.parseInt(tickets);
        int basePrice = seatType.contains("Window") ? 2900 : 2200;
        int totalPrice = ticketCount * basePrice;

        // Create ticket content
        String ticketDetails = "Airline Ticket Receipt\n" +
                "---------------------------\n" +
                "Plane: " + selectedPlane + "\n" +
                "Seat Type: " + seatType + "\n" +
                "Time: " + time + "\n" +
                "Date: " + date + "\n" +
                "From: " + from + "\n" +
                "To: " + to + "\n" +
                "Passenger ID: " + passengerId + "\n" +
                "Passenger Name: " + passengerName + "\n" +
                "Tickets: " + ticketCount + "\n" +
                "Total Price: Tk. " + totalPrice + "\n" +
                "---------------------------";

        // Show ticket
        JOptionPane.showMessageDialog(this, ticketDetails, "Ticket", JOptionPane.INFORMATION_MESSAGE);

        // Save ticket to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DataFiles\\ticket.txt", true))) {
            writer.write(ticketDetails);
            writer.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save ticket.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } else if (e.getSource() == backButton) {
        dispose(); // Close the current frame
    }
}

// Helper method to get the selected radio button text
private String getSelectedButtonText(ButtonGroup group) {
    for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
        AbstractButton button = buttons.nextElement();
        if (button.isSelected()) {
            return button.getText();
        }
    }
    return null;
}

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
    public static void main(String[] args) {
        new PaymentGUI();
    }
    
}
