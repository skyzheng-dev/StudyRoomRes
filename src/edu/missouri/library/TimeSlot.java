package edu.missouri.library;



public class TimeSlot {

                                                         // immutable
    private final int hour;                              // 0-23

    public TimeSlot(int hour) {                        //Constructor validates hour (fail fast)
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }

        this.hour = hour;
    }


    public int getHour() {
        return hour;
    }


    //  toString() such as 13:00-14:00combine it with ternary operator to add AM and PM for the time
    public String toString() {
              
        return this.hour+":00" + "--" + (this.hour+1)+":00";

    }

}