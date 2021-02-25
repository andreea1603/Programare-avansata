public class Warehouse extends Source{

    String type;

    public Warehouse(String names, int supply) {
        this.type = "Warehouse";
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
