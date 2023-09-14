package org.isaacsoriano.unit8;

public class ElectronicRadio extends ElectronicDevice {

    private int volume;
    private double frequency;
    private Modulation modulation;

    public ElectronicRadio() {
    }

    public ElectronicRadio(double frequency) {
        this.frequency = frequency;
    }

    public ElectronicRadio(String station) {
        this(stationNameToFrequency(station));
    }

    public ElectronicRadio(ElectronicRadio other) {
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
