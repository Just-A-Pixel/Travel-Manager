package travel.passenger;

import org.example.travel.costCalculation.GoldCostStrategy;
import org.example.travel.model.Activity;
import org.example.travel.passenger.Passenger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerTest {
    private Passenger passenger;
    private Activity activity;

    @Before
    public void setUp() {
        passenger = new Passenger.Builder("John", 1).setBalance(100.0).build();
        activity = new Activity("Test Activity", "Description", 50.0, 10);
    }

    @Test
    public void testSignUpForActivity() {
        assertTrue(passenger.signUpForActivity(activity));
        assertEquals(50.0, passenger.getBalance(), 0.001);
    }

    @Test
    public void testSignUpForActivityInsufficientBalance() {
        Passenger brokePassenger = new Passenger.Builder("Broke John", 2).setBalance(20.0).build();
        assertFalse(brokePassenger.signUpForActivity(activity));
        assertEquals(20.0, brokePassenger.getBalance(), 0.001);
    }

    @Test
    public void testSetCostCalculationStrategy() {
        passenger.setCostCalculationStrategy(new GoldCostStrategy());
        assertEquals(GoldCostStrategy.class, passenger.getCostCalculationStrategy().getClass());
    }

    @Test
    public void testDisplayInfo() {
        assertNotNull(passenger.toString());
    }
}
