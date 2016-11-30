package by.liudchyk.parsing.command;

import by.liudchyk.parsing.servlet.SessionRequestContent;

public interface ActionCommand {
    String execute(SessionRequestContent requestContent);
}

