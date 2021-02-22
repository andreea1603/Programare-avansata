import java.util.Objects;

public class Source {
    String names;
    SourceType type;
    int supply;

    public Source(String names, SourceType type, int supply) {
        this.names = names;
        this.type = type;
        this.supply= supply;
    }

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

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\tSource{" +
                "names='" + names + '\'' +
                ", type=" + type +
                ", supply=" + supply +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && names.equals(source.names) && type == source.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, type, supply);
    }
}
