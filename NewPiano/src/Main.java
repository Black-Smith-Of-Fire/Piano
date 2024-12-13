// This class is for testing code purposes
package src;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Main  {

//    public void nativeKeyPressed(NativeKeyEvent e) {
//       String lol = NativeKeyEvent.getKeyText(e.getKeyCode());
//        System.out.println("Key pressed is : " + NativeKeyEvent.getKeyText(e.getKeyCode()));
//    }
    public static void main(String[] args) {
//        try {
//            GlobalScreen.registerNativeHook();
//        }
//        catch (NativeHookException e){
//            System.err.println("There was a stupid problem");
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
//        GlobalScreen.addNativeKeyListener(new Main());
        new Piano();
    }

}
