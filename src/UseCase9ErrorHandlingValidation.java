import java.util.*;

/**
 * CLASS - InvalidBookingException
 * Custom exception for invalid booking scenarios.
 */
class InvalidBookingException extends Exception {

    public InvalidBookingException(String message) {
        super(message);
    }
}


/**
 * CLASS - RoomInventory
 * Maintains available room types.
 */
class RoomInventory {

    private Set<String> roomTypes;

    public RoomInventory() {
        roomTypes = new HashSet<>();
        roomTypes.add("Single");
        roomTypes.add("Double");
        roomTypes.add("Suite");
    }

    public boolean isValidRoomType(String roomType) {
        return roomTypes.contains(roomType);
    }
}


/**
 * CLASS - Reservation
 */
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}


/**
 * CLASS - BookingRequestQueue
 */
class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }
}


/**
 * CLASS - ReservationValidator
 * Validates booking input.
 */
class ReservationValidator {

    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!inventory.isValidRoomType(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}


/**
 * MAIN CLASS
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {

            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            validator.validate(guestName, roomType, inventory);

            Reservation reservation = new Reservation(guestName, roomType);
            bookingQueue.addRequest(reservation);

            System.out.println("Booking request accepted.");

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());
            System.out.println("Note: It is case sensitive");

        } finally {
            scanner.close();
        }
    }
}