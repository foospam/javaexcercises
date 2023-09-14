package org.isaacsoriano.unit8;

import java.util.function.Predicate;

public class IsPowerTooMuch implements Predicate<ElectronicDevice> {
    private static final int MAXIMUM_POWER_CONSUMPTION = 100;
    @Override
    public boolean test(ElectronicDevice device) {
        return device.getWatt() > MAXIMUM_POWER_CONSUMPTION;
    }
}
