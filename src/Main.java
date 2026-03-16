/**
 * MAIN CLASS - UseCase2RoomInitialization
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization using
 * domain models before introducing centralized
 * inventory management.
 *
 * Availability is represented using simple variables.
 *
 * @author Developer
 * @version 2.0
 */

public class Main {

    /**
     * Application entry point.
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        // Display Single Room
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable);

        // Display Double Room
        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable);

        // Display Suite Room
        System.out.println("\nSuite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable);
    }
}


/**
 * ABSTRACT CLASS - Room
 *
 * Represents a generic hotel room with
 * common attributes shared by all room types.
 *
 * @version 2.0
 */

abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    /**
     * Constructor to initialize room attributes.
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Displays room details.
     */
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}


/**
 * CLASS - SingleRoom
 *
 * Represents a single room type.
 *
 * @version 2.0
 */

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }

}


/**
 * CLASS - DoubleRoom
 *
 * Represents a double room type.
 *
 * @version 2.0
 */

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }

}


/**
 * CLASS - SuiteRoom
 *
 * Represents a suite room type.
 *
 * @version 2.0
 */

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }

}