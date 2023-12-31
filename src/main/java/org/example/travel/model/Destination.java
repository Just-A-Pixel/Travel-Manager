package org.example.travel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination in a travel package.
 */
public class Destination implements TravelComponent {
    private final String name;
    private final List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * Adds an activity to the destination.
     *
     * @param activity The activity to add.
     * @return The destination with the added activity.
     */
    public Destination addActivity(Activity activity) {
        activities.add(activity);
        activity.setDestination(this);
        return this;
    }

    /**
     * Displays information about the destination.
     */
    @Override
    public void display() {
        System.out.println("Destination: " + name);
        for (TravelComponent activity : activities) {
            activity.display();
        }
    }

    /**
     * Displays activities with available capacity at the destination.
     */
    public void displayAvailableActivities() {
        for (Activity activity : activities) {
            if (activity.getCapacity() > 0) {
                activity.display();
            }
        }
    }

    public String getName() {
        return name;
    }
}
