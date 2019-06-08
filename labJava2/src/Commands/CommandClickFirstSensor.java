package Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandClickFirstSensor extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        chooseTheTurnstile(request, station);
        setCurrentTurnstileById(request, station.getCurrentTurnstileId());
        if(station.getCurrentTurnstile().getIndicator().getIndicatorString().equals("PASS")) {
            request.setAttribute("onClickSensor1", "");
            request.setAttribute("sensor1Color", "#18F63D");
            disableSensor(request, 2);
            disableSensor(request, 3);
            request.setAttribute("indicatorImage", "img/pass.png");
            blockButtons(request);

            station.proccessSensor1(request);

            request.setAttribute("onClickSensor1", "");
            request.setAttribute("sensor1Color", "#18F63D");
            disableSensor(request, 1);
            disableSensor(request, 2);
            disableSensor(request, 3);

            if(station.getCurrentTurnstile().getIndicator().getIndicatorString().equals("STOP")) {
                request.setAttribute("indicatorImage", "img/stop.png");
            }

            request.setAttribute("onClickSensor1", "onclick=\"myFunction()\"");
            request.setAttribute("onClickSensor2", "onclick=\"myFunction()\"");
            request.setAttribute("onClickSensor3", "onclick=\"myFunction()\"");

            station.getCurrentTurnstile().getTimer().countTime(5);
            response.setIntHeader("Refresh", 5);

            station.getCurrentTurnstile().getIndicator().setIndicatorString("STOP");

        } else {
            station.getCurrentTurnstile().getDeviceForBlockingAccess().blockAccess(request);
            station.getCurrentTurnstile().getDeviceForSoundSignaling().playWarningSound(request);
        }
        return "/index.jsp";
    }
}
