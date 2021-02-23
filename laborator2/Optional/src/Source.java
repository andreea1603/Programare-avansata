import java.util.Objects;

public abstract class Source {
    String names;
    int supply;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    @Override
    public String toString() {
        return "\tSource{" +
                "names='" + names + '\'' +
                ", supply=" + supply +
                '}' + "\n";
    }

}
