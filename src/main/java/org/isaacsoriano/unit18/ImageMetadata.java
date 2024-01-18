package org.isaacsoriano.unit18;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ImageMetadata {
    public static void main(String[] args) {
        // Specify the path to the image file
        Path imagePath = Paths.get("C:\\Users\\SorianoTapiaIsaac(Gr\\Downloads\\_514dec91-80ba-4ad7-b8b1-0b1d3d68234d.jpg");

        try {
            // Read the image file
            ImageInputStream iis = ImageIO.createImageInputStream(Files.newInputStream(imagePath));

            // Get an ImageReader
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();

                // Set the ImageInputStream for the ImageReader
                reader.setInput(iis);

                // Access metadata information
                int numImages = reader.getNumImages(true);
                for (int i = 0; i < numImages; i++) {
                    // Print metadata for each image
                    System.out.println("Metadata for image " + (i + 1));
                    System.out.println(reader.getImageMetadata(i));
                }
            } else {
                System.out.println("No ImageReader found for the given input stream.");
            }

            // Close the ImageInputStream
            iis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
