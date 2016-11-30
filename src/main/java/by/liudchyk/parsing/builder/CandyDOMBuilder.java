package by.liudchyk.parsing.builder;

import by.liudchyk.parsing.entity.Candy;
import by.liudchyk.parsing.entity.CandyType;
import by.liudchyk.parsing.entity.Chocolate;
import by.liudchyk.parsing.entity.ChocolateKind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by Admin on 17.11.2016.
 */
public class CandyDOMBuilder extends AbstractCandyBuilder {
    private final Logger LOG = LogManager.getLogger();

    private DocumentBuilder docBuilder;

    public CandyDOMBuilder() {
        candySet = new HashSet<Candy>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOG.error(e);
        }
    }

    @Override
    public void buildSetCandies(String fileName) {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList candiesList = root.getElementsByTagName("candy");
            NodeList chocolateList = root.getElementsByTagName("chocolate");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement, false);
                candySet.add(candy);
            }
            for (int i = 0; i < chocolateList.getLength(); i++) {
                Element chocoElement = (Element) chocolateList.item(i);
                Chocolate chocolate = (Chocolate) buildCandy(chocoElement, true);
                candySet.add(chocolate);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = "";
        if (node != null) {
            text = node.getTextContent();
        }
        return text;
    }

    private Candy buildCandy(Element candyElement, boolean isChocolate) {
        Candy candy;
        if (isChocolate) {
            candy = new Chocolate();
            ((Chocolate) candy).setKind(ChocolateKind.valueOf(candyElement.getAttribute("kind").toUpperCase()));
            ((Chocolate) candy).setPercent(Integer.valueOf(getElementTextContent(candyElement, "percent")));
            Chocolate.Additives additives = ((Chocolate) candy).getAdditives();
            Element additivesElement = (Element) candyElement.getElementsByTagName("additives").item(0);
            if (!getElementTextContent(additivesElement, "cookies").isEmpty()) {
                additives.setCookies(Integer.valueOf(getElementTextContent(additivesElement, "cookies")));
            } else {
                additives.setCookies(0);
            }
            if (!getElementTextContent(additivesElement, "hazelnut").isEmpty()) {
                additives.setHazelnut(Integer.valueOf(getElementTextContent(additivesElement, "hazelnut")));
            } else {
                additives.setHazelnut(0);
            }
            if (!getElementTextContent(additivesElement, "raisin").isEmpty()) {
                additives.setRaising(Integer.valueOf(getElementTextContent(additivesElement, "raisin")));
            } else {
                additives.setRaising(0);
            }
        } else {
            candy = new Candy();
        }
        candy.setCandyId(candyElement.getAttribute("id"));
        if (!candyElement.getAttribute("type").isEmpty()) {
            candy.setType(CandyType.valueOf(candyElement.getAttribute("type").toUpperCase()));
        } else {
            candy.setType(CandyType.CHOCOLATE);
        }
        candy.setName(getElementTextContent(candyElement, "name"));
        candy.setEnergy(Integer.valueOf(getElementTextContent(candyElement, "energy")));
        candy.setProduction(getElementTextContent(candyElement, "production"));
        Candy.Ingredients ingredients = candy.getIngredients();
        Element ingredientsElement = (Element) candyElement.getElementsByTagName("ingredients").item(0);
        ingredients.setVanilin(Integer.valueOf(getElementTextContent(ingredientsElement, "vanilin")));
        ingredients.setFructose(Integer.valueOf(getElementTextContent(ingredientsElement, "fructose")));
        ingredients.setWater(Integer.valueOf(getElementTextContent(ingredientsElement, "water")));
        ingredients.setSugar(Integer.valueOf(getElementTextContent(ingredientsElement, "sugar")));
        Candy.Value values = candy.getValue();
        Element valuesElement = (Element) candyElement.getElementsByTagName("value").item(0);
        values.setProteins(Integer.valueOf(getElementTextContent(valuesElement, "proteins")));
        values.setFats(Integer.valueOf(getElementTextContent(valuesElement, "fats")));
        values.setCarbonhydrates(Integer.valueOf(getElementTextContent(valuesElement, "carbonhydrates")));
        return candy;
    }

}

