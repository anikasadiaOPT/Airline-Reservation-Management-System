package FileManagement;
import Entities_All.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class PaymentManagement{
    String filePath;
    public PaymentManagement(){
        filePath = "DataFiles/payment.txt";
    }
    public void writePayment(Payment p,boolean append){
        File f = new File(filePath);
        try{
            FileWriter writer = new FileWriter(f,append);
            writer.write(p.getFileWriteFormat());
            writer.flush();
            writer.close();
        }catch(Exception ex){
            
        }

    }
    public Payment[] getAllPayments(){
        File f = new File(filePath);
        Payment[] payments = null;
        try{
            Scanner sc = new Scanner(f);

            Scanner sc2 = new Scanner(f);
            int count=0;
            while(sc2.hasNextLine()){
                String temp = sc2.nextLine();
                count++;
            }
            payments = new Payment[count];
            count=0;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(";");
                int amount = Integer.parseInt(data[2]);
                SeatSelection seatSelection = new SeatSelection(data[3]); // Assuming SeatSelection has a constructor that accepts a String
                User user = new User(data[4], data[5], data[6]); // Assuming User has a constructor that accepts three Strings
                Payment p = new Payment(data[0], data[1], amount, seatSelection, user);
                payments[count]=p;
                count++;
            }

        }catch(Exception ex){
            
        }
        return payments;

    }
    public Payment searchPayment(String id){
        Payment[] payments = getAllPayments();
        for(int i=0;i<payments.length;i++){
            if(payments[i].getPaymentId().equals(id)){
                return payments[i];
            }
        }
        return null;
    }
    public void deletePayment(String id){
        Payment[] payments = getAllPayments();
        for(int i=0;i<payments.length;i++){
            if(payments[i].getPaymentId().equals(id)){
                payments[i] = null;
            }
        }
        for(int i=0;i<payments.length;i++){
            if(payments[i] != null){
                if(i==0) writePayment(payments[i],false);
                else writePayment(payments[i],true);
            }
            
        }
    }
    public void updatePayment(Payment p){
        Payment[] payments = getAllPayments();
        for(int i=0;i<payments.length;i++){
            if(payments[i].getPaymentId().equals(p.getPaymentId())){
                payments[i].setDate(p.getDate());
                payments[i].setAmount(p.getAmount());
            }
        }
        for(int i=0;i<payments.length;i++){
            if(i==0) writePayment(payments[i],false);
            else writePayment(payments[i],true);
        }
    } 
}
