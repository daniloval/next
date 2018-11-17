package com.challenge.next.core.engine.restriction;

import com.challenge.next.core.passenger.Passenger;
import com.challenge.next.core.driver.Driver;

public class MaxDistanceRestriction implements Restriction {

    private final int maxDistance;

    public MaxDistanceRestriction(final int maxDistance) {
        if (maxDistance <= 0) {
            throw new IllegalArgumentException("Max distance cannot be negative or zero.");
        }
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean isFeasible(final Driver driver, final Passenger passenger) {
        final double distance = driver.getPosition().distanceTo(passenger.getPosition());
        return distance < maxDistance;
    }
}