package edu.missouri.library;



public class ReservationBook{
	
	private Reservation[] reservations;
	private int count;
	
	
	public ReservationBook(int capacity) {
		if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.reservations = new Reservation[capacity];
        this.count = 0;
	}
	
	public void add(Reservation r) {
		if (r == null) {
            throw new IllegalArgumentException("Cannot add null reservation");
        }
		
		if (count >= reservations.length) {
            throw new IllegalArgumentException("Reservation book is full");
        }
		
        reservations[count] = r;
        count++;
		
	}
			
	public Reservation findById(int id) {
		for (int i=0; i<count; i++) {
			if (reservations[i].getId() == id) {
				return reservations[i];
			}
		}
		
		return null; 
	}
	
	public void printAll() {
		if (count == 0) {
            System.out.println("No reservations found.");
        }
		
		System.out.println("Reservations: ");
		for (int i=0; i<count; i++) {
			System.out.println(reservations[i]);
		}
	}
	
	
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
		
		if (!status) {
			throw new IllegalArgumentException("There is not reservation for this room.");
		}
		
	}
	
	
	
}
