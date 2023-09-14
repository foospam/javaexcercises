package org.isaacsoriano.unit8;

public class Tracer {
    static boolean isOn;

    static public void on(){
        isOn = true;
    }

    static public void off(){
        isOn = false;
    }

    static public void trace(String string){
        if (isOn) System.out.println(string);
    }

    static public void trace(String format, Object... args){
        if (isOn) System.out.printf(format, args);
    }
}
