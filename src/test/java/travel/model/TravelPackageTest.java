package travel.model;

import org.example.travel.model.Destination;
import org.example.travel.model.TravelPackage;
import org.example.travel.passenger.Passenger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TravelPackageTest {

    private TravelPackage travelPackage;
    private Destination destination;
    private Passenger passenger;

    @Before
    public void setUp() {
        travelPackage = new TravelPackage.Builder(5).setName("Test Package").build();
        destination = new Destination("Test Destination");
        passenger = new Passenger.Builder("John", 1).setBalance(100.0).build();
    }

    @Test
    public void testAddPassenger() {
        assertNotNull(travelPackage.addPassenger(passenger));
        assertEquals(4, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testAddPassengerCapacityExceeded() {
        for (int i = 0; i < 5; i++) {
            travelPackage.addPassenger(new Passenger.Builder("Passenger" + i, i).setBalance(100.0).build());
        }
        assertNotNull(travelPackage.addPassenger(passenger));
        assertEquals(0, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testAddDestination() {
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getDestinations().size());
    }

    @Test
    public void testDisplay() {
        assertNotNull(travelPackage.toString());
    }
}
