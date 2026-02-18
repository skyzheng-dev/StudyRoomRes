package edu.missouri.library;

public class Main {

    public static void main(String[] args) {

        // Create ReservationManager
        ReservationManager manager = new ReservationManager(10);

        // Create 2 rooms
        Room room101 = new Room("Room 101", 4);
        Room room102 = new Room("Room 102", 6);

        // Create time slots
        TimeSlot slot9  = new TimeSlot(9);
        TimeSlot slot10 = new TimeSlot(10);
        TimeSlot slot11 = new TimeSlot(11);
        TimeSlot slot13 = new TimeSlot(13);
        TimeSlot slot14 = new TimeSlot(14);

        // Create 5 reservations
        Reservation r1 = manager.createReservation(room101, "Alice Smith",   slot9);
        Reservation r2 = manager.createReservation(room101, "Bob Jones",     slot10);
        Reservation r3 = manager.createReservation(room101, "Carol White",   slot11);
        Reservation r4 = manager.createReservation(room102, "David Brown",   slot13);
        Reservation r5 = manager.createReservation(room102, "Emma Johnson",  slot14);

        // Cancel reservation #3
        manager.cancelReservation(r3.getId());

        // Check in the rest of the reservations
        manager.checkInReservation(r1.getId());
        manager.checkInReservation(r2.getId());
        manager.checkInReservation(r4.getId());
        manager.checkInReservation(r5.getId());

        // Print all reservations
        System.out.println("All reservations:");
        manager.printAll();

        // Print reservations for room 101
        System.out.println("\nReservations for room 101:");
        manager.printForRoom(room101);
    }
}