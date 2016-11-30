package by.liudchyk.parsing.builder;

import by.liudchyk.parsing.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Admin on 19.11.2016.
 */
public class CandyStAXBuilder extends AbstractCandyBuilder {
    private static final Logger LOG = LogManager.getLogger();
    private XMLInputFactory factory;

    public CandyStAXBuilder() {
        factory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetCandies(String fileName) {
        FileInputStream inputStream;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.CANDY) {
                        Candy candy = buildCandy(reader, false);
                        candySet.add(candy);
                    }
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.CHOCOLATE) {
                        Chocolate chocolate = (Chocolate) buildCandy(reader, true);
                        candySet.add(chocolate);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOG.error("StAX parsing error! " + ex);
        } catch (FileNotFoundException ex) {
            LOG.error("File " + fileName + " not found! " + ex);
            throw new RuntimeException();
        }
    }

    private Candy buildCandy(XMLStreamReader reader, boolean isChocolate) throws XMLStreamException {
        Candy candy;
        if (isChocolate) {
            candy = new Chocolate();
            ((Chocolate) candy).setKind(ChocolateKind.valueOf(reader.getAttributeValue(null, CandyEnum.KIND.getValue()).toUpperCase()));
        } else {
            candy = new Candy();
            candy.setType(CandyType.valueOf(reader.getAttributeValue(null, CandyEnum.TYPE.getValue()).toUpperCase()));
        }
        candy.setCandyId(reader.getAttributeValue(null, CandyEnum.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            candy.setName(getXMLText(reader));
                            break;
                        case ENERGY:
                            name = getXMLText(reader);
                            candy.setEnergy(Integer.parseInt(name));
                            break;
                        case INGREDIENTS:
                            candy.setIngredients(getXMLIngredients(reader));
                            break;
                        case VALUE:
                            candy.setValue(getXMLValue(reader));
                            break;
                        case PRODUCTION:
                            candy.setProduction(getXMLText(reader));
                            break;
                        case PERCENT:
                            ((Chocolate) candy).setPercent(Integer.valueOf(getXMLText(reader)));
                            break;
                        case ADDITIVES:
                            ((Chocolate) candy).setAdditives(getXMLAdditives(reader));
                            break;
                        default:
                            LOG.warn("There is no such field in a class");
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.CANDY ||
                            CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.CHOCOLATE) {
                        return candy;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Chocolate.Additives getXMLAdditives(XMLStreamReader reader) throws XMLStreamException {
        Chocolate.Additives additives = new Chocolate.Additives();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case RAISIN:
                            additives.setRaising(Integer.valueOf(getXMLText(reader)));
                            break;
                        case COOKIES:
                            additives.setCookies(Integer.valueOf(getXMLText(reader)));
                            break;
                        case HAZELNUT:
                            additives.setHazelnut(Integer.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.ADDITIVES) {
                        return additives;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Additives");
    }

    private Candy.Ingredients getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Candy.Ingredients ingredients = new Candy.Ingredients();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case WATER:
                            ingredients.setWater(Integer.valueOf(getXMLText(reader)));
                            break;
                        case SUGAR:
                            ingredients.setSugar(Integer.valueOf(getXMLText(reader)));
                            break;
                        case FRUCTOSE:
                            ingredients.setFructose(Integer.valueOf(getXMLText(reader)));
                            break;
                        case VANILIN:
                            ingredients.setVanilin(Integer.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.INGREDIENTS) {
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Ingredients");
    }

    private Candy.Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Candy.Value value = new Candy.Value();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case FATS:
                            value.setFats(Integer.valueOf(getXMLText(reader)));
                            break;
                        case PROTEINS:
                            value.setProteins(Integer.valueOf(getXMLText(reader)));
                            break;
                        case CARBONHYDRATES:
                            value.setCarbonhydrates(Integer.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.VALUE) {
                        return value;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Value");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}


