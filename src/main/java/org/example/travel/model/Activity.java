package org.example.travel.model;

import org.example.travel.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an activity in a travel package.
 */
public class Activity implements TravelComponent {
    private final String name;
    private final String description;
    private final double cost;
    private int capacity;
    private final List<Passenger> passengers;

    public String getDescription() {
        return description;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public Destination getDestination() {
        return destination;
    }

    private Destination destination;

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    /**
     * Adds a passenger to the activity if there is capacity.
     *
     * @param passenger The passenger to add.
     * @return True if the passenger was added, false otherwise.
     */
    public boolean addPassenger(Passenger passenger) {
        if (capacity > 0) {
            passengers.add(passenger);
            decreaseCapacity();
            return true;
        } else {
            return false;
        }
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }


    /**
     * Removes a passenger from the activity and increase capacity.
     *
     * @param passenger The passenger to remove.
     */
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        increaseCapacity();
    }


    /**
     * Decreases the capacity of the activity.
     */
    public void decreaseCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    /**
     * Increases the capacity of the activity.
     */
    public void increaseCapacity() {
        capacity++;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Displays information about the activity.
     */
    @Override
    public void display() {
        System.out.println("Activity: " + name + ", Description: " + description + ", Cost: " + cost + ", Capacity: " + capacity + " Destination: " + destination.getName());
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
