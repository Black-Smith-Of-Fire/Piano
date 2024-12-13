package src;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Piano extends JFrame  implements /*Runnable,*/ NativeKeyListener {

    int totalLength ;
    String path = "NewPiano/Audio_Files/";
    Player player;
    InputStream is;

    Piano() {

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(this);
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

        try {
            if (e.getKeyCode() == NativeKeyEvent.VC_A) {
                play(path + "C2.mp3");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_S) {
                play(path +"D2.mp3");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_D) {
                play(path + "E2.mp3");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_F) {
                play(path + "F2.mp3");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_G) {
                play(path +"G2.mp3");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_J) {
                play(path +"A2.mp3");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_K) {
                play(path +"B1.mp3");
            }
//
            if (e.getKeyCode() == NativeKeyEvent.VC_C) {
                play(path +"C3.mp3");
            }
        }
        catch (JavaLayerException | IOException ex){
            ex.printStackTrace();
        }

    }

}
