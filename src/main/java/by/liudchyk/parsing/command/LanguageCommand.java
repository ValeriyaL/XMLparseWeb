package by.liudchyk.parsing.command;

import by.liudchyk.parsing.manager.ConfigurationManager;
import by.liudchyk.parsing.servlet.SessionRequestContent;

public class LanguageCommand implements ActionCommand {
    private static final String PARAMETER = "language";
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final String MAIN_PATH = "path.page.main";

    public String execute(SessionRequestContent requestContent) {
        String page = null;
        Object str = requestContent.getParameter(PARAMETER);
        if (str != null) {
            requestContent.setAttribute(LOCALE_ATTRIBUTE, str);
            requestContent.setSessionAttribute(LOCALE_ATTRIBUTE, str);
        }
        page = ConfigurationManager.getProperty(MAIN_PATH);
        return page;
    }
}

