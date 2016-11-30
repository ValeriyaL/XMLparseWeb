package by.liudchyk.parsing.command;

import by.liudchyk.parsing.builder.AbstractCandyBuilder;
import by.liudchyk.parsing.creator.CandyBuilderFactory;
import by.liudchyk.parsing.entity.Candy;
import by.liudchyk.parsing.entity.Chocolate;
import by.liudchyk.parsing.manager.ConfigurationManager;
import by.liudchyk.parsing.servlet.SessionRequestContent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 26.11.2016.
 */
public class ParserCommand implements ActionCommand {
    private static final String PARAMETER = "parser";
    private static final String XML_FILE_PATH = "/data/candies.xml";
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final String PARSER_ATTRIBUTE = "parser";
    private static final String CANDIES_ATTRIBUTE = "candies";
    private static final String CHOCOLATE_ATTRIBUTE = "chocolates";
    private static final String RESULT_PATH = "path.page.result";

    public String execute(SessionRequestContent requestContent) {
        String page = null;
        CandyBuilderFactory sFactory = new CandyBuilderFactory();
        AbstractCandyBuilder builder;
        Object str = requestContent.getParameter(PARAMETER);
        if (str != null) {
            String parser = (String) str;
            builder = sFactory.createStudentBuilder(parser);
            builder.buildSetCandies(requestContent.getPath() + XML_FILE_PATH);
            Set<Candy> res = builder.getCandySet();
            Set<Candy> candyRes = new HashSet<Candy>();
            Set<Chocolate> chocolateRes = new HashSet<Chocolate>();
            for (Candy temp : res) {
                if (temp.getClass() == Chocolate.class) {
                    chocolateRes.add((Chocolate) temp);
                } else {
                    candyRes.add(temp);
                }
            }
            Object locale = requestContent.getSessionAttribute(LOCALE_ATTRIBUTE);
            requestContent.setAttribute(LOCALE_ATTRIBUTE, locale);
            requestContent.setAttribute(PARSER_ATTRIBUTE, parser);
            requestContent.setAttribute(CANDIES_ATTRIBUTE, candyRes);
            requestContent.setAttribute(CHOCOLATE_ATTRIBUTE, chocolateRes);
        }
        page = ConfigurationManager.getProperty(RESULT_PATH);
        return page;
    }

}
