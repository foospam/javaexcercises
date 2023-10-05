package org.isaacsoriano.unit15;

public class CaptainParade {

    public static void main(String[] args) {
        Runnable winken = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread() + " winken");
                }
            }
        };

        Runnable schwenken = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread() + " Fähnchen schwenken");
            }
        };

        new Thread(winken).start();
        new Thread(schwenken).start();

    }
}
