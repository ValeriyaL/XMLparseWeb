package by.liudchyk.parsing.command;

public enum CommandEnum {
    LANGUAGE {
        {
            this.command = new LanguageCommand();
        }
    },
    PARSER {
        {
            this.command = new ParserCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}

