package FileManagement;
import Entities_All.Passenger;
import java.util.Scanner;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.FileWriter;

public class PassengerManagement{
    String filePath;
    public PassengerManagement(){
        filePath = "DataFiles/passenger.txt";
    }
    public void writePassenger(Passenger p,boolean append){
        File f = new File(filePath);
        try{
            FileWriter writer = new FileWriter(f,append);
            writer.write(p.getFileWriteFormat());
            writer.flush();
            writer.close();
        }catch(Exception ex){
            
        }
    }
    public Passenger[] getAllPassengers(){
        File f = new File(filePath);
        Passenger[] passengers = null;
        try{
            Scanner sc = new Scanner(f);
            Scanner sc2 = new Scanner(f);
            int count=0;
            while(sc2.hasNextLine()){
                String temp = sc2.nextLine();
                count++;
            }
            passengers = new Passenger[count];
            count=0;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(";");
                Passenger p = new Passenger(data[0], data[1], data[2], data[3], 
                    data[4],data[5], data[6],  data[7],  data[8],data[9], data[10], data[11]);
                passengers[count]=p;
                count++;
            }

        }catch(Exception ex){
            
        }
        return passengers;

    }
    public Passenger searchPassenger(int pl){
        Passenger[] passengers = getAllPassengers();
        for(int i=0;i<passengers.length;i++){
            if(passengers[i].getPl() == pl){
                return passengers[i];
            }
        }
        return null;
    }
    public void deletePassenger(int pl){
        Passenger[] passengers = getAllPassengers();
        for(int i=0;i<passengers.length;i++){
            if(passengers[i].getPl() == pl){
                passengers[i] = null;
            }
        }
        for(int i=0;i<passengers.length;i++){
            if(passengers[i] != null){
                if(i==0) writePassenger(passengers[i],false);
                else writePassenger(passengers[i],true);
            }
        }
    }
    public void updatePassenger(Passenger p){
        Passenger[] passengers = getAllPassengers();

        if(passengers == null){
            JOptionPane.showMessageDialog(null,"No passenger found");
            return;
        }
    

        for (Passenger passenger : passengers) {
            if (passenger != null && passenger.getPl() == p.getPl()) {
                passenger.setName(p.getName());
                passenger.setPassengerId(p.getPassengerId());
                passenger.setGender(p.getGender());
                passenger.setEmail(p.getEmail());
                passenger.setPhoneNumber(p.getPhoneNumber());
                passenger.setPassportNumber(p.getPassportNumber());
                passenger.setFlightNumber(p.getFlightNumber());
                passenger.setNationality(p.getNationality());
                passenger.setEmergencyContact(p.getEmergencyContact());
                passenger.setPreferredMeal(p.getPreferredMeal());
                passenger.setDob(p.getDob());
            }
        }
        for(int i=0;i<passengers.length;i++){
            if(i==0) writePassenger(passengers[i],false);
            else writePassenger(passengers[i],true);
        }
    }
}
