package org.isaacsoriano.unit8;

public class Application {
    public static void main(String[] args) {
        ElectronicRadio electronicRadio = new ElectronicRadio();
        electronicRadio.setModulation(Modulation.AM);
        electronicRadio.volumeUp();
        electronicRadio.volumeUp();
        electronicRadio.volumeUp();
        System.out.println(electronicRadio);

    }
}
