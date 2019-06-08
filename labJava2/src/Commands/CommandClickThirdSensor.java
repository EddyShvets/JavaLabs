package Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandClickThirdSensor extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        chooseTheTurnstile(request, station);
        setCurrentTurnstileById(request, station.getCurrentTurnstileId());
        if(station.getCurrentTurnstile().getIndicator().getIndicatorString().equals("PASS")) {
            request.setAttribute("onClickSensor3", "");
            request.setAttribute("sensor3Color", "#18F63D");
            disableSensor(request, 1);
            disableSensor(request, 2);
            request.setAttribute("indicatorImage", "img/pass.png");
            blockButtons(request);

            station.proccessSensor3(request);

            request.setAttribute("onClickSensor3", "");
            request.setAttribute("sensor3Color", "#18F63D");
            disableSensor(request, 1);
            disableSensor(request, 2);
            disableSensor(request, 3);

            if(station.getCurrentTurnstile().getIndicator().getIndicatorString().equals("STOP")) {
                request.setAttribute("indicatorImage", "img/stop.png");
            }

            request.setAttribute("onClickSensor1", "onclick=\"myFunction()\"");
            request.setAttribute("onClickSensor2", "onclick=\"myFunction()\"");
            request.setAttribute("onClickSensor3", "onclick=\"myFunction()\"");

            response.setIntHeader("Refresh", 5);

            station.getCurrentTurnstile().getIndicator().setIndicatorString("STOP");

        } else {
            station.getCurrentTurnstile().getDeviceForBlockingAccess().blockAccess(request);
            station.getCurrentTurnstile().getDeviceForSoundSignaling().playWarningSound(request);
//            request.setAttribute("indicatorImage", "img/stop.png");
//            request.setAttribute("onClickSensor1", "onclick=\"myFunction()\"");
//            request.setAttribute("onClickSensor2", "onclick=\"myFunction()\"");
//            request.setAttribute("onClickSensor3", "onclick=\"myFunction()\"");
        }
        return "/index.jsp";
    }
}
