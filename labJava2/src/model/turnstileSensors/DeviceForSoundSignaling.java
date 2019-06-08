package model.turnstileSensors;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.TargetDataLine;

public class DeviceForSoundSignaling extends TurnstileSensor {
    TargetDataLine warningSound;

    public DeviceForSoundSignaling(int idOfTurnstile, TargetDataLine targetDataLine) {
    }

    public void playWarningSound(HttpServletRequest request) {
        System.out.println("sound");
        request.setAttribute("bell", "img/bellOn.png");
        //Toolkit.getDefaultToolkit().beep();
    }
}
