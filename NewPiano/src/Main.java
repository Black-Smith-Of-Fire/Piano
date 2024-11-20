// This class is for testing code purposes
package src;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class Main extends Thread {

    Main(){

    }

    @Override
    public void run () {} // Just in case

    private void audio(String audio){ // Audio handling
        try {
            File file = new File(audio);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
        // Until user inputs Q , this loop will run.
    }
}
