package org.isaacsoriano.unit8;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ElectronicShip {
    public static void main(String[] args) {
        ElectronicRadio bedroomElectronicRadio = new ElectronicRadio();
        bedroomElectronicRadio.volumeUp();
        bedroomElectronicRadio.setWatt(65);
        ElectronicRadio cabooseElectronicRadio = new ElectronicRadio();
        cabooseElectronicRadio.volumeUp();
        cabooseElectronicRadio.setWatt(40);
        TV mainTv = new TV();
        mainTv.setWatt(120);
        ElectronicRadio crElectronicRadio = new ElectronicRadio();
        crElectronicRadio.setWatt(45);
        FireBox alarm = new FireBox();
        alarm.setWatt(10);
        ElectronicShip ship = new ElectronicShip();
        ship.load(bedroomElectronicRadio);
        ship.load(cabooseElectronicRadio);
        ship.load( mainTv );
        ship.load(crElectronicRadio);
        ship.load( alarm );
        ship.holiday();
        System.out.println(ship);
        System.out.println(ship.findMostPowerConsumingElectronicDevice().toString());
        System.out.println(ship.findMostPowerConsumingElectronicDevice().getClass());
        ship.removePowerConsumingElectronicDevices();
        System.out.println(ship.findMostPowerConsumingElectronicDevice().toString());
        System.out.println(ship.findMostPowerConsumingElectronicDevice().getClass());


    }


    private final Predicate<ElectronicDevice> isPowerTooMuch = new IsPowerTooMuch();
    private final static ElectronicDeviceComparator
            ELECTRONIC_DEVICE_COMPARATOR = new ElectronicDeviceComparator();
    private ArrayList<ElectronicDevice> appliances = new ArrayList<ElectronicDevice>();

    public void load(ElectronicDevice appliance){
        appliances.add(appliance);
        appliances.sort(new ElectronicDeviceComparator());
    }

    public void load(ElectronicDevice... appliances){
        for (ElectronicDevice appliance : appliances) {
            load(appliance);
        }
    }

    public void holiday(){
        for (ElectronicDevice appliance : appliances){
            appliance.off();
        }
    }

    public ElectronicDevice findMostPowerConsumingElectronicDevice(){
        return java.util.Collections.max(appliances, new ElectronicDeviceComparator());
    }

    @Override
    public String toString() {
        return "Ship{" +
                "appliances=" + appliances +
                '}';
    }

    public void removePowerConsumingElectronicDevices(){
        appliances.removeIf(isPowerTooMuch);
    }
}
