package org.example.travel.costCalculation;

/**
 * Default cost calculation strategy for standard passengers.
 */
public class StandardCostStrategy implements CostCalculationStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.00;

    /**
     * Calculates the cost for a standard passenger.
     *
     * @param baseCost The base cost of an activity.
     * @return The same cost as the base cost for standard passengers.
     */
    @Override
    public double calculateCost(double baseCost) {
        return baseCost * (1 - DISCOUNT_PERCENTAGE);
    }
}
