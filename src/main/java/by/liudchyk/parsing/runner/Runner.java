package by.liudchyk.parsing.runner;

import by.liudchyk.parsing.builder.AbstractCandyBuilder;
import by.liudchyk.parsing.creator.CandyBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 20.11.2016.
 */
public class Runner {
    private static final Logger LOG = LogManager.getLogger();
    private static final String INPUT_XML = "data/candies.xml";
    private static final String PARSER = "stax";

    public static void main(String[] args) {
        CandyBuilderFactory sFactory = new CandyBuilderFactory();
        AbstractCandyBuilder builder = sFactory.createStudentBuilder(PARSER);
        builder.buildSetCandies(INPUT_XML);
        LOG.info(PARSER + " parser: " + builder.getCandySet());
    }
}
