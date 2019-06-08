package Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandClickSecondButton extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        chooseTheTurnstile(request, station);
        setCurrentTurnstileById(request, station.getCurrentTurnstileId());
        changeIndicatorState(request, station.proccessButton2());
        return "/index.jsp";
    }
}
