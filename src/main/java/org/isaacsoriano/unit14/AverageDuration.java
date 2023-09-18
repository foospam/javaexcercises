package org.isaacsoriano.unit14;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AverageDuration {
    public static void main(String[] args) {
        String[] strings = new String[]{"2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"};
        getAverageDuration(strings);

    }

    private static Duration getDuration(String string) {
        String timePattern = "yyyy-MM-dd, HH:mm";
        String startTime = string.substring(0, string.indexOf(" -"));
        String endTime = string.substring(string.indexOf(" - ") + 3);
        System.out.println(startTime);
        System.out.println(endTime);
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern(timePattern));
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern(timePattern));
        Duration duration = Duration.between(startDateTime, endDateTime);
        return duration;
    }

    private static Duration getAverageDuration(String... strings) {

        Duration totalDuration = Duration.ofMinutes(0);

        for (String string : strings) {
            totalDuration = totalDuration.plus(getDuration(string));
        }

        Duration averageDuration = totalDuration.dividedBy(strings.length);
        System.out.printf("%d h %d m", averageDuration.toHours(), averageDuration.toMinutesPart());

        return averageDuration;
    }
}
