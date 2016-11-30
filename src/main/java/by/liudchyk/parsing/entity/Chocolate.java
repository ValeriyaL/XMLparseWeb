package by.liudchyk.parsing.entity;

/**
 * Created by Admin on 17.11.2016.
 */
public class Chocolate extends Candy {
    private int percent;
    private ChocolateKind kind;
    private Additives additives = new Additives();

    public static class Additives {
        private int raising;
        private int hazelnut;
        private int cookies;

        public int getRaising() {
            return raising;
        }

        public void setRaising(int raising) {
            this.raising = raising;
        }

        public int getHazelnut() {
            return hazelnut;
        }

        public void setHazelnut(int hazelnut) {
            this.hazelnut = hazelnut;
        }

        public int getCookies() {
            return cookies;
        }

        public void setCookies(int cookies) {
            this.cookies = cookies;
        }

        @Override
        public String toString() {
            return "raising=" + raising +
                    ", hazelnut=" + hazelnut +
                    ", cookies=" + cookies;
        }
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public ChocolateKind getKind() {
        return kind;
    }

    public void setKind(ChocolateKind kind) {
        this.kind = kind;
    }

    public Additives getAdditives() {
        return additives;
    }

    public void setAdditives(Additives additives) {
        this.additives = additives;
    }

    @Override
    public String toString() {
        return "Chocolate{ " + super.toString() +
                " percent=" + percent +
                ", kind=" + kind +
                ", additives=" + additives +
                '}';
    }
}
