package by.liudchyk.parsing.creator;

import by.liudchyk.parsing.command.ActionCommand;
import by.liudchyk.parsing.command.CommandEnum;
import by.liudchyk.parsing.command.EmptyCommand;
import by.liudchyk.parsing.servlet.SessionRequestContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionFactory {
    private static final Logger LOG = LogManager.getLogger();
    private static final String PARAMETER = "command";

    public ActionCommand defineCommand(SessionRequestContent sessionRequestContent) {
        ActionCommand current = new EmptyCommand();
        String actionS = sessionRequestContent.getParameter(PARAMETER);
        if (actionS == null || actionS.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(actionS.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            LOG.error(e);
        }
        return current;
    }
}

