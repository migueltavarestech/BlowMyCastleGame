package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Music{

    private Clip clip;
    private File audioFilePath;
    private static final String soundtrackPath = "/Users/MiguelTavares/BlowMyCastleGame/resources/sounds/soundtrack.wav";
    private static final String explosionPath = "/Users/MiguelTavares/BlowMyCastleGame/resources/sounds/explosion.wav";
    private static final String pickUpBombPath = "/Users/MiguelTavares/BlowMyCastleGame/resources/sounds/pick-up-bomb2.wav";
    private static final String putDownBlockPath = "/Users/MiguelTavares/BlowMyCastleGame/resources/sounds/put-down-block.wav";

    public void playMusic() {
        //       File sound = new File(path);
        // comment the line above and use the line below when making build, so the path is accessible when executing jar
        URL soundURL = getClass().getClassLoader().getResource(soundtrackPath);
        try {
            if(soundURL == null){
                File audioFile = new File(soundtrackPath);
                soundURL = audioFile.toURI().toURL();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            start();
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
            URL soundURL2 = Music.class.getClassLoader().getResource(pickUpBombPath);
            if(soundURL2 == null){
                File audioFile2 = new File(pickUpBombPath);
                soundURL2 = audioFile2.toURI().toURL();
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL2);
            Clip clip2 = AudioSystem.getClip();
            clip2.open(audioStream);
            clip2.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void soundBombExplosion() {
        try {
            URL soundURL3 = Music.class.getClassLoader().getResource(explosionPath);
            if(soundURL3 == null){
                File audioFile3 = new File(explosionPath);
                soundURL3 = audioFile3.toURI().toURL();
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL3);
            Clip clip3 = AudioSystem.getClip();
            clip3.open(audioStream);
            clip3.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void soundPutDownBlock() {
        try {
            URL soundURL4 = Music.class.getClassLoader().getResource(putDownBlockPath);
            if(soundURL4 == null){
                File audioFile4 = new File(putDownBlockPath);
                soundURL4 = audioFile4.toURI().toURL();
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL4);
            Clip clip4 = AudioSystem.getClip();
            clip4.open(audioStream);
            clip4.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
