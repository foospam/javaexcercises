package org.isaacsoriano.unit8;

public class Appliance {
    protected boolean isOn;

    public void on(){
        isOn = true;
    }

    public void off(){
        isOn = false;
    }
    public boolean isOn() {
        return isOn;
    }

}
