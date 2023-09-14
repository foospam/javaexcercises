package org.isaacsoriano.unit8;

public class MonitorTube {
    private TV tv;
    private boolean isOn;

    public MonitorTube(){}

    public MonitorTube(TV tv){
        this.tv = tv;
    }

    public void on(){
        System.out.println("Die Bildrohr wird eingeschaltet.");
        isOn = true;
    }

    public void off(){
        System.out.println("Die Bildröhre wird ausgeschaltet");
        isOn = false;
    }



}
