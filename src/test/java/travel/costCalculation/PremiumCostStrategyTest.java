package travel.costCalculation;

import org.example.travel.costCalculation.CostCalculationStrategy;
import org.example.travel.costCalculation.GoldCostStrategy;
import org.example.travel.costCalculation.PremiumCostStrategy;
import org.example.travel.costCalculation.StandardCostStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

public class PremiumCostStrategyTest {
    @Test
    public void testPremiumCostCalculation() {
        CostCalculationStrategy strategy = new PremiumCostStrategy();
        double baseCost = 100.0;
        double expectedCost = 0.0; // Premium passengers sign up for free
        assertEquals(expectedCost, strategy.calculateCost(baseCost), 0.001);
    }
}
