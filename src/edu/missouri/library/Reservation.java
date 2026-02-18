package edu.missouri.library;

//import edu.missouri.library.TimeSlot;
//import edu.missouri.library.Room;


public class Reservation{
	
	
	//initialize variables
	private int id;
	private Room room;
	private String studentName;
	private TimeSlot timeSlot;
	
	private boolean canceled;
	private boolean checkedIn;
	
	// constructor
	public Reservation(int id, Room room, String studentName, TimeSlot timeslot, boolean canceled, boolean checkedIn) {
		// error checking
		if (id <=0) {
			throw new IllegalArgumentException("id must be > 0");
		}
		else if (room == null || timeslot == null) {
			throw new IllegalArgumentException("invalid room or timeslot");
		}
		else if (studentName == null || studentName.isBlank()) {
			throw new IllegalArgumentException("invalid student name");
		}
		else if (canceled && checkedIn) {
			throw new IllegalArgumentException("reservation cannot be checked in and canceled");
		}
		
		this.id = id;
		this.room = room;
		this.studentName = studentName;
		this.timeSlot = timeslot;
		this.canceled = canceled;
		this.checkedIn = checkedIn;
	}
	
	//getter functions
	public int getId() {
		return id;
	}
	   
	public Room getRoom() {
	    return room;
	}
	   
	public String getStudentName() {
	    return studentName;
	}
	   
	public TimeSlot getTimeSlot() {
	    return timeSlot;
	}
	   
	//checking functions
	public boolean isCanceled() {
	    return canceled;
	}
	   
	public boolean isCheckedIn() {
	    return checkedIn;
	}

	
	
	// cancel reservation
	public boolean cancel() {
		// error checking
		if (checkedIn) {
	        throw new IllegalStateException("Cannot cancel a reservation that has been checked in");
	    }
		this.canceled = true;
		return this.canceled;
	}
	
	// check in to a reservation
	public boolean checkIn() {
		// error checking
		if (canceled) {
	        throw new IllegalStateException("Cannot check in a canceled reservation");
	    }
		this.checkedIn = true;
		return this.checkedIn;
	}
	
	
	//synonymous to the canCheckIn function where it checks if the reservation is currently ongoing
	public boolean isActive() {
        return !canceled && !checkedIn;
    }
	
	
	public boolean canCheckIn() {
        return !canceled && !checkedIn;
    }
	
	
	//print the reservation details
	public String toString() {
		String status;
        if (canceled) {
            status = "CANCELED";
        } else if (checkedIn) {
            status = "CHECKED IN";
        } else {
            status = "ACTIVE";
        }
		
		
		return "Reservation details for room " + this.room + ": " + this.id + " " + this.studentName + " " + this.timeSlot + " " + status;
	}
		
		
	
	
}