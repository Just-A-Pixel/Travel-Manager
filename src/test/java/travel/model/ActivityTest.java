package travel.model;

import org.example.travel.model.Activity;
import org.example.travel.passenger.Passenger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {
    private Activity activity;
    private Passenger passenger;

    @Before
    public void setUp() {
        activity = new Activity("Test Activity", "Description", 50.0, 10);
        passenger = new Passenger.Builder("John", 1).setBalance(100.0).build();
    }

    @Test
    public void testAddPassenger() {
        assertTrue(activity.addPassenger(passenger));
        assertEquals(9, activity.getCapacity());
    }

    @Test
    public void testAddPassengerCapacityExceeded() {
        for (int i = 0; i < 10; i++) {
            activity.addPassenger(new Passenger.Builder("Passenger" + i, i).setBalance(100.0).build());
        }
        assertFalse(activity.addPassenger(passenger));
        assertEquals(0, activity.getCapacity());
    }

    @Test
    public void testRemovePassenger() {
        activity.addPassenger(passenger);
        activity.removePassenger(passenger);
        assertEquals(10, activity.getCapacity());
    }

    @Test
    public void testDecreaseCapacity() {
        activity.decreaseCapacity();
        assertEquals(9, activity.getCapacity());
    }

    @Test
    public void testDisplay() {
        assertNotNull(activity.toString());
    }
}
