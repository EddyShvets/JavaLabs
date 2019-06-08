package Factory;

import Commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandsFactory {
    private static CommandsFactory instance;
    private Map<String, Command> mapOfCommands;


    public static CommandsFactory getInstance() {
        if (instance == null)
            instance = new CommandsFactory();
        return instance;
    }

    private CommandsFactory() {
        mapOfCommands = new HashMap<String, Command>();
        mapOfCommands.put("clickButton1", new CommandClickFirstButton());
        mapOfCommands.put("clickButton2", new CommandClickSecondButton());
        mapOfCommands.put("clickButton3", new CommandClickThirdButton());
        mapOfCommands.put("clickSensor1", new CommandClickFirstSensor());
        mapOfCommands.put("clickSensor2", new CommandClickSecondSensor());
        mapOfCommands.put("clickSensor3", new CommandClickThirdSensor());
        mapOfCommands.put("clickLogin", new CommandClickLogin());
        mapOfCommands.put("clickDb", new CommandClickDb());
        mapOfCommands.put("clickLogout", new CommandClickLogout());
        mapOfCommands.put("default", new CommandDefaultPage());
    }

    public Command getCommand(String command) {
        return mapOfCommands.get(command);
    }
}
