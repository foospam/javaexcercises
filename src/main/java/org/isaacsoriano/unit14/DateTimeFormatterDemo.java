package org.isaacsoriano.unit14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatterDemo {

    public static void main(String[] args) {

        LocalDate now = LocalDate.of(Year.now().getValue(), Month.SEPTEMBER, 19);

        for (Locale locale : Locale.getAvailableLocales()
        ) {
            System.out.print(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale)));
            System.out.println(" "+locale.toLanguageTag());
        }

        System.out.print(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.forLanguageTag("es-ES"))));



    }

}
