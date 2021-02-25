import java.util.Scanner;

/**
 * @param
 * @// TODO: 2/22/2021
 */

public class compulsory {

    /**
     * @param
     */
    public static void main(String[] args) {

        long time_For_Each_Test=0;
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Introduceti: \n\t 0 pentru a solutiona exemplul din laborator \n\t 1 pentru a adauga elementele de la tastatura \n\t 2 pentru a aflat timpul mediu pentru mai multe valori generate ");
        int ok = scan1.nextInt();
        if (ok == 0) { //cazul descris in enuntul problemei
            Destination destinations[] = new Destination[3];

            destinations[0] = new Destination("d1", 20);
            destinations[1] = new Destination("d2", 25);
            destinations[2] = new Destination("d3", 25);
            int[][] costs = new int[3][3];
            costs[0][0] = 2;
            costs[0][1] = 3;
            costs[0][2] = 1;
            costs[1][0] = 5;
            costs[1][1] = 4;
            costs[1][2] = 8;
            costs[2][0] = 5;
            costs[2][1] = 6;
            costs[2][2] = 8;

            Source s132;
            Source s1[] = new Source[3];
            s1[0] = new Factory("s1", 10);
            s1[1] = new Factory("s2", 35);
            s1[2] = new Factory("s3", 25);

            Problem p1 = new Problem(s1, destinations, costs);
            System.out.println(p1.toString());
            Solution1 s = new Solution1(p1);
            s.resolve();
            System.out.println(s.total_Cost);
            for (int i = 0; i < s.destinations.length - 1; i++)
                System.out.println(s.destinations[i] + " " + s.sources[i] + " " + s.units[i]);
        } else    //elementele sunt adaugate de la tastatura
            if (ok == 1) {
                int[][] costs;
                Scanner scan = new Scanner(System.in);
                int nr_Surse, nr_Dest, total_Supply = 0, total_Demand = 0;
                System.out.println("Introduceti numarul de surse");
                nr_Surse = scan.nextInt();

                System.out.println("Introduceti numarul de destinatii");
                nr_Dest = scan.nextInt();


                Source s1[] = new Source[nr_Surse];
                Destination[] destinations = new Destination[nr_Dest];
                costs = new int[nr_Surse][nr_Dest];

                for (int i = 0; i < nr_Surse; i++) {
                    System.out.println("Introduceti numele sursei " + i);
                    String name;
                    int supply, k;
                    name = scan.next();

                    System.out.println("Introduceti cantitatea sursei " + i);
                    supply = scan.nextInt();

                    System.out.println("Introduceti valoarea 0 pentru factory si 1 pentru warehouse");
                    k = scan.nextInt();
                    if (k == 0) {
                        s1[i] = new Factory(name, supply);
                    } else {
                        s1[i] = new Warehouse(name, supply);
                    }
                    total_Supply = total_Supply + supply;
                }
                for (int i = 0; i < nr_Dest; i++) {
                    System.out.println("Introduceti numele destinatiei " + i);
                    String name;
                    int demand;
                    name = scan.next();

                    System.out.println("Introduceti cantitatea destinatiei " + i);
                    demand = scan.nextInt();
                    destinations[i] = new Destination(name, demand);
                    total_Demand = total_Demand + demand;
                    System.out.println(destinations[i].toString());
                }

                if (total_Demand == total_Supply) {
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
                        // Solution s = new Solution(p1);
                        Solution1 s4 = new Solution1(p1);
                        s4.resolve();
                        System.out.println(s4.total_Cost);
                    } else {
                        System.out.println("Datele introduse nu satisfac cerintele problemei");
                    }
                } else {
                    System.out.println("Datele introduse nu satisfac cerintele problemei");
                }

            } else {

                Scanner scan = new Scanner(System.in);
                System.out.println("Introduceti numarul de surse/destinatii");
                int nr_SD = scan.nextInt();

                long start=System.nanoTime();
                for(int m=0; m<10000; m++) {
                    long start2=System.nanoTime();
                    Destination destinations[] = new Destination[nr_SD];
                    Source s1[] = new Source[nr_SD];

                    int sSupply, dDemand, total = 0;
                    for(int i=0; i< destinations.length; i++) {
                        dDemand = (int) (Math.random() * 10000000) % 1000;
                        total = total + dDemand;
                        destinations[i] = new Destination(("d1"+ i), dDemand);
                    }
                    for(int j=0; j< s1.length; j++)
                    {
                        sSupply = (int) (Math.random() * 1000000) % 1000;
                        total = total - sSupply;
                        s1[j] = new Factory(("s1"+j), sSupply);
                    }
                    s1[s1.length-1]=new Factory(("s1"+s1.length), total);
                    int[][] costs = new int[nr_SD][nr_SD];

                    for (int i = 0; i < destinations.length; i++)
                        for (int j = 0; j < destinations.length; j++) {
                            int k = (int) (Math.random() * 1000000) % 100;
                            costs[i][j] = k;
                        }

                    Problem p1 = new Problem(s1, destinations, costs);
                    System.out.println(p1.toString());
                    Solution1 s = new Solution1(p1);
                    s.resolve();
                    System.out.println(s.total_Cost);
                    long end=System.nanoTime();
                    time_For_Each_Test=time_For_Each_Test+(end-start2);

                }
                long end2=System.nanoTime();
                long duration=(end2-start);
                System.out.println("Total time: " + duration);
                System.out.println("Medium time: " + (time_For_Each_Test/10000));
            }

    }
}
