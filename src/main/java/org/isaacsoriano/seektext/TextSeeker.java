package org.isaacsoriano.seektext;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextSeeker {

    public static void main(String[] args) throws IOException {
        Path source = Paths.get("rv_1909.txt");
        BufferedReader reader = Files.newBufferedReader(source);


//        assert 1 == 2;
//        System.out.println(breakLines(removeLineBreaks(reader), 60));
//
//        String texto = """
//                Esto es un pequeño
//                texto que me gustaría
//                ver transpuesto de
//                alguna manera satisfactoria
//                para que pueda usarlo
//                en el futuro, el mismo
//                método para hacer las
//                búsquedas en vertical
//                también, lo que está
//                muy bien desde luego
//                """;
//
//        System.out.println(transposeString(texto));
//
//
        findVertically(reader, "tonto");
    }


    public static void findVertically(Reader reader, String searchString) throws IOException {

        int maxlenght = 50;

        Pattern regex = Pattern.compile(prepareRegex(searchString));
        String originalSource = breakLines(removeLineBreaks(reader), maxlenght, true);
//        Files.writeString(Paths.get("originalSource.txt"), originalSource);
        String currentSource = transposeString(originalSource).toLowerCase();
//        Files.writeString(Paths.get("currentSource.txt"), currentSource);

//        System.out.println(originalSource);
//        System.out.println(currentSource);

        int transposedLineLength = currentSource.indexOf('\n');
        int transposedRowNumber = currentSource.length() / transposedLineLength;
        System.out.println("transposedRowNumber " + transposedRowNumber);

        Matcher matcher = regex.matcher(currentSource);


        if (matcher != null && matcher.find()) {
            String group = matcher.group();
            int start = currentSource.indexOf(group);

            boolean info = false;
            if (info) {

                System.out.println("Transposed line length:" + transposedLineLength);
                System.out.println("Start in transposed text:" + start);
                System.out.println("Start in original text:" + transposeIndices(start, transposedLineLength, maxlenght));
                System.out.println("Column of transposed text:" + start % (transposedLineLength + 1));
                System.out.println("Column of original text:" + start / transposedLineLength);
                System.out.println("Row of transposed text:" + start / transposedLineLength);
                System.out.println("Row of original text:" + start % (transposedLineLength + 1));
                System.out.println("start % transposedLineLength" + ((start % transposedLineLength) / 2));
            }

            int end = start + group.length();

            int originalStart = transposeIndices(start, transposedLineLength, maxlenght);
            int originalEnd = transposeIndices(end, transposedLineLength, maxlenght);

            if (info) {
            System.out.println("");
            System.out.println(originalSource.substring(originalStart, originalEnd));
            System.out.println(matcher.group());
            }

            String htmlExcerpt = printHtmlExtract(start, end, transposedLineLength, originalSource, maxlenght, 3);
            Path tempHtmlFile = Files.createTempFile("tempfile", ".html");
            Files.writeString(tempHtmlFile, htmlExcerpt);
            Desktop.getDesktop().browse(tempHtmlFile.toUri());
        }
    }

    public static String printHtmlExtract(int transposedStart, int transposedEnd, int transposedRowLenght, String originalText, int maxRowLength, int additionalRowNumber) {

        StringBuilder resultText = new StringBuilder();

        for (int i = transposedEnd - 1; i >= transposedStart; i--) {
            int originalIndex = transposeIndices(i, transposedRowLenght, maxRowLength);
            int targetColumnIndex = originalIndex % maxRowLength;
            int originalRowStartIndex = originalIndex - targetColumnIndex;
            String targetRow = originalText.substring(originalRowStartIndex, originalRowStartIndex + maxRowLength);
            resultText.insert(0, targetRow);
            resultText.replace(targetColumnIndex, targetColumnIndex + 1, "<mark><strong>" + resultText.charAt(targetColumnIndex) + "</strong></mark>");

            if (i == transposedEnd - 1) {
                String additionalRows = originalText.substring(originalRowStartIndex + maxRowLength, originalRowStartIndex + ((additionalRowNumber + 1) * maxRowLength));
                resultText.append(additionalRows);
            } else if (i == transposedStart) {
                String additionalRows = originalText.substring(originalRowStartIndex - ((additionalRowNumber + 1) * maxRowLength), originalRowStartIndex);
                resultText.insert(0, additionalRows);
            }
        }

        String head = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Monospace Text</title>
                    <style>
                        /* Apply monospace font to all text */
                        body {
                            font-family: 'Courier New', monospace;
                        }
                    </style>
                </head>
                <body>
                """;

        String tail = "</body></html>";


        return head + resultText.toString().replace("\n", "</br>") + tail;
    }


    public static int transposeIndices(int index, int transposedRowLength, int maxRowLength) {
        int transposedIndex = (index / transposedRowLength) /* row of transposed text, column of original text */
                + (index % (transposedRowLength + 1)) /* column of transposed text, row of original text */ * (maxRowLength + 1);

        return transposedIndex;
    }

    public static String prepareRegex(String searchString) {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < searchString.length(); i++) {
            char currentChar = searchString.charAt(i);
            if (currentChar == ' ') {
                regex.append(" *");
            } else if (currentChar == '.') {
                regex.append("\\.+ *");
            } else if (currentChar == '?') {
                regex.append("\\?+ *");
            } else {
                regex.append(currentChar + "+ *");
            }
        }

        return regex.toString();
    }


    public static String transposeString(String source) {
        StringBuilder result = new StringBuilder(source.length());

        List<String> splittedString = List.of(source.split("\n"));
        int i = 0;
        boolean updated = false;

        do {
            updated = false;
            for (int j = 0; j < splittedString.size(); j++) {
                if (splittedString.get(j).length() > i) {
                    result.append(splittedString.get(j).charAt(i));
                    updated = true;
                } else {
                    result.append(" ");
                }

            }
            result.append("\n");

            i++;
        }
        while (updated == true);
        return result.toString();
    }

    public static String breakLines(String source, int maxLength, boolean withPadding) {

        StringBuilder sourceSB = new StringBuilder(source);

        int breakPoint = 0;
        for (int i = 0; i < sourceSB.length(); i += breakPoint + 1) {
//            System.out.println("i is " + i);
//            System.out.println(sourceSB.substring(i, Math.min(i + maxLength, sourceSB.length())));
            breakPoint = findLineBreak(sourceSB.substring(i, Math.min(i + maxLength, sourceSB.length())), maxLength);
//            System.out.println(sourceSB.substring(i, i + breakPoint));
            if (withPadding) {
                String padding = "";
                for (int j = 0; j < maxLength - breakPoint; j++) {
                    padding += " ";
                }
                sourceSB.replace(i + breakPoint, i + breakPoint + 1, padding + "\n");
//                System.out.println(sourceSB.length());
//                System.out.println(sourceSB.toString());
                breakPoint = maxLength;

            } else {
                sourceSB.replace(i + breakPoint, i + breakPoint + 1, "\n");
            }
        }

        return sourceSB.toString();
    }

    public static int findLineBreak(String source, int maxLength) {
        if (source.length() < maxLength) {
            return source.length() - 1;
        } else if (source.contains("\n")) {
//            System.out.println("aquí");
            return source.indexOf('\n');
        } else {
            for (int i = maxLength - 1; i >= 0; i--) {
                if (Character.isWhitespace(source.charAt(i))) {
                    return i;
                }
            }
            return maxLength;
        }
    }

    ;


    public static String removeLineBreaks(Reader reader) throws IOException {

        StringBuilder result = new StringBuilder();


        char previousChar = '?';
        char lastWrittenChar = '?';
        while (reader.ready()) {

            char currentChar = (char) reader.read();
            if (Character.isDigit(currentChar) && previousChar == '\n') {
                if (lastWrittenChar != ' ') {
                    result.append(" \n" + currentChar);
                    lastWrittenChar = currentChar;
                } else {
                    result.append("\n" + currentChar);
                }

            } else if (!Character.isDigit(currentChar) && previousChar == '\n') {
                result.append(" " + currentChar);


            } else if (currentChar != '\n') {
                result.append(currentChar);
                lastWrittenChar = currentChar;
            }

            previousChar = currentChar;
        }
        return result.toString();
    }


}
