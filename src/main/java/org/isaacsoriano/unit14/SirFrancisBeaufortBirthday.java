package org.isaacsoriano.unit14;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class SirFrancisBeaufortBirthday {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(LocalDate.now().getYear(), Month.MAY, 27);
        System.out.println(birthday.getYear());
        System.out.println(birthday.getDayOfWeek());
    }


}
