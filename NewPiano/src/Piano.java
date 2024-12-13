// This class is for testing code purposes

package src;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
//import piano.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Piano extends JFrame  implements /*Runnable,*/ NativeKeyListener {

    int totalLength ;
    String path = "NewPiano/Audio_Files/";
    int pauseLocation;
    Player player;
    InputStream is;

    Piano() {
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(10,10);
//        this.addKeyListener(this);
//        this.setTitle("Piano");
//        this.setVisible(true);

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException e){
            System.err.println("There was a stupid problem");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(this);
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


    public void play(String musicFile) throws IOException,  JavaLayerException {
//        is = this.getClass().getResourceAsStream(musicFile);
        is = new FileInputStream(new File(musicFile));
        totalLength = is.available();
        player = new Player(is);

        new Thread(){

            @Override
            public void run() {
                try {
                    player.play();
                }
                catch (JavaLayerException ex) {
                    System.err.println("Error caught " + ex);
                }
            }
        }.start();

    }

    public void nativeKeyPressed(NativeKeyEvent e){
//       String lol = NativeKeyEvent.getKeyText(e.getKeyCode());
//       System.out.println("Key pressed is : " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        try {
            if (e.getKeyCode() == NativeKeyEvent.VC_A) {
                play(path + "C2.mp3");
//            sound("NewPiano/src/piano/C.wav");
                System.out.println("You pressed A ");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_S) {
                play(path +"D2.mp3");
                System.out.println("You pressed S");
//            sound("NewPiano/src/piano/D.wav");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_D) {
                play(path + "E2.mp3");
                System.out.println("You pressed D");
//            sound("NewPiano/src/piano/E.wav");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_F) {
                play(path + "F2.mp3");
                System.out.println("You pressed E");
//            sound("NewPiano/src/piano/F.wav");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_G) {
                play(path +"G2.mp3");
                System.out.println("You pressed G");
//            sound("NewPiano/src/piano/G.wav");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_J) {
                play(path +"A2.mp3");
                System.out.println("You pressed J");
//            sound("NewPiano/src/piano/A.wav");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_K) {
                play(path +"B2.mp3");
                System.out.println("You pressed K");
//            sound("NewPiano/src/piano/B.wav");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_C) {
                play(path +"C3.mp3");
                System.out.println("You pressed C");
//            sound("NewPiano/src/piano/C1.wav");
            }
        }
        catch (JavaLayerException | IOException ex){
            ex.printStackTrace();
        }

    }

}
