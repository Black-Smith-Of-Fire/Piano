// This class is for testing code purposes

package src;

//import src.piano.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;

public class TestMe  extends JFrame  implements Runnable, KeyListener{
    TestMe () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(10,10);
        this.addKeyListener(this);
        this.setTitle("Piano");
        this.setVisible(true);
    }


    private void sound(String audio){ // Audio handling
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

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_A) {
            sound("NewPiano/src/piano/C.wav");
        }

        if (keyCode == KeyEvent.VK_S) {
            sound("NewPiano/src/piano/D.wav");
        }

        if (keyCode == KeyEvent.VK_D) {
            sound("NewPiano/src/piano/E.wav");
        }

        if (keyCode == KeyEvent.VK_F) {
            sound("NewPiano/src/piano/F.wav");
        }

        if (keyCode == KeyEvent.VK_G) {
            sound("NewPiano/src/piano/G.wav");
        }

        if (keyCode == KeyEvent.VK_J) {
            sound("NewPiano/src/piano/A.wav");
        }

        if (keyCode == KeyEvent.VK_K) {
            sound("NewPiano/src/piano/B.wav");
        }

        if (keyCode == KeyEvent.VK_C) {
            sound("NewPiano/src/piano/C1.wav");
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    public void audio(String input){
        System.out.println("A");
    }
}
