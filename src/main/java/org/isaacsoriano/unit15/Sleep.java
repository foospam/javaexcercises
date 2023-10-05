package org.isaacsoriano.unit15;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Sleep {
    public static void main(String[] args) {

        String[] split = "31414d".split("\\d+");
        int seconds = 0;

        for (String timeIndication : args) {

            if (timeIndication.matches("\\d+")) {
                seconds += Integer.valueOf(timeIndication);
            } else if (timeIndication.matches("\\d+[smhd]")) {
                int quantity = Integer.valueOf(timeIndication.substring(0, timeIndication.length() - 1));
                String timeUnit = timeIndication.substring(timeIndication.length());

                switch (timeUnit) {
                    case "s" -> seconds += quantity;
                    case "m" -> seconds += TimeUnit.MINUTES.toSeconds(quantity);
                    case "h" -> seconds += TimeUnit.HOURS.toSeconds(quantity);
                    case "d" -> seconds += TimeUnit.DAYS.toSeconds(quantity);
                }
            } else throw new IllegalArgumentException("Invalid input!");
        }

        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
