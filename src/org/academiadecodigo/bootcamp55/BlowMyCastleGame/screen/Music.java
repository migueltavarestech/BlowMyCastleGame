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
        File audioFile = new File("resources/sounds/[ONTIVA.COM]-Moonspell - The Greater Good ( Official Track )-HQ.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println(e.getMessage());

        }

    }

}
