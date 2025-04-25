package Entities_All;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Booking{
    private int bookingId;
    private String passengerName;
    private String flightNumber;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private String departureAirport;
    private String arrivalAirport;
    private String seatNumber;
    private String classType;
    private double price;
    private String bookingStatus;
    private String paymentStatus;

    // Default constructor
    public Booking() {}
    public Booking(int bookingId, String passengerName, String flightNumber, LocalDate departureDate, LocalTime departureTime,
                   LocalDate arrivalDate, LocalTime arrivalTime, String departureAirport, String arrivalAirport,
                   String seatNumber, String classType, double price, String bookingStatus, String paymentStatus) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.price = price;
        this.bookingStatus = bookingStatus;
        this.paymentStatus = paymentStatus;
    }
    public Booking(String bookingId, String passengerName, String flightNumber, String departureDate, String departureTime,
    String arrivalDate, String arrivalTime, String departureAirport, String arrivalAirport,
    String seatNumber, String classType, String price, String bookingStatus, String paymentStatus) throws Exception {
try {
this.bookingId = Integer.parseInt(bookingId);
this.passengerName = passengerName;
this.flightNumber = flightNumber;

// Parsing date and time
this.departureDate = LocalDate.parse(departureDate);
this.arrivalDate = LocalDate.parse(arrivalDate);

DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
this.departureTime = LocalTime.parse(departureTime, timeFormat);
this.arrivalTime = LocalTime.parse(arrivalTime, timeFormat);

this.departureAirport = departureAirport;
this.arrivalAirport = arrivalAirport;
this.seatNumber = seatNumber;
this.classType = classType;
this.price = Double.parseDouble(price);
this.bookingStatus = bookingStatus;
this.paymentStatus = paymentStatus;
} catch (NumberFormatException | DateTimeParseException e) {
throw new Exception("Invalid input data: " + e.getMessage());
}
}

// Getters
public int getBookingId() {
return bookingId;
}

public String getPassengerName() {
return passengerName;
}

public String getFlightNumber() {
return flightNumber;
}

public LocalDate getDepartureDate() {
return departureDate;
}

public LocalTime getDepartureTime() {
return departureTime;
}

public LocalDate getArrivalDate() {
return arrivalDate;
}

public LocalTime getArrivalTime() {
return arrivalTime;
}

public String getDepartureAirport() {
return departureAirport;
}

public String getArrivalAirport() {
return arrivalAirport;
}

public String getSeatNumber() {
return seatNumber;
}

public String getClassType() {
return classType;
}

public double getPrice() {
return price;
}

public String getBookingStatus() {
return bookingStatus;
}

public String getPaymentStatus() {
return paymentStatus;
}

// Setters
public void setBookingId(int bookingId) {
this.bookingId = bookingId;
}

public void setPassengerName(String passengerName) {
this.passengerName = passengerName;
}

public void setFlightNumber(String flightNumber) {
this.flightNumber = flightNumber;
}

public void setDepartureDate(LocalDate departureDate) {
this.departureDate = departureDate;
}

public void setDepartureTime(LocalTime departureTime) {
this.departureTime = departureTime;
}

public void setArrivalDate(LocalDate arrivalDate) {
this.arrivalDate = arrivalDate;
}

public void setArrivalTime(LocalTime arrivalTime) {
this.arrivalTime = arrivalTime;
}

public void setDepartureAirport(String departureAirport) {
this.departureAirport = departureAirport;
}

public void setArrivalAirport(String arrivalAirport) {
this.arrivalAirport = arrivalAirport;
}

public void setSeatNumber(String seatNumber) {
this.seatNumber = seatNumber;
}

public void setClassType(String classType) {
this.classType = classType;
}

public void setPrice(double price) {
this.price = price;
}

public void setBookingStatus(String bookingStatus) {
this.bookingStatus = bookingStatus;
}

public void setPaymentStatus(String paymentStatus) {
this.paymentStatus = paymentStatus;
}

// Display booking details
public void getBookingDetails() {
System.out.println("Booking Id: " + bookingId);
System.out.println("Passenger Name: " + passengerName);
System.out.println("Flight Number: " + flightNumber);
System.out.println("Departure Date: " + departureDate);
System.out.println("Departure Time: " + departureTime);
System.out.println("Arrival Date: " + arrivalDate);
System.out.println("Arrival Time: " + arrivalTime);
System.out.println("Departure Airport: " + departureAirport);
System.out.println("Arrival Airport: " + arrivalAirport);
System.out.println("Seat Number: " + seatNumber);
System.out.println("Class Type: " + classType);
System.out.printf("Price: %.2f%n", price);
System.out.println("Booking Status: " + bookingStatus);
System.out.println("Payment Status: " + paymentStatus);
}


public String getFileWriteFormat() {
return bookingId + ";" + passengerName + ";" + flightNumber + ";" + departureDate + ";" + departureTime + ";" +
arrivalDate + ";" + arrivalTime + ";" + departureAirport + ";" + arrivalAirport + ";" +
seatNumber + ";" + classType + ";" + price + ";" + bookingStatus + ";" + paymentStatus + "\n";
}


public Object[] getTableRow() {
return new Object[] {bookingId, passengerName, flightNumber, departureDate, departureTime, arrivalDate, arrivalTime, 
              departureAirport, arrivalAirport, seatNumber, classType, price, bookingStatus, paymentStatus};
}
}


