// This class is for testing code purposes
package NewPiano;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class Main extends Thread {

    @Override
    public void run () {} // Just in case

    public void audio(String audio){ // Audio handling
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
        Main test = new Main();
        Scanner scanner = new Scanner(System.in);
        String response = "";

        // Until user inputs Q , this loop will run.
        while (!response.equals("Q")) {
            response = scanner.next();

            // Using anonymous class , we could create multiple threads that could run different audios simultaneously

            if(response.equals("a")) { // Part where one audio will run
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/A.wav");
                    }
                };
                thread.start();
            }

            if(response.equals("b")) {
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/B.wav");
                    }
                };
                thread.start();
            }

            if(response.equals("c")) {
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/C.wav");
                    }
                };
                thread.start();
            }

            if(response.equals("d")) {
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/D.wav");
                    }
                };
                thread.start();
            }
            if(response.equals("e")) {
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/E.wav");
                    }
                };
                thread.start();
            }
            if(response.equals("f")) {
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/F.wav");
                    }
                };
                thread.start();
            }

            if(response.equals("g")) {
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/G.wav");
                    }
                };
                thread.start();
            }

            if(response.equals("C")) {
                Thread thread = new Thread() {
                    public void run() {
                        test.audio("NewPiano/src/piano/C1.wav");
                    }
                };
                thread.start();
            }
        }
    }
}
