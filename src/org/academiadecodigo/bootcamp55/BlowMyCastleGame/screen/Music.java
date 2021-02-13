package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music{

    private Clip clip;
    private File audioFilePath;

    public void playMusic() {

        //       File sound = new File(path);
        // comment the line above and use the line below when making build, so the path is accessible when executing jar
        //URL sound = getClass().getClassLoader().getResource(path);
        File audioFile = new File("resources/sounds/soundtrack.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            // start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());

        }

    }

    private void start() {
        clip.setFramePosition(0);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void soundPickUpBomb() {
        try {
            File file = new File("resources/sounds/pick-up-bomb2.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip2 = AudioSystem.getClip();
            clip2.open(audioStream);
            clip2.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void soundBombExplosion() {
        try {
            File file = new File("resources/sounds/explosion.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip3 = AudioSystem.getClip();
            clip3.open(audioStream);
            clip3.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void soundPutDownBlock() {
        try {
            File file = new File("resources/sounds/put-down-block.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip4 = AudioSystem.getClip();
            clip4.open(audioStream);
            clip4.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
