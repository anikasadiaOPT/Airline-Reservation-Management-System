package Entities_All;

public class SeatSelection {
    private String seatNumber;
    private String seatType;
    private boolean isAvailable;
    private boolean reserved;

    public SeatSelection(String par){}

    public SeatSelection(String seatNumber,String seatType, boolean isAvailable){
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
    }

    public SeatSelection(String seatNumber,String seatType, String isAvailable){
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isAvailable = Boolean.parseBoolean(isAvailable);
    }

    public SeatSelection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSeatNumber(String seatNumber){
        this.seatNumber = seatNumber;
    }
    public String getSeatNumber(){
        return seatNumber;
    }
    public void setSeatType(String seatType){
        this.seatType = seatType;
    }
    public String getSeatType(){
        return seatType;
    }

    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
    public boolean getAvailable(){
        return isAvailable;
    }
    public void setReserved(boolean reserved) {

        this.reserved = reserved;

    }
    public void bookSeat(){
        if(isAvailable){
            isAvailable = true;
            System.out.println("Seat" + seatNumber + " has been successfully booked.");
        }
        else{
            System.out.println("Seat" + seatNumber + " has been successfully booked.");
        }
    }

    public void cancelBooking(){
        if(!isAvailable){
            isAvailable = true;
            System.out.println("Booking for seat " + seatNumber + " has been canceled.");
        }
        else{
            System.out.println("Seat " + seatNumber + " is available");
        }
    }

    public void show(){
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Seat Type: " + seatType);
        if(isAvailable){
            System.out.println("Yes");
        }
        else {System.out.println("No");}
    }
    public String FileWriteFormat(){
        return seatNumber + ";" + seatType + ";" + isAvailable + "\n";
    }
}
