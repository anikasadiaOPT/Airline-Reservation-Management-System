package Entities_All;

public class MealPreference{

    private String passengerName;

	private String seatNumber;

    private String mealType;

    private String mealName;

 
    public MealPreference(){}

    public MealPreference(String passengerName, String seatNumber, String mealType, String mealName){

        this.passengerName = passengerName;

		this.seatNumber = seatNumber;

        this.mealType = mealType;

        this.mealName = mealName;

    }


    public void setPassengerName(String passengerName){

		this.passengerName = passengerName;

	    }

	public String getPassengerName(){

		return passengerName;

	}

	public void setSeatNumber(String seatNumber){

		this.seatNumber = seatNumber;

	}

	public String getSeatNumber(){

		return seatNumber;

	}

    public void setMealType(String mealType){

		this.mealType = mealType;

		}

	public String getMealType(){

		return mealType;

	} 

    public void setMealName(String mealName){

		this.mealName = mealName;

		}

    public String getMealName(){

		return mealName;

	}

    public void show(){

        System.out.println("PassengerName: " + passengerName);

		System.out.println("SeatNumber: " + seatNumber);

        System.out.println("MealType: " + mealType);

        System.out.println("MealName: " + mealName);

    }

    public String getFileWriteFormat(){

        return passengerName+";"+seatNumber+";"+mealType+";"+mealName+"\n";

    }

    public Object[] getTableRow(){

        return new Object[] {passengerName,seatNumber,mealType,mealName,};

    }

}