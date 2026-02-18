package edu.missouri.library;



/*

Represents a one hour slot.

Required data:

• int hour where 0 to 23

Required behavior:

• Constructor validates hour (fail fast)

• toString() such as 13:00-14:00combine it with ternary operator to add AM and PM for the time

Design note: This is a great candidate for an immutable class.



 */





public class TimeSlot {



    private final int hour; // 0-23



    public TimeSlot(int hour) {                        //Constructor validates hour (fail fast)

        if (hour < 0 || hour > 23) {

            throw new IllegalArgumentException("Hour must be between 0 and 23");

        }

        this.hour = hour;

    }



    public int getHour() {

        return hour;

    }

   
    

    // STILL Needs this:  toString() such as 13:00-14:00combine it with ternary operator to add AM and PM for the time
    public String toString() {
        
    	
        
        return this.hour+":00" + "--" + (this.hour+1)+":00";

    }

}