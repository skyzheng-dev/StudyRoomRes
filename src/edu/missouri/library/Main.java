package edu.missouri.library;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Simple Test ===\n");

        // Create a room
        Room room101 = new Room("Room 101", 4);
        System.out.println("Created: " + room101);

        // Create a time slot
        TimeSlot morning = new TimeSlot(11);
        System.out.println("Created: " + morning);

        // Create a reservation
        Reservation res1 = new Reservation(1, room101, "Alice Smith", morning, false, false);
        System.out.println("Created: " + res1);

        // Test check-in
        System.out.println("\nChecking in...");
        res1.checkIn();
        System.out.println("After check-in: " + res1);

        // Create another reservation and cancel it
        TimeSlot afternoon = new TimeSlot(14);
        Reservation res2 = new Reservation(2, room101, "Bob Jones", afternoon, false, false);
        System.out.println("\nCreated: " + res2);
        res2.cancel();
        System.out.println("After cancel: " + res2);

        System.out.println("\n=== Test Complete ===");

        // Test ReservationBook
        System.out.println("\n=== Testing ReservationBook classes ===\n");
        
        ReservationBook book = new ReservationBook(5);
        book.add(res1);
        book.add(res2);
        
        Room room102 = new Room("Room 102", 6);
        Reservation res3 = new Reservation(3, room102, "Charlie", new TimeSlot(18), false, false);
        book.add(res3);
        
        book.printAll();
        
        System.out.println("\nFinding ID #2:");
        System.out.println(book.findById(2));
        
        System.out.println();
        book.printForRoom(room101);
        
        
        // Create ReservationManager with capacity 10
        ReservationManager manager = new ReservationManager(10);

       

        // Create TimeSlots
        TimeSlot slot9 = new TimeSlot(9);
        TimeSlot slot10 = new TimeSlot(10);
//        TimeSlot slot13 = new TimeSlot(13);
//        TimeSlot slot14 = new TimeSlot(14);

        // Create Reservations (at least 5)
        Reservation r1 = manager.createReservation(room101, "Alice", slot9);
        Reservation r2 = manager.createReservation(room101, "Bob", slot10);
       
//        Reservation r5 = manager.createReservation(room101, "Emma", slot14);

        // Cancel at least one
        manager.cancelReservation(r2.getId());

        // Check in at least one
        manager.checkInReservation(r1.getId());

        // Print all reservations
        System.out.println("----- ALL RESERVATIONS -----");
        manager.printAll();

        // Print reservations for specific room
        System.out.println("\n----- RESERVATIONS FOR ROOM 101 -----");
        manager.printForRoom(room101);


        // --------------------------------------
        //  Edge Case Tests
        // --------------------------------------

        System.out.println("\n----- EDGE CASE TESTS -----");

        // Try canceling an already canceled reservation
        try {
            manager.cancelReservation(r2.getId());
        } catch (IllegalStateException e) {
            System.out.println("Passed double cancel test: " + e.getMessage());
        }

        // Try checking in a canceled reservation
        try {
            manager.checkInReservation(r2.getId());
        } catch (IllegalStateException e) {
            System.out.println("Passed check-in after cancel test: " + e.getMessage());
        }

        // Try invalid ID
        try {
            manager.cancelReservation(999);
        } catch (IllegalArgumentException e) {
            System.out.println("Passed invalid ID test: " + e.getMessage());
        }
    
        
        
        
    }
}