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
	
	
	public String printForRoom(Room room) {
		
		return null;
	}
	
	
	
}
