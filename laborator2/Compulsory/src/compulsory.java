import java.util.Arrays;
import java.util.Objects;

enum SourceType {WAREHOUSE, FACTORY;}

    class Source{
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
    }

    class Destination
    {
        String name;
        int demand;

        @Override
        public String toString() {
            return "\tDestination{" +
                    "name='" + name + '\'' +
                    ", demand=" + demand +
                    '}' +" \n";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public int getDemand() {
            return demand;
        }

        public void setDemand(int demand) {
            this.demand = demand;
        }

        public Destination(String name, int demand) {
            this.name = name;
            this.demand= demand;
        }
    }

    class Problem {

        Source[] s;
        Destination[] d;
        int[][] capacities;

        public Problem(Source[] s, Destination[] d, int[][] capacities) {
            this.s = s;
            this.d = d;
            this.capacities = capacities;
        }

        public Source[] getS() {
            return s;
        }

        public void setS(Source[] s) {
            this.s = s;
        }

        public Destination[] getD() {
            return d;
        }

        public void setD(Destination[] d) {
            this.d = d;
        }

        public int[][] getCapacities() {
            return capacities;
        }

        public void setCapacities(int[][] capacities) {
            this.capacities = capacities;
        }

        @Override
        public String toString() {
            String cap= new String();
            for(int i[] : capacities)
                cap = cap + Arrays.toString(i);
            return "Problem{" +
                    "\ns=" + Arrays.toString(s) +
                    ", \nd=" + Arrays.toString(d) +
                    ", \ncapacities=" + cap + "\n" +
                    '}';
        }
    }

        public class compulsory {

            public static void main(String[] args) {

                Source[] sources= new Source[3];

                sources[0]=new Source("s1", SourceType.FACTORY, 10);
                sources[1]=new Source("s2", SourceType.WAREHOUSE , 35);
                sources[2]=new Source("s3", SourceType.WAREHOUSE, 25);

                Destination[] destinations= new Destination[3];

                destinations[0]= new Destination("d1", 20);
                destinations[1]= new Destination("d2", 25);
                destinations[2]= new Destination("d3", 25);
                int [][]costs= new int[3][3];
                costs[0][0]=2;
                costs[0][1]=3;
                costs[0][2]=1;
                costs[1][0]=5;
                costs[1][1]=4;
                costs[1][2]=8;
                costs[2][0]=5;
                costs[2][1]=6;
                costs[2][2]=8;
                
                Problem p1= new Problem(sources, destinations, costs);

                System.out.println(p1.toString());

            }
        }

