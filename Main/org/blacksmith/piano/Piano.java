package org.blacksmith.piano;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.JavaLayerException;

//import
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.Player;
import java.io.File;
//import org.blacksmith.piano.Audio_Files.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public class Piano implements  NativeKeyListener {

    int totalLength ;
    String path = "Main/org/blacksmith/piano/Audio_Files/";
    Player player;
    InputStream is;
    private FloatControl volControl;
    private AudioDevice device;

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

    // Method to play the audio file which would be passed in the parameter
    public void play(String musicFile) throws IOException,  JavaLayerException {

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



    // Method to detect what keys are being pressed
    public void nativeKeyPressed(NativeKeyEvent e){

        try {
            // To know what keys are being played , please refer to the README
            if (e.getKeyCode() == NativeKeyEvent.VC_A) {
                play(path + "C2.mp3");
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_S) {
                play(path +"D2.mp3");
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_D) {
                play(path + "E2.mp3");
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_F) {
                play(path + "F2.mp3");
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_G) {
                play(path +"G2.mp3");
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_J) {
                play(path +"A2.mp3");
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_K) {
                play(path +"B2.mp3");
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_C) {
                play(path +"C3.mp3");
            }
        }
        catch (JavaLayerException | IOException ex){
            ex.printStackTrace();
        }

    }

}
