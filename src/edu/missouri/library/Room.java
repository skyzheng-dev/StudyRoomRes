package edu.missouri.library;

/*

 * • String roomName (example: "Room 101")

• int capacity (must be positive)

Required behavior:

• Constructor enforces invariants (fail fast)

• Getters as needed (use intentionally)

• A toString() that prints a meaningful description (example: Room 101 (cap 4))

Design note: Consider making Room immutable.

 */





public class Room {



    private final String roomName;

    private final int capacity;



    public Room(String roomName, int capacity) {							//  Constructor enforces invariants (fail fast)

        if (roomName == null || roomName.isBlank()) {

            throw new IllegalArgumentException("Room name cannot be blank");

        }

        if (capacity <= 0) {												// int capacity (must be positive)

            throw new IllegalArgumentException("Capacity must be positive");

        }



        this.roomName = roomName;

        this.capacity = capacity;

    }



    public String getRoomName() {

        return roomName;

    }



    public int getCapacity() {

        return capacity;

    }



    @Override                               //    A toString() that prints a meaningful description (example: Room 101 (cap 4))

    public String toString() {

        return roomName + " (cap " + capacity + ")";

    }

}