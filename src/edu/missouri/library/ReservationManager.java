package edu.missouri.library;

/*
 * Required behavior:
• Stores a ReservationBook Make exception store and own all other classes as well.
• Generates reservation IDs (you can use a private counter field)
• Provides high level operations such as:
– createReservation(Room room, String studentName, TimeSlot slot)
– cancelReservation(int id)
– checkInReservation(int id)
Design requirements:
• Avoid reaching through objects to manipulate internals
• Avoid long chains like a.getB().getC().doSomething()
• Delegate behavior to the class that owns the relevant data
 */


public class ReservationManager {


    private ReservationBook book;
    private int nextId;

    
    
    public ReservationManager(int bookCapacity) {
        if (bookCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        book = new ReservationBook(bookCapacity);
        nextId = 1;
    }

    
   // createReservation(Room room, String studentName, TimeSlot slot)
   
    public Reservation createReservation(Room room, String studentName, TimeSlot slot) {
        Reservation reservation =
            new Reservation(nextId, room, studentName, slot, false, false);
        nextId++;
        book.add(reservation);
        return reservation;
    }
    
    // cancelReservation(int id)
    
    public void cancelReservation(int id) {
        Reservation reservation = book.findById(id);
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation not found.");
        }
        reservation.cancel();
    }

    // checkInReservation(int id)

    public void checkInReservation(int id) {
        Reservation reservation = book.findById(id);
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation not found.");
        }
        reservation.checkIn();
    }

    public void printAll() {
        book.printAll();
    }

    public void printForRoom(Room room) {
        book.printForRoom(room);
    }
    
         
    
    
}
