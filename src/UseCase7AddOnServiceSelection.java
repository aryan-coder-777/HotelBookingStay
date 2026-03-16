import java.util.*;

/**
 * CLASS - AddOnService
 * Represents an optional service for a reservation.
 * @version 7.0
 */
class AddOnService {

    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}


/**
 * CLASS - AddOnServiceManager
 * Manages add-on services for reservations.
 * @version 7.0
 */
class AddOnServiceManager {

    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Attach service to reservation
     */
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /**
     * Calculate total cost of services
     */
    public double calculateTotalServiceCost(String reservationId) {

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services == null) {
            return 0;
        }

        double total = 0;

        for (AddOnService service : services) {
            total += service.getCost();
        }

        return total;
    }
}


/**
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * Demonstrates attaching services to reservations.
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection\n");

        String reservationId = "Single-1";

        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1000);

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        serviceManager.addService(reservationId, breakfast);
        serviceManager.addService(reservationId, spa);

        double totalCost = serviceManager.calculateTotalServiceCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}