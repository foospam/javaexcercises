package org.isaacsoriano.unit8;

public class TV extends ElectronicDevice {

    private final MonitorTube monitorTube = new MonitorTube(this);

    public void on(){
        System.out.println("Das Fernsehen wird eingeschaltet.");
        super.on();
        monitorTube.on();
    }

    public void off(){
        monitorTube.off();
        System.out.println("Das Fernsehen wird ausgeschaltet.");
        super.off();
    }

    @Override
    public String toString() {
        return "TV{" +
                super.toString() +
                "monitorTube=" + monitorTube +
                '}';
    }
}
