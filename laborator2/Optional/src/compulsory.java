import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * @param
 * @// TODO: 2/22/2021
 *
 */

        public class compulsory {

    /**
     * @param
     *
     */
            public static void main(String[] args) {

                boolean ok=true;
                if(ok==false) { //cazul descris in enuntul problemei
                    Destination[] destinations = new Destination[3];

                    destinations[0] = new Destination("d1", 20);
                    destinations[1] = new Destination("d2", 25);
                    destinations[2] = new Destination("d3", 25);
                    int[][] costs = new int[3][3];
                    costs[0][0] = 2;costs[0][1] = 3;
                    costs[0][2] = 1;costs[1][0] = 5;
                    costs[1][1] = 4;costs[1][2] = 8;
                    costs[2][0] = 5;costs[2][1] = 6;
                    costs[2][2] = 8;

                    Source s1[] = new Source[3];
                    s1[0] = new Factory("s1", 10);
                    s1[1] = new Factory("s2", 35);
                    s1[2] = new Factory("s3", 25);

                    Problem p1 = new Problem(s1, destinations, costs);
                    System.out.println(p1.toString());
                    Solution s = new Solution(p1);
                    s.resolve();
                    System.out.println(s.total_Cost);
                    for (int i = 0; i < s.destinations.length - 1; i++)
                        System.out.println(s.destinations[i] + " " + s.sources[i] + " " + s.units[i]);
                }
                else    //elementele sunt adaugate de la tastatura
                {
                    int [][]costs;
                    Scanner scan = new Scanner(System.in);
                    int nr_Surse, nr_Dest, total_Supply=0, total_Demand=0;
                    System.out.println("Introduceti numarul de surse");
                    nr_Surse=scan.nextInt();

                    System.out.println("Introduceti numarul de destinatii");
                    nr_Dest=scan.nextInt();


                    Source s1[] = new Source[nr_Surse];
                    Destination[] destinations = new Destination[nr_Dest];
                    costs= new int[nr_Surse][nr_Dest];

                    for(int i=0; i<nr_Surse; i++)
                    {
                        System.out.println("Introduceti numele sursei " + i );
                        String name; int supply, k;
                        name=scan.next();

                        System.out.println("Introduceti cantitatea sursei " + i );
                        supply=scan.nextInt();

                        System.out.println("Introduceti valoarea 0 pentru factory si 1 pentru warehouse");
                        k=scan.nextInt();
                        if(k==0)
                        {
                            s1[i]=new Factory(name, supply);
                        }
                        else
                        {
                            s1[i]= new Warehouse(name, supply);
                        }
                        total_Supply=total_Supply+supply;
                    }
                    for(int i=0; i<nr_Dest; i++)
                    {
                        System.out.println("Introduceti numele destinatiei " + i );
                        String name; int demand;
                        name=scan.next();

                        System.out.println("Introduceti cantitatea destinatiei " + i );
                        demand=scan.nextInt();
                        destinations[i]=new Destination(name, demand);
                        total_Demand=total_Demand+ demand;
                        System.out.println(destinations[i].toString());
                    }

                    if(total_Demand==total_Supply) {
                        for (int i = 0; i < s1.length; i++)
                            for (int j = 0; j < destinations.length; j++) {
                                int m;
                                System.out.println("Introduceti costul pentru sursa " + i + "si destinatia" + j);
                                m = scan.nextInt();
                                costs[i][j] = m;
                            }
                        for (int i = 0; i < s1.length; i++) {
                            for (int j = 0; j < destinations.length; j++)
                                System.out.print(costs[i][j] + "  ");
                            System.out.println();
                        }

                        if (s1.length != 0 && destinations.length != 0) {
                            Problem p1 = new Problem(s1, destinations, costs);
                            Solution s = new Solution(p1);
                            s.resolve();
                            System.out.println(s.total_Cost);
                        } else {
                            System.out.println("Datele introduse nu satisfac cerintele problemei");
                        }
                    }
                    else {
                        System.out.println("Datele introduse nu satisfac cerintele problemei");
                    }

                }

            }
        }