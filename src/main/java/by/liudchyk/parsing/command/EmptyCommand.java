package by.liudchyk.parsing.command;

import by.liudchyk.parsing.manager.ConfigurationManager;
import by.liudchyk.parsing.servlet.SessionRequestContent;

public class EmptyCommand implements ActionCommand {
    private static final String MAIN_PATH = "path.page.main";

    public String execute(SessionRequestContent requestContent) {
        String page = ConfigurationManager.getProperty(MAIN_PATH);
        return page;
    }
}

