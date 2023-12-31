package org.example.travel.passenger;

import org.example.travel.costCalculation.CostCalculationStrategy;
import org.example.travel.costCalculation.StandardCostStrategy;
import org.example.travel.model.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger in the travel package.
 */
public class Passenger {
    public int getPassengerNumber() {
        return passengerNumber;
    }

    public CostCalculationStrategy getCostCalculationStrategy() {
        return costCalculationStrategy;
    }

    public double getBalance() {
        return balance;
    }

    public List<SignedUpActivity> getSignedUpActivities() {
        return signedUpActivities;
    }

    private final String name;
    private final int passengerNumber;
    private CostCalculationStrategy costCalculationStrategy;
    private double balance;
    private final List<SignedUpActivity> signedUpActivities;

    public Passenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.costCalculationStrategy = new StandardCostStrategy();
        this.balance = 0;
        signedUpActivities = new ArrayList<>();
    }

    /**
     * Signs up a passenger for an activity.
     *
     * @param activity The activity to sign up for.
     * @return True if the sign-up is successful, false otherwise.
     */
    public boolean signUpForActivity(Activity activity) {
        double cost = costCalculationStrategy.calculateCost(activity.getCost());
        if (balance >= cost && activity.addPassenger(this)) {
            balance -= cost;
            return signedUpActivities.add(new SignedUpActivity(activity, balance));
        }
        return false;
    }

    /**
     * Sets the cost calculation strategy for the passenger.
     *
     * @param costCalculationStrategy The cost calculation strategy to set.
     */
    public void setCostCalculationStrategy(CostCalculationStrategy costCalculationStrategy) {
        this.costCalculationStrategy = costCalculationStrategy;
    }

    /**
     * Displays information about the passenger.
     */
    public void displayInfo() {
        System.out.println("Passenger Info: " + name + ", Passenger #" + passengerNumber);
        if (!costCalculationStrategy.getClass().getSimpleName().equals("PremiumCostStrategy")) {
            System.out.println("Balance: " + balance);
        }
        System.out.println("Signed up Activities: ");
        for (SignedUpActivity signedUpActivity : signedUpActivities) {
            signedUpActivity.display();
        }
    }

    /**
     * Gets the name of the passenger.
     *
     * @return The name of the passenger.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the passenger number.
     *
     * @return The passenger number.
     */
    public int getNumber() {
        return passengerNumber;
    }

    /**
     * Builder class for creating instances of Passenger.
     */
    public static class Builder {
        private final Passenger Passenger;

        public Builder(String name, int passengerNumber) {
            this.Passenger = new Passenger(name, passengerNumber);
        }

        public Builder setBalance(double balance) {
            this.Passenger.balance = balance;
            return this;
        }

        public Builder setCostCalculationStrategy(CostCalculationStrategy costCalculationStrategy) {
            this.Passenger.costCalculationStrategy = costCalculationStrategy;
            return this;
        }

        /**
         * Builds the final Passenger instance.
         *
         * @return The created Passenger instance.
         */
        public Passenger build() {
            return this.Passenger;
        }

    }

}
