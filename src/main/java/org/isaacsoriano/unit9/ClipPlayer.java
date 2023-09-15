package org.isaacsoriano.unit9;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ClipPlayer {
    public static void main(String[] args) {
        try {
            String filename = "src\\main\\java\\org\\isaacsoriano\\unit9\\Clip.wav";
            Path path = Paths.get(filename);
            File clipFile = new File(filename);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(clipFile));
            clip.loop(10);
            clip.start();
            TimeUnit.MICROSECONDS.sleep(clip.getMicrosecondLength()*10 + 50);
            clip.close();
            System.out.println("1");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
