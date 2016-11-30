package by.liudchyk.parsing.builder;

import by.liudchyk.parsing.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 17.11.2016.
 */
public class CandyHandler extends DefaultHandler {
    private final static Logger LOG = LogManager.getLogger();
    private Set<Candy> candies;
    private Candy candyCurrent;
    private CandyEnum currentEnum = CandyEnum.CANDIES;

    public CandyHandler() {
        candies = new HashSet<Candy>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = CandyEnum.valueOf(localName.toUpperCase());
        switch (currentEnum) {
            case CANDY:
                candyCurrent = new Candy();
                candyCurrent.setCandyId(attributes.getValue(0));
                if (attributes.getLength() == 2) {
                    candyCurrent.setType(CandyType.valueOf(attributes.getValue(1).toUpperCase()));
                }
                break;
            case CHOCOLATE:
                candyCurrent = new Chocolate();
                candyCurrent.setCandyId(attributes.getValue(0));
                if (attributes.getLength() == 2) {
                    ((Chocolate) candyCurrent).setKind(ChocolateKind.valueOf(attributes.getValue(1).toUpperCase()));
                }
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("candy".equals(localName) || "chocolate".equals(localName)) {
            candies.add(candyCurrent);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String element = new String(ch, start, length).trim();
        if (!element.isEmpty()) {
            switch (currentEnum) {
                case NAME:
                    candyCurrent.setName(element);
                    break;
                case ENERGY:
                    candyCurrent.setEnergy(Integer.valueOf(element));
                    break;
                case WATER:
                    candyCurrent.getIngredients().setWater(Integer.valueOf(element));
                    break;
                case SUGAR:
                    candyCurrent.getIngredients().setSugar(Integer.valueOf(element));
                    break;
                case FRUCTOSE:
                    candyCurrent.getIngredients().setFructose(Integer.valueOf(element));
                    break;
                case VANILIN:
                    candyCurrent.getIngredients().setVanilin(Integer.valueOf(element));
                    break;
                case PROTEINS:
                    candyCurrent.getValue().setProteins(Integer.valueOf(element));
                    break;
                case FATS:
                    candyCurrent.getValue().setFats(Integer.valueOf(element));
                    break;
                case CARBONHYDRATES:
                    candyCurrent.getValue().setCarbonhydrates(Integer.valueOf(element));
                    break;
                case PRODUCTION:
                    candyCurrent.setProduction(element);
                    break;
                case PERCENT:
                    ((Chocolate) candyCurrent).setPercent(Integer.valueOf(element));
                    break;
                case RAISIN:
                    ((Chocolate) candyCurrent).getAdditives().setRaising(Integer.valueOf(element));
                    break;
                case HAZELNUT:
                    ((Chocolate) candyCurrent).getAdditives().setHazelnut(Integer.valueOf(element));
                    break;
                case COOKIES:
                    ((Chocolate) candyCurrent).getAdditives().setCookies(Integer.valueOf(element));
                    break;
                default:
                    LOG.warn("There is no such field in a class");
            }
        }
    }
}
