package org.isaacsoriano.unit17;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FramePicture {

    public static String portrait = """
                 ______
            _.-':::::::`.
            \\::::::::::::`.-._
             \\:::''   `::::`-.`.
              \\         `:::::`.\\
               \\          `-::::`:
                \\______       `:::`.
                .|_.-'__`._     `:::\\
               ,'`|:::|  )/`.     \\:::
              /. -.`--'  : /.\\     ::|
              `-,-'  _,'/| \\|\\\\    |:|
               ,'`::.    |/>`;'\\   |:|
               (_\\ \\:.:.:`((_));`. ;:|
               \\.:\\ ::_:_:_`-','  `-:|
                `:\\\\|     SSt:
                   )`__...---'
            """;

    public static void main(String[] args) {
        frame(portrait);
    }

    public static String frame(String string){
        final String newLine = "\n";
        int max = string.lines().mapToInt(String::length).max().getAsInt();

        return "";
    }
}
