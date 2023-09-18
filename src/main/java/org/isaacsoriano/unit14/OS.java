package org.isaacsoriano.unit14;

public enum OS {

    WINDOWS, MACOS, UNIX, UNKNOWN;

    public static void main(String[] args) {
        System.out.println(current());
    }
    public static OS current(){

        String osName = System.getProperty("os.name");

        if (osName.contains("Windows")) return WINDOWS;
        else if (osName.contains("Mac OS")) return MACOS;
        else if (osName.contains("Linux")) return UNIX;
        else return UNKNOWN;

    };
}
