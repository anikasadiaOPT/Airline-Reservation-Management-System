package GUI;
import Entities_All.*;
import FileManagement.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class PaymentGUI extends JFrame implements ActionListener, MouseListener, ItemListener{
    
        JPanel panel;
        JLabel a1, a2, a3, x1, x2, fromLabel, toLabel, dateLabel, idLabel, nameLabel;
        JTextField idField, nameField;
        JButton ticket_pay, backBtn;
        JRadioButton rd1, rd2, aa, bb, cc, dd;
        ButtonGroup bt1, zz;
        JComboBox<String> airlineTime, ticket_no, fromBox, toBox, dateBox;

        String selectedPlane, selectedQuality, selectedTime, selectedFrom, selectedTo, selectedDate, selectedTicketNo;
    
        Font f0 = new Font("Arial", Font.BOLD + Font.ITALIC, 26);
        Font f1 = new Font("Arial", Font.BOLD + Font.ITALIC, 26);
        Font f2 = new Font("Arial", Font.BOLD, 22);
        Font f3 = new Font("Arial", Font.ITALIC, 18);
        Font f4 = new Font("Times New Roman", Font.BOLD, 25);
        Font f5 = new Font("Times New Roman", Font.BOLD, 18);
        Color color1 = new Color(0xffffff);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        public PaymentGUI() {
            super("Airline ticket selling method");
            this.setSize(1100, 700);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(true);
            panel = new JPanel();
            panel.setLayout(null);
    
            a1 = new JLabel("Select Airplane");
            a1.setBounds(500, 60, 200, 25);
            a1.setFont(f4);
            a1.setForeground(Color.BLACK);
            panel.add(a1);
    
            aa = new JRadioButton("A320");
            aa.setBounds(450, 120, 180, 40);
            aa.setCursor(cursor);
            aa.setContentAreaFilled(false);
            aa.setForeground(Color.BLACK);
            aa.addActionListener(this);
            panel.add(aa);
    
            bb = new JRadioButton("Airbus1neo");
            bb.setBounds(600, 120, 180, 40);
            bb.setCursor(cursor);
            bb.setContentAreaFilled(false);
            bb.setForeground(Color.BLACK);
            bb.addActionListener(this);
            panel.add(bb);
    
            cc = new JRadioButton("Boeing757");
            cc.setBounds(450, 200, 180, 60);
            cc.setCursor(cursor);
            cc.setContentAreaFilled(false);
            cc.setForeground(Color.BLACK);
            cc.addActionListener(this);
            panel.add(cc);
    
            dd = new JRadioButton("Biman Bangladesh");
            dd.setBounds(600, 200, 180, 60);
            dd.setCursor(cursor);
            dd.setContentAreaFilled(false);
            dd.setForeground(Color.BLACK);
            dd.addActionListener(this);
            panel.add(dd);
    
            zz = new ButtonGroup();
            zz.add(aa);
            zz.add(bb);
            zz.add(cc);
            zz.add(dd);
    
            x1 = new JLabel("(Window/Aisle Tk.2900 /");
            x1.setBounds(660, 320, 300, 25);
            x1.setFont(f5);
            x1.setForeground(Color.BLACK);
            panel.add(x1);
    
            x2 = new JLabel("Middle Tk.2200)");
            x2.setBounds(870, 320, 300, 25);
            x2.setFont(f5);
            x2.setForeground(Color.BLACK);
            panel.add(x2);
    
            rd1 = new JRadioButton("Window/Aisle");
            rd1.setBounds(310, 320, 200, 25);
            rd1.setFont(f4);
            rd1.setCursor(cursor);
            rd1.setContentAreaFilled(false);
            rd1.setForeground(Color.BLACK);
            rd1.addActionListener(this);
            panel.add(rd1);
    
            rd2 = new JRadioButton("Middle");
            rd2.setBounds(490, 320, 115, 25);
            rd2.setFont(f4);
            rd2.setCursor(cursor);
            rd2.setContentAreaFilled(false);
            rd2.setBorderPainted(false);
            rd2.setForeground(Color.BLACK);
            rd2.addActionListener(this);
            panel.add(rd2);
    
            bt1 = new ButtonGroup();
            bt1.add(rd1);
            bt1.add(rd2);
    
            a2 = new JLabel("Select Time");
            a2.setBounds(30, 400, 120, 25);
            a2.setFont(f4);
            a2.setForeground(Color.BLACK);
            panel.add(a2);
    
            String[] items = {" ", "11:00 AM", "01:00 PM", "03:15 PM", "04:00 PM", "04:20 PM", "04:45 PM", "05:00 PM", "05:30 PM", "06:00 PM", "07:15 PM", "08:00 PM", "08:10 PM"};
            airlineTime = new JComboBox<>(items);
            airlineTime.setBounds(30, 440, 170, 30);
            airlineTime.setFont(f5);
            airlineTime.addItemListener(this);
            panel.add(airlineTime);
    
            a3 = new JLabel("Number of Tickets");
            a3.setBounds(30, 510, 180, 25);
            a3.setFont(f4);
            a3.setForeground(Color.BLACK);
            panel.add(a3);
    
            String[] tic = {" ", "1", "2", "3", "4", "5", "6"};
            ticket_no = new JComboBox<>(tic);
            ticket_no.setBounds(30, 550, 170, 30);
            ticket_no.setFont(f4);
            ticket_no.addItemListener(this);
            panel.add(ticket_no);
    
            fromLabel = new JLabel("From");
            fromLabel.setBounds(310, 400, 120, 25);
            fromLabel.setFont(f4);
            fromLabel.setForeground(Color.BLACK);
            panel.add(fromLabel);
    
            String[] fromItems = {" ","France", "Germany", "Canada", "Ireland", "United States"};
            fromBox = new JComboBox<>(fromItems);
            fromBox.setBounds(310, 440, 170, 30);
            fromBox.setFont(f5);
            fromBox.addItemListener(this);
            panel.add(fromBox);
    
            toLabel = new JLabel("To");
            toLabel.setBounds(590, 400, 120, 25);
            toLabel.setFont(f4);
            toLabel.setForeground(Color.BLACK);
            panel.add(toLabel);
    
            String[] toItems = {" ","France", "Germany", "Canada", "Ireland", "United States"};
            toBox = new JComboBox<>(toItems);
            toBox.setBounds(590, 440, 170, 30);
            toBox.setFont(f5);
            toBox.addItemListener(this);
            panel.add(toBox);
    
            dateLabel = new JLabel("Date");
            dateLabel.setBounds(855, 400, 120, 25);
            dateLabel.setFont(f4);
            dateLabel.setForeground(Color.BLACK);
            panel.add(dateLabel);
    
            String[] dateItems = {" ","01-01-2025", "12-01-2025", "21-01-2025", "22-05-2025", "23-10-2025"};
            dateBox = new JComboBox<>(dateItems);
            dateBox.setBounds(855, 440, 170, 30);
            dateBox.setFont(f5);
            dateBox.addItemListener(this);
            panel.add(dateBox);
    
            idLabel = new JLabel("Id");
            idLabel.setBounds(30, 70, 120, 25);
            idLabel.setFont(f4);
            idLabel.setForeground(Color.BLACK);
            panel.add(idLabel);
    
            idField = new JTextField();
            idField.setBounds(30, 110, 200, 30);
            idField.setFont(f4);
            panel.add(idField);
    
            nameLabel = new JLabel("Name");
            nameLabel.setBounds(30, 200, 120, 25);
            nameLabel.setFont(f4);
            nameLabel.setForeground(Color.BLACK);
            panel.add(nameLabel);
    
            nameField = new JTextField();
            nameField.setBounds(30, 240, 200, 30);
            nameField.setFont(f4);
            panel.add(nameField);
    
            ticket_pay = new JButton("Proceed to Sell");
            ticket_pay.setBounds(440, 550, 200, 40);
            ticket_pay.setFont(f5);
            ticket_pay.addActionListener(this);
            panel.add(ticket_pay);
    
            backBtn = new JButton("Back");
            backBtn.setBounds(810, 80, 120, 30);
            backBtn.addActionListener(this);
            panel.add(backBtn);
            // backBtn = new JButton("Back");
            // backBtn.setBounds(900, 550, 100, 30);
            // backBtn.setFont(f2);
            // backBtn.setCursor(cursor);
            // backBtn.setBackground(color1);
            // backBtn.setForeground(Color.BLACK);
            // backBtn.setBorder(BorderFactory.createEmptyBorder());
            // backBtn.addActionListener(this);
            // panel.add(backBtn);
    
            this.add(panel);
            this.setVisible(true);
        }
    
        @Override
        public void mouseClicked(MouseEvent me) {
        }
    
        @Override
        public void mousePressed(MouseEvent me) {
        }
    
        @Override
        public void mouseReleased(MouseEvent me) {
        }
    
        @Override
        public void mouseEntered(MouseEvent me) {
        }
    
        @Override
        public void mouseExited(MouseEvent me) {
        }
    
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ticket_pay) {
                int i = 0, ans = 0;
                boolean x = false, y = false, z = false, w = false, d = false;
    
                if (selectedPlane != null) {
                    x = true;
                }
                if (selectedQuality != null) {
                    if (selectedQuality.equals("Window/Aisle")) {
                        i = 2900;
                    } else if (!selectedQuality.equals("Middle")) {
                    } else {
                        i = 2200;
                    }
                }
                if (selectedTime != null) {
                    y = true;
                }
                if (selectedTicketNo != null) {
                    z = true;
                }
                if (selectedFrom != null && selectedTo != null) {
                    w = true;
                }
                if (selectedDate != null) {
                    d = true;
                }
    
                if (x && y && z && w && d && (i == 2900 || i == 2200)) {
                    int k = Integer.parseInt(selectedTicketNo);
                    ans = i * k;
                }
    
                if (ans != 0) {
                    String id = idField.getText();
                    String name = nameField.getText();
                    if (id.isEmpty() || name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter both Id and Name", "!!!!!!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("DataFiles/payment.txt", true))) {
                            bw.write(id + "," + name + "," + selectedPlane + "," + selectedQuality + "," + selectedTime + "," + selectedFrom + "," + selectedTo + "," + selectedDate + "," + selectedTicketNo + "," + ans + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        int response = JOptionPane.showConfirmDialog(null, "Total ticket price is " + ans + " Tk", "Amount", JOptionPane.OK_CANCEL_OPTION);
                        if (response == JOptionPane.OK_OPTION) {
                            JOptionPane.showMessageDialog(null, "Your Sell is done", "Selling confirmation", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select all boxes", "!!!!!!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (ae.getSource() == backBtn) {
                new SeatSelectionGUI(); 
                this.dispose();
            } else if (ae.getSource() == aa || ae.getSource() == bb || ae.getSource() == cc || ae.getSource() == dd) {
                if (aa.isSelected()) {
                    selectedPlane = "A320";
                } else if (bb.isSelected()) {
                    selectedPlane = "Airbus1neo";
                } else if (cc.isSelected()) {
                    selectedPlane = "Boeing757";
                } else if (dd.isSelected()) {
                    selectedPlane = "Biman Bangladesh";
                }
                saveCurrentSelection();
            } else if (ae.getSource() == rd1 || ae.getSource() == rd2) {
                if (rd1.isSelected()) {
                    selectedQuality = "Window/Aisle";
                } else if (rd2.isSelected()) {
                    selectedQuality = "Middle";
                }
                saveCurrentSelection();
            }
        }
    
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource() == airlineTime) {
                selectedTime = (String) airlineTime.getSelectedItem();
            } else if (ie.getSource() == ticket_no) {
                selectedTicketNo = (String) ticket_no.getSelectedItem();
            } else if (ie.getSource() == fromBox) {
                selectedFrom = (String) fromBox.getSelectedItem();
            } else if (ie.getSource() == toBox) {
                selectedTo = (String) toBox.getSelectedItem();
            } else if (ie.getSource() == dateBox) {
                selectedDate = (String) dateBox.getSelectedItem();
            }
            saveCurrentSelection();
        }
    
        private void saveCurrentSelection() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("DataFiles/payment.txt.txt"))) {
                bw.write((selectedPlane != null ? selectedPlane : "") + ",");
                bw.write((selectedTime != null ? selectedTime : "") + ",");
                bw.write((selectedQuality != null ? selectedQuality : "") + ",");
                bw.write((selectedFrom != null ? selectedFrom : "") + ",");
                bw.write((selectedTo != null ? selectedTo : "") + ",");
                bw.write((selectedDate != null ? selectedDate : "") + ",");
                bw.write((selectedTicketNo != null ? selectedTicketNo : "") + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        public static void main(String[] args) {
            new PaymentGUI();
        }
}

