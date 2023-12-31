package travel.costCalculation;

import org.example.travel.costCalculation.CostCalculationStrategy;
import org.example.travel.costCalculation.GoldCostStrategy;
import org.example.travel.costCalculation.PremiumCostStrategy;
import org.example.travel.costCalculation.StandardCostStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

public class StandardCostStrategyTest {
    @Test
    public void testStandardCostCalculation() {
        CostCalculationStrategy strategy = new StandardCostStrategy();
        double baseCost = 100.0;
        assertEquals(baseCost, strategy.calculateCost(baseCost), 0.001);
    }
}
