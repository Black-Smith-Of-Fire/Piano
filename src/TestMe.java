import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class TestMe extends  Thread {

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    public static void main(String[] args) {
        TestMe test = new TestMe();
        TestMe test2 = new TestMe();
        test.start();
        test2.start();
    }
}
