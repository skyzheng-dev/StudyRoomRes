package edu.missouri.library;



public class ReservationBook{
	
	// initialize reservation array and count index
	private Reservation[] reservations;
	private int count;
	
	// constructor
	public ReservationBook(int capacity) {
		// error checking
		if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.reservations = new Reservation[capacity];
        this.count = 0;
	}
	
	//add reservation
	public void add(Reservation r) {
		// error checking
		if (r == null) {
            throw new IllegalArgumentException("Cannot add null reservation");
        }
		
		// error checking
		if (count >= reservations.length) {
            throw new IllegalArgumentException("Reservation book is full");
        }
		
        reservations[count] = r;
        count++;
		
	}
	
	//find reservation by id
	public Reservation findById(int id) {
		for (int i=0; i<count; i++) {
			if (reservations[i].getId() == id) {
				return reservations[i];
			}
		}
		
		return null; 
	}
	
	//print out all reservations
	public void printAll() {
		if (count == 0) {
            System.out.println("No reservations found.");
        }
		
		System.out.println("Reservations: ");
		for (int i=0; i<count; i++) {
			System.out.println(reservations[i]);
		}
	}
	
	//print reservations for specified room #
	public void printForRoom(Room room) {
		if (room == null) {
            System.out.println("Cannot search for null room.");
        }
		
		boolean status = false;
		
		System.out.println("Reservations for " + room + ":");
		for (int i = 0; i<count; i++) {
			if (reservations[i].getRoom() == room) {
				status = true;
				System.out.println(reservations[i]);
			}
		}
		
		// error checking
		if (!status) {
			throw new IllegalArgumentException("There is not reservation for this room.");
		}
		
	}
	
	
	
}
