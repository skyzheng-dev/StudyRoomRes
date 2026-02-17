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
    }
}
