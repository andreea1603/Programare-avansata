public class Hotel extends  Locations implements  Classifiable{
    String name;
    private int rank;

    @Override
    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank= rank;
    }
}
