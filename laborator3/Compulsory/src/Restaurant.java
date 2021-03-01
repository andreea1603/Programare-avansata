public class Restaurant extends  Locations implements Classifiable{

    private int rank;

    @Override
    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank= rank;
    }
}
