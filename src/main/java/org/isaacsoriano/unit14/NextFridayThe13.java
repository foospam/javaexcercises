package org.isaacsoriano.unit14;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class NextFridayThe13 {

    public static void main(String[] args) {
        fridayThe13(1925);
        fridayThe13(2024);

    }

    public static void fridayThe13(int year){

        for (int month = 1; month <= 12; month++) {
            LocalDate localDate = LocalDate.of(year, month, 13);
            if (localDate.getDayOfWeek() == DayOfWeek.FRIDAY)
                System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        }

    }
}
