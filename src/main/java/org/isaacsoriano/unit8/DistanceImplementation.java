package org.isaacsoriano.unit8;

public class DistanceImplementation implements Distance {

    private final int value;

    public DistanceImplementation(int value) {
        this.value = value;
    }

    @Override
    public int meter() {
        return value % 1000;
    }

    @Override
    public int kilometer() {
        return value / 1000;
    }
}
