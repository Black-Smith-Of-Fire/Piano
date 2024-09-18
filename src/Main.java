import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;

public class Main extends JFrame implements Runnable, KeyListener {
    String audioClip = "";

    Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.addKeyListener(this);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void run(){
//        audio();
    }

    public void audio(String audio){

        Scanner scanner = new Scanner(System.in);

        try {
            File file = new File(audio);
//            System.out.println(file.exists());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            String response = scanner.next();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A){
            System.out.println("You pressed : A");
            audio("src/audio.wav");
        }
        if(keyCode == KeyEvent.VK_F){
            System.out.println("You pressed : F");
            audio("src/cant.wav");
        }
    }
}