package org.isaacsoriano.unit10;

import org.isaacsoriano.unit8.ElectronicDevice;
import org.isaacsoriano.unit8.Modulation;

import java.util.Comparator;
import java.util.Objects;

public class ElectronicRadio2 extends ElectronicDevice implements Comparable {

    private int volume;
    private double frequency;
    private Modulation modulation;

    @Override
    public int compareTo(Object o) {
        Comparator<ElectronicDevice> comparator = new Comparator<ElectronicDevice>() {
            @Override
            public int compare(ElectronicDevice o1, ElectronicDevice o2) {
                return Integer.compare(o1.getWatt(), o2.getWatt());
            }
        };

        return Objects.compare(this, (ElectronicDevice) o, comparator);
    }

    static class ElectronicDeviceComparator implements Comparator<ElectronicDevice>{

        @Override
        public int compare(ElectronicDevice o1, ElectronicDevice o2) {
            return Integer.compare(o1.getWatt(), o2.getWatt());
        }
    }

    class ElectronicDeviceComparator2 implements Comparator<ElectronicDevice>{
        @Override
        public int compare(ElectronicDevice o1, ElectronicDevice o2) {
            return Integer.compare(o1.getWatt(), o2.getWatt());
        }
    }

    public ElectronicRadio2() {
    }

    public ElectronicRadio2(double frequency) {
        this.frequency = frequency;
    }

    public ElectronicRadio2(String station) {
        this(stationNameToFrequency(station));
    }

    public ElectronicRadio2(ElectronicRadio2 other) {
        setFrequency(other.getFrequency());
        setModulation(other.getModulation());
        if (other.isOn()) on();
        else off();
        this.volume = other.volume;
    }


    void volumeUp() {
        if (volume < 100) volume++;
    }

    void volumeDown() {
        if (volume > 0) volume--;
    }

    static double stationNameToFrequency(String senderName) {
        double freq = switch (senderName) {
            case "Walking the plank" -> 98.3;
            case "The pirates choir" -> 97.5;
            case "Ship racer radio" -> 91.0;
            default -> 0.0;
        };
        return freq;
    }

    @Override
    public String toString() {
        return "Radio{" +
                super.toString() +
                ", volume=" + volume +
                ", frequency=" + frequency +
                ", modulation=" + modulation +
                '}';
    }


    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getVolume() {
        return volume;
    }

    public Modulation getModulation() {
        return modulation;
    }

    public void setModulation(Modulation modulation) {
        this.modulation = modulation;
    }


}
