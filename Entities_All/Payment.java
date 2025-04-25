package Entities_All;

public class Payment{
	private String paymentId,date;
	private int amount;
	SeatSelection ticketId;
	User userId;
	
	public Payment(){}
	
	public Payment(String paymentId,String date,int amount ,SeatSelection ticketId,User userId ){
		this.paymentId=paymentId;
		this.date=date;
		this.amount=amount;
		this.ticketId=ticketId;
		this.userId=userId;
	}
    public Payment(String paymentId,String date,String  amount ,SeatSelection ticketId,User userId ){
		this.paymentId=paymentId;
		this.date=date;
		this.amount = Integer.parseInt(amount);
		this.ticketId=ticketId;
		this.userId=userId;
	}
	public void setPaymentId(String paymentId){
		this.paymentId=paymentId;
	}
	public void setDate(String date){
		this.date=date;
	}	
	public void setAmount(int amount){
		this.amount=amount;
	}
	public void setUserId(User userId){
		this.userId = userId;
	}
	public void setSeatSelection(SeatSelection ticketId){
		this.ticketId = ticketId;
	}

	public String getPaymentId(){
		return paymentId;
	}
	public String getDate(){
		return date;
	}
	public int getAmount(){
		return amount;
	}
	public User getUserId(){
		return userId;
	}
	public SeatSelection getSeatSelection(){
		return ticketId;
	}

	public String getFileWriteFormat(){
        return paymentId+";"+date+";"+amount+";"+ticketId+";"+userId+"\n";
    }
    public Object[] getTableRow(){
        return new Object[] {paymentId, date, amount, ticketId, userId};
    }
	/*public User fromUser(String str){
		String data[] = str.split(",");
		User u= new User(data[0],data[1], data[2], data[3], data[4]);
		return u;
	}*/
    public void getPassengerDetails(){
       
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Date: " + date);
        System.out.println("Amount: " + amount);
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("User ID: " + userId);
    }
}