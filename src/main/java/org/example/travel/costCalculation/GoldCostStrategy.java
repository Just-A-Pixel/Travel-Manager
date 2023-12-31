package org.example.travel.costCalculation;

/**
 * Cost calculation strategy for gold passengers with a discount.
 */
public class GoldCostStrategy implements CostCalculationStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.10;

    /**
     * Calculates the cost for a gold passenger with a discount.
     *
     * @param baseCost The base cost of an activity.
     * @return The discounted cost.
     */
    @Override
    public double calculateCost(double baseCost) {
        return baseCost * (1 - DISCOUNT_PERCENTAGE);
    }
}
