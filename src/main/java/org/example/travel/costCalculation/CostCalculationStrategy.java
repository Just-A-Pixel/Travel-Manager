package org.example.travel.costCalculation;

/**
 * Interface for different cost calculation strategies using Strategy pattern
 */
public interface CostCalculationStrategy {

    /**
     * Calculates the cost based on the given base cost.
     *
     * @param baseCost The base cost of an activity.
     * @return The calculated cost.
     */
    double calculateCost(double baseCost);
}
