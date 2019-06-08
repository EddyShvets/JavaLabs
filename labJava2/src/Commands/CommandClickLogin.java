package Commands;

import Factory.DAOFactory;
import model.dbEntity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandClickLogin extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        chooseTheTurnstile(request, station);
        setCurrentTurnstileById(request, station.getCurrentTurnstileId());
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Admin admin = (Admin) DAOFactory.getInstance().getDAO("AdminsDAO").getEntity(login, password);

        if(admin != null) {
            List list = DAOFactory.getInstance().getDAO("PassesThroughTurnstilesDAO").getAll();

            request.setAttribute("pass", list);
            return "/db.jsp";
        }
        else {

            request.setAttribute("errorMessage", "ERROR: Invalid login or password!");
            request.setAttribute("indicatorImage", "img/stop.png");
            request.setAttribute("onClickSensor1", "onclick=\"myFunction()\"");
            request.setAttribute("onClickSensor2", "onclick=\"myFunction()\"");
            request.setAttribute("onClickSensor3", "onclick=\"myFunction()\"");

            return "/index.jsp";
        }
    }
}
