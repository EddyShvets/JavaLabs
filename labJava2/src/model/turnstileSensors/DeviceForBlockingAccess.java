package model.turnstileSensors;

import javax.servlet.http.HttpServletRequest;

public class DeviceForBlockingAccess extends TurnstileSensor {
    int idOfTurnstile;

    public DeviceForBlockingAccess(int idOfTurnstile) {
        this.idOfTurnstile = idOfTurnstile;
    }

    public boolean blockAccess(HttpServletRequest request) {
        request.setAttribute("indicatorImage", "img/stop.png");
        request.setAttribute("onClickSensor1", "onclick=\"myFunction()\"");
        request.setAttribute("onClickSensor2", "onclick=\"myFunction()\"");
        request.setAttribute("onClickSensor3", "onclick=\"myFunction()\"");
        return false;
    }
}
