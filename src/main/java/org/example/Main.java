package org.example;

import org.example.travel.costCalculation.CostCalculationStrategy;
import org.example.travel.costCalculation.GoldCostStrategy;
import org.example.travel.costCalculation.PremiumCostStrategy;
import org.example.travel.costCalculation.StandardCostStrategy;
import org.example.travel.model.Activity;
import org.example.travel.model.Destination;
import org.example.travel.model.TravelPackage;
import org.example.travel.passenger.Passenger;

public class Main {
    public static void main(String[] args) {
        final CostCalculationStrategy STANDARD_COST_STRATEGY = new StandardCostStrategy();
        final CostCalculationStrategy GOLD_COST_STRATEGY = new GoldCostStrategy();
        final CostCalculationStrategy PREMIUM_COST_STRATEGY = new PremiumCostStrategy();

        TravelPackage travelPackage1 = new TravelPackage.Builder(10).setName("World Trip").build();

        Activity activity = new Activity("Eiffel Tower Tour", "Description", 12.2, 2);
        Activity activity2 = new Activity("Rome Tour", "Description", 12.2, 2);
        Activity activity3 = new Activity("India tour", "India exploration", 78.5, 3);

        Passenger passenger1 = new Passenger.Builder("Alice", 789).setBalance(200).setCostCalculationStrategy(GOLD_COST_STRATEGY).build();
        Passenger passenger2 = new Passenger.Builder("Bob", 343).setCostCalculationStrategy(GOLD_COST_STRATEGY).build();
        Passenger passenger3 = new Passenger.Builder("Ben", 43).setBalance(400.12).setCostCalculationStrategy(PREMIUM_COST_STRATEGY).build();

        passenger1.setCostCalculationStrategy(STANDARD_COST_STRATEGY);

        Destination destination = new Destination("Europe");
        travelPackage1
                .addPassenger(passenger1).addPassenger(passenger2).addPassenger(passenger3)
                .addDestination(destination.addActivity(activity).addActivity(activity2))
                .addDestination(new Destination("Asia Tour").addActivity(activity3));

        passenger1.signUpForActivity(activity);
        passenger1.signUpForActivity(activity2);
        passenger2.signUpForActivity(activity);
        passenger3.signUpForActivity(activity);

//        1. Print itinerary of the travel package including:
//                1. travel package name,
//                2. destinations and details of the activities available at each destination, like name, cost, capacity and description.
        travelPackage1.display();

//        2. Print the passenger list of the travel package including:
//              1. package name,
//              2. passenger capacity,
//              3. number of passengers currently enrolled and
//              4. name and number of each passenger
        travelPackage1.displayPassengerDetails();

//        3. Print the details of an individual passenger including their
    //        1. name,
    //        2. passenger number,
    //        3. balance (if applicable),
    //        4. list of each activity they have signed up for, including the destination the at which the activity is taking place and the price the passenger paid for the activity.
        travelPackage1.getPassengers().get(0).displayInfo();


//        4. Print the details of all the activities that still have spaces available, including how many spaces are available.
        travelPackage1.displayAvailableActivities();


    }
}
