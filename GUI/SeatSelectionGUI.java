package GUI;
import Entities_All.SeatSelection;
import FileManagement.SeatManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

  public class SeatSelectionGUI extends JFrame {    
     JPanel panel;
     JPanel seatPanel;
     JLabel txt;
     JButton[][] seatButton;
     SeatSelection[][] seats;
     ImageIcon icon;
     JScrollPane jsbSeat;
     JButton userPrfileBtn;

     Font font = new Font("Arial", Font.BOLD, 20);
     final int row = 30;
     final int col = 6;
     private boolean[][] seatAvailability = new boolean[row][col];

     public SeatSelectionGUI(){
         ImageIcon icon = new ImageIcon("D:\\Airline Reservation System\\Images\\Icon.png");
         this.setIconImage(icon.getImage());

         this.setTitle("Sky Serve");
         this.setSize(1300, 650);
         this.setLocation(50, 50);
         this.setResizable(true);
         this.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 5));
        
         panel = new JPanel();
         txt = new JLabel("Flight Seat Selection");
         txt.setFont(font);
         panel.add(txt); 
         panel.setPreferredSize(new Dimension(500, 900));
         panel.setBackground(Color.decode("#cccccc"));
         panel.setLayout(new FlowLayout());

         seatPanel = new JPanel(new GridLayout(row, col, 10, 10));
         seatPanel.setBackground(Color.decode("#cccccc"));
         seatButton = new JButton[row][col];
         seats = new SeatSelection[row][col];

         for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                String seatLabel = String.format("%d%s", i + 1, (char) ('A' + j));
                seatButton[i][j] = new JButton(seatLabel);
                seatButton[i][j].setBackground(Color.GREEN);
                seatButton[i][j].setForeground(Color.BLACK);
                seatButton[i][j].setFocusable(false);
                seatButton[i][j].addActionListener(new SeatButtonListener(i, j));
                seats[i][j] = new SeatSelection(seatLabel, "Economy", true);
                seatPanel.add(seatButton[i][j]);
            }
         }
         jsbSeat = new JScrollPane(seatPanel);
         jsbSeat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         jsbSeat.setPreferredSize(new Dimension(470, 550)); 

         userPrfileBtn = new JButton("Passenger Registration"); 
         userPrfileBtn.setBounds(600, 300, 120, 30);
         panel.add(userPrfileBtn);
         userPrfileBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new PassengerGUI();
             }
         }); 
         //userPrfileBtn.setPreferredSize(new Dimension(700, 25));     
         //userPrfileBtn.setBounds(740, 10, 100, 25);
         JButton exitButton = new JButton("Exit");
         exitButton.setBounds(700, 500, 120, 30);
         exitButton.addActionListener(e -> System.exit(0));
         panel.add(jsbSeat);
         this.add(panel);
         this.add(userPrfileBtn);
         this.add(exitButton);
         this.getContentPane().setBackground(Color.decode("#cfecf7"));
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
     }

     
     private class SeatButtonListener implements ActionListener {
        private final int row;
        private final int column;

        public SeatButtonListener(int row, int column) {
            this.row = row;
            this.column = column;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = seatButton[row][column];
            SeatSelection currentSeats = seats[row][column];

            if (!currentSeats.getAvailable()) {
                JOptionPane.showMessageDialog(SeatSelectionGUI.this, "This seat is already booked!");
                return;
            }
            
            
         
            int response = JOptionPane.showConfirmDialog(SeatSelectionGUI.this, "Do you want to book this seat?", "Confirm Booking", JOptionPane.YES_NO_OPTION);
            
            if (response == JOptionPane.YES_OPTION) {
                clickedButton.setBackground(Color.RED);
                new gui();  
                clickedButton.setEnabled(false);
                currentSeats.setAvailable(false);
                saveSeatData(currentSeats);
                //showPaymentForm();
            } 
            else {
              
                //clickedButton.setBackground(Color.GREEN); 
            }
        }
    }
    private void saveSeatData(SeatSelection seat) {
        SeatManagement seatManagement = new SeatManagement();
        seatManagement.writeSeatToFile(seat, true);
    }  
    
}
