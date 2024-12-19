package org.blacksmith.piano;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javazoom.jl.decoder.JavaLayerException;

import javazoom.jl.player.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Piano implements  NativeKeyListener {

    int totalLength ;
    String path = "Main/org/blacksmith/piano/Audio_Files/";
    Player player;
    InputStream is;

    ArrayList<KeyAndChords> list;


    Piano() {

        list = new ArrayList<>();
        // Adding the keys and chords to our constructor
        values();

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


    public void values(){
        list.add(new KeyAndChords(NativeKeyEvent.VC_A,"C2"));
        list.add(new KeyAndChords(NativeKeyEvent.VC_S,"D2"));
        list.add(new KeyAndChords(NativeKeyEvent.VC_D,"E2"));
        list.add(new KeyAndChords(NativeKeyEvent.VC_F,"F2"));
        list.add(new KeyAndChords(NativeKeyEvent.VC_G,"G2"));
        list.add(new KeyAndChords(NativeKeyEvent.VC_J,"A2"));
        list.add(new KeyAndChords(NativeKeyEvent.VC_K,"B2"));
        list.add(new KeyAndChords(NativeKeyEvent.VC_C,"C3"));
        //Black keys
//        list.add(new KeyAndChords(NativeKeyEvent.VC_W,"C3"));
//        list.add(new KeyAndChords(NativeKeyEvent.VC_E,"C3"));

//        list.add(new KeyAndChords(NativeKeyEvent.VC_U,"C3"));
//        list.add(new KeyAndChords(NativeKeyEvent.VC_I,"C3"));
//        list.add(new KeyAndChords(NativeKeyEvent.VC_O,"C3"));
    }

    // Method to detect what keys are being pressed
    public void nativeKeyPressed(NativeKeyEvent e){
        try {
            // To know what keys are being played , please refer to the README
            for (int i = 0; i < list.size(); i++) {
                if (e.getKeyCode() == list.get(i).keys) {
                    play(path + list.get(i).chords + ".mp3");
                }
            }
        }
        catch (JavaLayerException | IOException ex){
            ex.printStackTrace();
        }

    }

}
