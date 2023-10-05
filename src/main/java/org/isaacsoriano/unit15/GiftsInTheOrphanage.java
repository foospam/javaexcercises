package org.isaacsoriano.unit15;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GiftsInTheOrphanage {

    public static void main(String[] args) {

        class GiveGift implements Runnable{

            private String gift;

            public GiveGift(String gift){
                this.gift = gift;
            }
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+ "- Hey kid, here is your "+gift);
                try {
                    Thread.sleep(1000 + (int) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<String> gifts = new ArrayList<>();
        gifts.add("Teddy bear");
        gifts.add("bicycle");
        gifts.add("toy train");
        gifts.add("puzzle");
        gifts.add("math book");

        for(String gift:gifts){
            executor.execute(new GiveGift(gift));
            try {
                Thread.sleep(1000 + (int) (Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
