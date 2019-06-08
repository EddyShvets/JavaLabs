package Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CommandClickDb extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        chooseTheTurnstile(request, station);
        setCurrentTurnstileById(request, station.getCurrentTurnstileId());
        station.postToDb();

        request.setAttribute("indicatorImage", "img/stop.png");
        request.setAttribute("onClickSensor1", "onclick=\"myFunction()\"");
        request.setAttribute("onClickSensor2", "onclick=\"myFunction()\"");
        request.setAttribute("onClickSensor3", "onclick=\"myFunction()\"");
        return "/index.jsp";
    }
}
