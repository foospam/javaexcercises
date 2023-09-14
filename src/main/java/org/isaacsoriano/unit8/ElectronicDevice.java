package org.isaacsoriano.unit8;

import java.util.Comparator;

public class ElectronicDevice {

    public static void main(String[] args) {
        ElectronicRadio r1 = new ElectronicRadio();
        ElectronicRadio r2 = new ElectronicRadio();
        ElectronicIceMaker ice1 = new ElectronicIceMaker();
        r1.on();
        ice1.on();
        System.out.println(ElectronicDevice.numberOfElectronicDevicesSwitchedOn(r1, r2, ice1));

        r1.setWatt(30);
        r2.setWatt(40);
        ice1.setWatt(50);

        ElectronicDevice ea1 = new ElectronicRadio(); ea1.setWatt( 200 );
        ElectronicDevice ea2 = new ElectronicRadio(); ea2.setWatt( 20 );
        Comparator<ElectronicDevice> c = new ElectronicDeviceComparator();
        System.out.println( c.compare(ea1, ea2) );
        System.out.println( c.compare(ea2, ea1) );
    }
    private boolean isOn;

    private int watt;

    protected void on(){
        isOn = true;
    }

    protected void off(){
        isOn = true;
    }

    protected boolean isOn(){
        return isOn;
    }

    public int getWatt() {
        return watt;
    }

    public void setWatt(int watt) {
        this.watt = watt;
    }

    public static int numberOfElectronicDevicesSwitchedOn( ElectronicDevice... devices ) {
        int deviceCount = 0;
        for (ElectronicDevice device : devices) {
            if (device.isOn()) deviceCount++;
        }

        return deviceCount;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "isOn=" + isOn +
                ", watt=" + watt +
                '}';
    }
}

class FireBox extends ElectronicDevice{

    FireBox(){
        on();
    }

    @Override
    protected void off() {
    }
}

class ElectronicIceMaker extends ElectronicDevice{

}
