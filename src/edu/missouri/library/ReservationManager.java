package edu.missouri.library;



public class ReservationManager {

	// initialize variables
    private ReservationBook book;
    private int ID;

    
    // constructor
    public ReservationManager(int bookCapacity) {
    	// error checking
        if (bookCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        book = new ReservationBook(bookCapacity);
        ID = 1;
    }

    
   // createReservation(Room room, String studentName, TimeSlot slot)
   
    public Reservation createReservation(Room room, String studentName, TimeSlot slot) {
        Reservation reservation = new Reservation(ID, room, studentName, slot, false, false);
        ID++;
        book.add(reservation);
        return reservation;
    }
    
    // cancelReservation(int id)
    
    public void cancelReservation(int id) {
        Reservation reservation = book.findById(id);
     // error checking
        if (reservation == null) {
        	
            throw new IllegalArgumentException("Reservation not found.");
        }
        reservation.cancel();
    }

    // checkInReservation(int id)

    public void checkInReservation(int id) {
    	
        Reservation reservation = book.findById(id);
        // error checking
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation not found.");
        }
        reservation.checkIn();
    }
    
    // print all reservations
    public void printAll() {
        book.printAll();
    }
    
    //print all reservations for specified room
    public void printForRoom(Room room) {
        book.printForRoom(room);
    }
    
         
    
    
}
