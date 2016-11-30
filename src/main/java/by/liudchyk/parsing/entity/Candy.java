package by.liudchyk.parsing.entity;

/**
 * Created by Admin on 17.11.2016.
 */
public class Candy {
    private String candyId;
    private CandyType type = CandyType.CHOCOLATE;
    private String name;
    private int energy;
    private String production;
    private Ingredients ingredients = new Ingredients();
    private Value value = new Value();

    public static class Ingredients {
        private int water;
        private int sugar;
        private int fructose;
        private int vanilin;

        public int getWater() {
            return water;
        }

        public void setWater(int water) {
            this.water = water;
        }

        public int getSugar() {
            return sugar;
        }

        public void setSugar(int sugar) {
            this.sugar = sugar;
        }

        public int getFructose() {
            return fructose;
        }

        public void setFructose(int fructose) {
            this.fructose = fructose;
        }

        public int getVanilin() {
            return vanilin;
        }

        public void setVanilin(int vanilin) {
            this.vanilin = vanilin;
        }

        @Override
        public String toString() {
            return "water=" + water +
                    ", sugar=" + sugar +
                    ", fructose=" + fructose +
                    ", vanilin=" + vanilin;
        }
    }

    public static class Value {
        private int proteins;
        private int fats;
        private int carbonhydrates;

        public int getProteins() {
            return proteins;
        }

        public void setProteins(int proteins) {
            this.proteins = proteins;
        }

        public int getFats() {
            return fats;
        }

        public void setFats(int fats) {
            this.fats = fats;
        }

        public int getCarbonhydrates() {
            return carbonhydrates;
        }

        public void setCarbonhydrates(int carbonhydrates) {
            this.carbonhydrates = carbonhydrates;
        }

        @Override
        public String toString() {
            return "proteins=" + proteins +
                    ", fats=" + fats +
                    ", carbonhydrates=" + carbonhydrates;
        }
    }

    public String getCandyId() {
        return candyId;
    }

    public void setCandyId(String candyId) {
        this.candyId = candyId;
    }

    public CandyType getType() {
        return type;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "candyId='" + candyId + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", production='" + production + '\'' +
                ", ingredients=" + ingredients +
                ", value=" + value +
                '}';
    }
}
