package Servlets;

import Commands.Command;
import Factory.CommandsFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MyServlet", urlPatterns = "/myUrl")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            proccessRequest(request, response);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            proccessRequest(request, response);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, InterruptedException {
        Command command;

        if (request.getParameter("command") != null) {
            command = CommandsFactory.getInstance().getCommand(request.getParameter("command"));
        } else {
            command = CommandsFactory.getInstance().getCommand("default");
        }

        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher(command.execute(request, response));
        requestDispatcher.forward(request, response);
    }
}
