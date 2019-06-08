package Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandClickFirstButton extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        chooseTheTurnstile(request, station);
        setCurrentTurnstileById(request, station.getCurrentTurnstileId());
        changeIndicatorState(request, station.proccessButton1());
        return "/index.jsp";
    }
}
