package org.isaacsoriano.unit8;

public interface Distance {
    public static void main(String[] args) {
        Distance oneKm = Distance.ofKilometer( 1 );
        System.out.printf( "1 km = %d km, %d m%n", oneKm.kilometer(), oneKm.meter() );

        Distance moreMeter = Distance.ofMeter( 12345 );
        System.out.printf( "12345 m = %d km, %d m", moreMeter.kilometer(), moreMeter.meter() );
    }

    static Distance ofMeter(int value){
        return new DistanceImplementation(value);
        };

    /** FRAGE AN CHRISTIAN: KANN MAN DIE INSTANTIIERUNG VON NOCH UNBEKANNTEN
     * IMPLEMENTIERENDEN KLASSEN MIT EINER FABRIK-METHODE PLANEN?
     */

    static Distance ofKilometer(int value){
        return new DistanceImplementation(value * 1000);
    };

    int meter();

    default int kilometer(){
        return 0;
    };
}
