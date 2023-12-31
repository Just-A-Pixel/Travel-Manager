package org.example.travel.costCalculation;

/**
 * Cost calculation strategy for premium passengers (free).
 */
public class PremiumCostStrategy implements CostCalculationStrategy {

    private static final double DISCOUNT_PERCENTAGE = 1.00;

    /**
     * Calculates the cost for a premium passenger (free).
     *
     * @param baseCost The base cost of an activity.
     * @return The cost (always 0 for premium passengers).
     */
    @Override
    public double calculateCost(double baseCost) {
        return baseCost * (1 - DISCOUNT_PERCENTAGE);
    }
}
