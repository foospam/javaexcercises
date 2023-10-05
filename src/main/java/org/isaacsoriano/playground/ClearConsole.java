package org.isaacsoriano.playground;


public class ClearConsole {

    public static void main(String[] args) {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                System.out.println("Windows!");
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}