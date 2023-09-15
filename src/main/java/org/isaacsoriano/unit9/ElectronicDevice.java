package org.isaacsoriano.unit9;

import org.isaacsoriano.unit8.ElectronicDeviceComparator;
import org.isaacsoriano.unit8.ElectronicRadio;

import java.util.Comparator;

public class ElectronicDevice {

    public static void main(String[] args) {
        ElectronicIceMaker ice1 = new ElectronicIceMaker();
        ice1.on();

        ice1.setWatt(50);

        try {
            ice1.setWatt(0);
        } catch (IllegalWattException e) {
            e.fillInStackTrace();
            throw e;
        }

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
        if (watt <= 0) throw new IllegalWattException(watt + " is not a legal wattage. It must be bigger than 0.");
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
