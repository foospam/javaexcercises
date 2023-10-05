package org.isaacsoriano.unit15;

import javax.swing.*;

public class CaptainParadeIsInterrupted {


    public static void main(String[] args) {
        class PrintMessageRunnable implements Runnable {

            private String message;

            public PrintMessageRunnable(String message) {
                this.message = message;
            }

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " " + message);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        PrintMessageRunnable winken = new PrintMessageRunnable("winken");
        PrintMessageRunnable faehnchenSchwenken = new PrintMessageRunnable("Fähnchen schwenken");

        Thread winkenThread = new Thread(winken);
        Thread schwenkenThread = new Thread(faehnchenSchwenken);

        winkenThread.start();
        schwenkenThread.start();

        while (true) {
            String stop = JOptionPane.showInputDialog("Stop threads");
            if (stop.equals("endw")) {
                winkenThread.interrupt();
            } else if (stop.equals("endf")) {
                schwenkenThread.interrupt();
            } else {
                break;
            }
        }
    }


}

