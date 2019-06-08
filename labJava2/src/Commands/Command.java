package Commands;

import controller.Station;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public abstract class Command {
    Station station;

    public Command() {
        station = Station.getInstance();
    }

    public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, InterruptedException;

    HttpServletRequest blockButtons(HttpServletRequest request) {
        //chooseTheTurnstile(request);
        request.setAttribute("disabledButton", "disabled=\"disabled\"");
        return request;
    }

    void disableSensor(HttpServletRequest request, int id) {
        switch (id) {
            case 1: {
                request.setAttribute("disabledSensor1", "disabled=\"disabled\"");
                break;
            }
            case 2: {
                request.setAttribute("disabledSensor2", "disabled=\"disabled\"");
                break;
            }
            case 3: {
                request.setAttribute("disabledSensor3", "disabled=\"disabled\"");
                break;
            }
        }
    }

    void setCurrentTurnstileById(HttpServletRequest request, int idOfTurnstile) {
        clearSelectForm(request);
        switch (idOfTurnstile) {
            case 0: {
                request.setAttribute("selectedTurnstile0", "selected=\"selected\"");
                break;
            }
            case 1: {
                request.setAttribute("selectedTurnstile1", "selected=\"selected\"");
                break;
            }
            case 2: {
                request.setAttribute("selectedTurnstile2", "selected=\"selected\"");
                break;
            }
            case 3: {
                request.setAttribute("selectedTurnstile3", "selected=\"selected\"");
                break;
            }
            case 4: {
                request.setAttribute("selectedTurnstile4", "selected=\"selected\"");
                break;
            }
        }
    }

    void clearSelectForm(HttpServletRequest request) {
        request.setAttribute("selectedTurnstile0", "");
        request.setAttribute("selectedTurnstile1", "");
        request.setAttribute("selectedTurnstile2", "");
        request.setAttribute("selectedTurnstile3", "");
        request.setAttribute("selectedTurnstile4", "");
    }

    HttpServletRequest changeIndicatorState(HttpServletRequest request, String state) {
        switch (state) {
            case "PASS": {
                blockButtons(request);
                request.setAttribute("indicatorImage", "img/pass.png");
                break;
            }
            case "STOP": {
                // TODO: Alert
                request.setAttribute("refresh", true);
                request.setAttribute("strForWarning", "ERROR: Invalid card!");
                request.setAttribute("onClickIndicator", "onclick=\"myFunction()\"");
                request.setAttribute("indicatorImage", "img/stop.png");

                break;
            }
        }
        return request;
    }

    void chooseTheTurnstile(HttpServletRequest request, Station station) {
        if (request.getParameter("selectTurnstile") != null) {
            switch (request.getParameter("selectTurnstile")) {
                case "turnstile0": {
                    request.setAttribute("selectedTurnstile0", "selected=\"selected\"");
                    station.setCurrentTurnstileId(0);
                    break;
                }
                case "turnstile1": {
                    request.setAttribute("selectedTurnstile1", "selected=\"selected\"");
                    station.setCurrentTurnstileId(1);
                    break;
                }
                case "turnstile2": {
                    request.setAttribute("selectedTurnstile2", "selected=\"selected\"");
                    station.setCurrentTurnstileId(2);
                    break;
                }
                case "turnstile3": {
                    request.setAttribute("selectedTurnstile3", "selected=\"selected\"");
                    station.setCurrentTurnstileId(3);
                    break;
                }
                case "turnstile4": {
                    request.setAttribute("selectedTurnstile4", "selected=\"selected\"");
                    station.setCurrentTurnstileId(4);
                    break;
                }
            }
        }
    }
}
