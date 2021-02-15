/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verif;

/**
 *
 * @author Ciocan Andreea
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ciocan Andreea
 */
public class Verif {
    long start, end, dif;
    int[] vizitat;
    int[][] vecin ;
    int n;

    public static void main (String[] args)
    {

        Verif verif=new Verif();

        verif.start=System.nanoTime();
        verif.ex2(args);

        verif.end=System.nanoTime();
        verif.dif=verif.end - verif.start;
        System.out.println("Time: " + verif.dif);
    }

    int dfs(int x, int k)
    {
        if(k!=-1) {
            vizitat[x] = k;
            int i;
            for (i = 0; i < n; i++) {
                if (vecin[i][x] != 0 && vizitat[i] == 0) {
                    dfs(i, k);
                }
            }
            return 0;
        }
        else
        {
            vizitat[x] = 9;
            int i;
            for (i = 0; i < n; i++) {
                if (vecin[i][x] != 0 && vizitat[i] == 0)
                {
                    dfs(i, k);
                    System.out.println( i + "," + x );
                    vecin[i][x]=2;
                    vecin[x][i]=2;
                }
            }
            return 0;
        }
    }

    public void ex2 (String[] args) {
        int k = 0, ok = 0;
        int number = 0;
        if(args.length==0)
        {
            System.out.println("Nu ati introdus un parametru");
            System.exit(0);
        }
        for (String s : args) {
            k++;
            try {
                number = Integer.parseInt(s);
                //System.out.println(s + " is a valid integer number");
                //ok=1;
            } catch (NumberFormatException e) {
                System.out.println(s + " is not a valid  number");
                ok = 1;
            }
            if ((Integer.parseInt(s)) % 2 == 0 || k > 1 ) {
                System.out.println(s + " is not a valid number");
                ok = 1;
            }

        }
        if (ok == 0) {
            System.out.println(number + " is a valid number");
            vizitat = new int[number];
            vecin = new int[number][number];

            //generare matrice
            ////////////
            int m, edge;
            m = number;
            int i;
            edge = m * (m - 1) / 2;
            System.out.println(edge);
            for (i = 0; i < edge; i++) {
                int e1, e2;
                e1 = (int) (Math.random() * 1_000_000 % m);
                e2 = (int) (Math.random() * 1_000_000 % m);

                if (e1 != e2) {
                    vecin[e1][e2] = 1;
                    vecin[e2][e1] = 1;
                }
            }

            for (int k1 = 0; k1 < m; k1++)
                vizitat[k1] = 0;
            int col = 1;
            n = m;
            for (int k1 = 0; k1 < m; k1++) {
                if (vizitat[k1] == 0) {
                    dfs(k1, col);
                    col++;
                }
            }

            System.out.println("Numarul de componente conexe: " + (col - 1));
            System.out.print("Nodurile componentelor conexe: ");

            for (int k1 = 0; k1 < col; k1++) {
                for (int k2 = 0; k2 < m; k2++)
                    if (vizitat[k2] == k1) {
                        System.out.print(" " + k2);
                    }
                System.out.println();
            }
            if (col - 1 == 1) {
                for (int k1 = 0; k1 < m; k1++)
                    vizitat[k1] = 0;
                System.out.println("Arbore partial format din muchiile : ");
                dfs(0, -1);
                System.out.println("Matricea arborelui partial: ");
                for (int k1 = 0; k1 < m; k1++) {
                    for (int j = 0; j < m; j++) {
                        if (vecin[k1][j] == 2) {
                            System.out.print("\u25C9");
                        } else
                            System.out.print("\u25CB");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Nu e conex");

            }

            //System.out.println("\u0394\u03B4");
            System.out.println("Matricea de adiacenta a grafului: ");
            for (int k1 = 0; k1 < m; k1++) {
                for (int j = 0; j < m; j++) {
                    if (vecin[k1][j] != 0) {
                        System.out.print("\u25C9");
                    } else
                        System.out.print("\u25CB");
                }
                System.out.println();
            }
            //tree

        }
    }



}

