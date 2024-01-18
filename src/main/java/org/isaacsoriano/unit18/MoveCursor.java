package org.isaacsoriano.unit18;

import java.awt.*;
import java.awt.event.*;

public class MoveCursor {
    public static void main(String[] args) {
        try {
            // Create a Robot object
            Robot robot = new Robot();

            // Set the delay between mouse movements (in milliseconds)
            int delay = 1000;

            // Get the screen size
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Move the mouse pointer in a loop
            while (true) {
                // Move the mouse to a random position within the screen
                int x = (int) (Math.random() * screenSize.width);
                int y = (int) (Math.random() * screenSize.height);
                robot.mouseMove(x, y);

                // Pause for the specified delay
                Thread.sleep(delay);
            }

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
