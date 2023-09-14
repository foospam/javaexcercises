package org.isaacsoriano.unit8;

public class IceMachine extends Appliance {
    private static final int MAX_COLD_LEVEL = 7;
    private static final int MIN_COLD_LEVEL = 0;

    private int coldLevel;

    public void coldLevelUp(){
        if (coldLevel < MAX_COLD_LEVEL) coldLevel++;
    }

    public void coldLevelDown(){
        if (coldLevel > MIN_COLD_LEVEL) coldLevel--;
    }

    public int getColdLevel() {
        return coldLevel;
    }

    @Override
    public String toString() {
        return "IceMachine{" +
                "coldLevel=" + coldLevel +
                ", isOn=" + isOn +
                '}';
    }
}
