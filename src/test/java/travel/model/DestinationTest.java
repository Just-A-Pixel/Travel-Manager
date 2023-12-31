package travel.model;

import org.example.travel.model.Activity;
import org.example.travel.model.Destination;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DestinationTest {

    private Destination destination;
    private Activity activity;

    @Before
    public void setUp() {
        destination = new Destination("Test Destination");
        activity = new Activity("Test Activity", "Description", 50.0, 10);
    }

    @Test
    public void testAddActivity() {
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
        assertEquals(destination, activity.getDestination());
    }

    @Test
    public void testDisplay() {
        assertNotNull(destination.toString());
    }
}
