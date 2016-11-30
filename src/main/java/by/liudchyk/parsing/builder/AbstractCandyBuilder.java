package by.liudchyk.parsing.builder;

import by.liudchyk.parsing.entity.Candy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 21.11.2016.
 */
public abstract class AbstractCandyBuilder {
    //protected поле т.к. к нему часто обращаются из подклассов
    protected Set<Candy> candySet;

    public AbstractCandyBuilder() {
        candySet = new HashSet<Candy>();
    }

    public Set<Candy> getCandySet() {
        return candySet;
    }

    public abstract void buildSetCandies(String filename);
}
