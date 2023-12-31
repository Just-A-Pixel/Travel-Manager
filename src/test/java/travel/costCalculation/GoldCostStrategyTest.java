package travel.costCalculation;

import org.example.travel.costCalculation.CostCalculationStrategy;
import org.example.travel.costCalculation.GoldCostStrategy;
import org.example.travel.costCalculation.PremiumCostStrategy;
import org.example.travel.costCalculation.StandardCostStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoldCostStrategyTest {

    @Test
    public void testGoldCostCalculation() {
        CostCalculationStrategy strategy = new GoldCostStrategy();
        double baseCost = 100.0;
        double expectedCost = baseCost * 0.9;
        assertEquals(expectedCost, strategy.calculateCost(baseCost), 0.001);
    }
}
