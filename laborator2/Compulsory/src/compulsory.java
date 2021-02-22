import java.util.Arrays;
import java.util.Objects;

enum SourceType {WAREHOUSE, FACTORY;}

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

