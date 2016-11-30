package by.liudchyk.parsing.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAXXSD {
    private static final Logger LOG = LogManager.getLogger();
    private static final String INPUT_XSD = "data/candies.xsd";

    public static boolean validate(String path) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(path+INPUT_XSD);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(path);
            validator.validate(source);
            LOG.info(path + " is valid.");
            return true;
        } catch (SAXException e) {
            LOG.error("validation " + path + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            LOG.error(path + " is not valid because " + e.getMessage());
        }
        return false;
    }
}
