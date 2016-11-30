package by.liudchyk.parsing.entity;

/**
 * Created by Admin on 17.11.2016.
 */
public enum CandyEnum {
    CANDIES("candies"),
    CANDY("candy"),
    CHOCOLATE("chocolate"),
    ID("id"),
    TYPE("type"),
    KIND("kind"),
    ENERGY("energy"),
    NAME("name"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILIN("vanilin"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBONHYDRATES("harbonhydrates"),
    PERCENT("percent"),
    RAISIN("raisin"),
    HAZELNUT("hazelnut"),
    COOKIES("cookies"),
    PRODUCTION("production"),
    ADDITIVES("additives"),
    VALUE("value"),
    INGREDIENTS("ingredients");
    private String value;

    CandyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
