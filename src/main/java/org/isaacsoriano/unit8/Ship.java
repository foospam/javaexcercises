//package org.isaacsoriano.unit8;
//
//import java.util.ArrayList;
//
//public class Ship {
//    public static void main(String[] args) {
//        ElectronicRadio bedroomElectronicRadio = new ElectronicRadio();
//        bedroomElectronicRadio.volumeUp();
//        ElectronicRadio cabooseElectronicRadio = new ElectronicRadio();
//        cabooseElectronicRadio.volumeUp();
//        TV mainTv = new TV();
//        ElectronicRadio crElectronicRadio = new ElectronicRadio();
//        FireBox alarm = new FireBox();
//        Ship ship = new Ship();
//        ship.load(bedroomElectronicRadio);
//        ship.load(cabooseElectronicRadio);
//        //ship.load( mainTv );
//        ship.load(crElectronicRadio);
//        //ship.load( alarm );
//        ship.holiday();
//        System.out.println(ship);
//
//    }
//
//    private ArrayList<Appliance> appliances = new ArrayList<Appliance>();
//
//    public void load(Appliance appliance){
//        if (appliance instanceof ElectronicRadio && ((ElectronicRadio) appliance).getVolume() != 0) {
//            appliances.add(appliance);
//            System.out.println("Remember to pay license fee!");
//            }
//        else appliances.add(appliance);
//    }
//
//    public void load(Appliance... appliances){
//        for (Appliance appliance : appliances) {
//            load(appliance);
//        }
//    }
//
//    public void holiday(){
//        for (Appliance appliance : appliances){
//            appliance.off();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Ship{" +
//                "appliances=" + appliances +
//                '}';
//    }
//}
