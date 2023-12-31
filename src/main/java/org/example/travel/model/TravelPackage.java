package org.example.travel.model;

import org.example.travel.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package containing destinations and passengers.
 */
public class TravelPackage implements TravelComponent {
    private final List<Destination> destinations;
    private final List<Passenger> passengers;
    private String name;
    private int passengerCapacity;

    private TravelPackage() {
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }


    /**
     * Displays passenger details for the travel package.
     */
    public void displayPassengerDetails() {
        System.out.println("Passengers for travel package " + name + " with capacity " + passengerCapacity + " :");
        for (Passenger passenger : passengers) {
            System.out.println("Passenger #" + passenger.getNumber() + ": " + passenger.getName());
        }
    }

    /**
     * Adds a passenger to the Travel Package.
     *
     * @param passenger The activity to sign up for.
     * @return The travel package instance.
     */
    public TravelPackage addPassenger(Passenger passenger) {
        if (passengerCapacity > 0) {
            passengers.add(passenger);
            passengerCapacity--;
        }
        return this;
    }

    /**
     * Adds a passenger to the Travel Package.
     *
     * @param destination The activity to sign up for.
     * @return The travel package instance.
     */
    public TravelPackage addDestination(Destination destination) {
        destinations.add(destination);
        return this;
    }

    /**
     * Displays information about the travel package.
     */
    @Override
    public void display() {
        System.out.println("Travel Package Name: " + name + ", Passenger Capacity: " + passengerCapacity + " ");
        for (TravelComponent destination : destinations) {
            destination.display();
        }
    }

    public void displayAvailableActivities() {
        for (Destination destination : destinations) {
            destination.displayAvailableActivities();
        }
    }

    /**
     * Builder class for creating instances of TravelPackage.
     */
    public static class Builder {
        private final TravelPackage travelPackage;

        public Builder(int capacity) {
            this.travelPackage = new TravelPackage();
            this.travelPackage.passengerCapacity = capacity;
        }

        public Builder setName(String name) {
            travelPackage.name = name;
            return this;
        }

        /**
         * Builds the final TravelPackage instance.
         *
         * @return The created TravelPackage instance.
         */
        public TravelPackage build() {
            return travelPackage;
        }
    }
}
