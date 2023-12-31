package org.example.travel.passenger;

import org.example.travel.model.Activity;

/**
 * Represents a signed-up activity for a passenger.
 */
public class SignedUpActivity {
    private final Activity activity;
    private final double paidAmount;


    public SignedUpActivity(Activity activity, double paidAmount) {
        this.activity = activity;
        this.paidAmount = paidAmount;
    }

    /**
     * Gets the activity associated with this signed-up activity.
     *
     * @return The associated activity.
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * Displays information about the signed-up activity.
     */
    public void display() {
        activity.display();
        System.out.println("Amount Paid: " + paidAmount);
    }


}
