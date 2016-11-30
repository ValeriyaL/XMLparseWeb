package by.liudchyk.parsing.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Admin on 17.11.2016.
 */
public class CandySAXBuilder extends AbstractCandyBuilder {
    private final static Logger LOG = LogManager.getLogger();
    private CandyHandler ch;
    private XMLReader reader;

    public CandySAXBuilder() {
        ch = new CandyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(ch);
        } catch (SAXException e) {
            LOG.error(e);
        }
        candySet = ch.getCandies();
    }

    @Override
    public void buildSetCandies(String filename) {
        try {
            reader.parse(filename);
        } catch (SAXException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error("something wrong with file", e);
        }
    }
}
