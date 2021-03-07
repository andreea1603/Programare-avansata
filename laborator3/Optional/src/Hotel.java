public class Hotel extends  Locations implements  Classifiable{
    @Override
    public String toString() {
        return '\n'+"Hotel{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    private int rank;

    @Override
    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank= rank;
    }
}
