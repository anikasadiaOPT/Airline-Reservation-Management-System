package Entities_All;
public class Flight {
    private String flightNumber;
    private String airline;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private int availableSeats;
	
	public Flight(){}
	
    public Flight(String flightNumber, String airline, String origin, String destination, String departureTime, String arrivalTime, int totalSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;  
    }

    public Flight(String flightNumber, String airline, String origin, String destination, String departureTime, String arrivalTime, String totalSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = Integer.parseInt(totalSeats);
        this.availableSeats = Integer.parseInt(totalSeats);  
    }

    
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
   
    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Seat booked successfully. Remaining seats: " + availableSeats);
            return true;
        } else {
            System.out.println("No available seats.");
            return false;
        }
    }
	
    public void displayFlightInfo() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Airline: " + airline);
        System.out.println("From: " + origin + " to " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
    }
    public String getFileWriteFormat(){
        return flightNumber+";"+airline+";"+origin +";"+destination+";"+departureTime+";"+arrivalTime+";"+availableSeats+";"+totalSeats+ "\n";
    }
    public Object[] getTableRow(){
        return new Object[]{flightNumber,airline,origin,destination,departureTime,arrivalTime,totalSeats,availableSeats};
    }
}