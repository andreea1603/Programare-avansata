public class Factory extends Source{

    String type;

    public Factory(String names, int supply) {
        this.type = "Factory";
        this.supply = supply;
        this.names = names;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
