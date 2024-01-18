package org.isaacsoriano.unit18;

import java.io.IOException;
import java.nio.file.Files;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XORFractal {

    public static void main(String[] args) throws IOException {
        String html = """
                     <!DOCTYPE html>
                 <html><body>
                  <svg width="256" height="256">
                   <rect x="10" y="10" width="1" height="1" style="fill:rgb(0,29,0);" />
                  </svg>
                 </body></html>
                """;

        List<String> lines = new ArrayList<>();
        lines.add("""
                     <!DOCTYPE html>
                 <html><body>
                  <svg width="256" height="256">
                  """);

        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                lines.add(String.format("<rect x=\"%d\" y=\"%d\" width=\"1\" height=\"1\" style=\"fill:rgb(0,%d,0);\" />", x, y, x^y));
            }
        }

        lines.add("""
                </svg>
                </body></html>
                """);

        String text = String.join("", lines);

        Path htmlFile = Paths.get("fractal.html");
        Files.writeString(htmlFile, text);
        Desktop dt = Desktop.getDesktop();
        dt.browse(htmlFile.toUri());
    }
}
