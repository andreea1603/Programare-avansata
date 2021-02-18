public class bonus {
    int vizitat[], matrix[][];
    void dfs( int n, int x, int culoare)
    {

        vizitat[x]=culoare;
        for (int i=0; i<n; i++) {
            if(vizitat[i]==0 && matrix[i][x]==1){
                vizitat[i]=culoare;
                dfs(n, i, culoare);
            }
        }
    }
    void Afisare_Textuala(int n, int start, int sp)
    {
            vizitat[start]=1;
            if(nr_vecini(start, n)==1)
            {   for(int i=0; i< sp ; i++) System.out.print(" ");
                System.out.println("-node" + start);
                sp++;
                for(int i=0; i < n ; i++) {
                    if (matrix[start][i] == 1 && vizitat[i] == 0) {
                        Afisare_Textuala(n, i, sp);
                    }
                }
            }
            else
            {   for(int i=0; i< sp ; i++) System.out.print(" ");
                System.out.println("+node" + start);
                sp++;
                for(int i=0; i < n ; i++){
                    if(matrix[start][i]==1 && vizitat[i]==0) {
                        Afisare_Textuala(n, i, sp);
                        //sp++;
                    }
                }
            }
    }
    int conex(int n) {
        for(int i =0; i < (n-1); i++)
            for(int j=i+1; j< n ; j++)
                if(vizitat[i]!=vizitat[j] || vizitat[i]==0 || vizitat[j]==0)
                    return 0;
        return 1;
    }

    int nr_vecini(int x, int n){
        int a=0;
        for(int i=0; i< n ; i++){
            if(matrix[i][x]==1)
                a++;
        }
        return a;
    }
    void generare() {

        int nr_noduri, radacina, nr_muchii, n1, n2;

        nr_noduri=(int)(Math.random()*1_000_000 % 1000) + 1;
        nr_muchii=nr_noduri-1;
        vizitat= new int[nr_noduri+1];
        matrix=new int[nr_noduri+1][nr_noduri+1];
        for(int i=0; i<nr_noduri;i++)
            vizitat[i]=0;

        radacina=(int)(Math.random()*1_000_000 % nr_noduri);
        int k=0;
        int culoare;
        while(conex(nr_noduri)==0)
        {
            for(int i=0; i<nr_noduri; i++)
                vizitat[i]=0;
            culoare=1;
            for(int i=0; i< nr_noduri; i++)
            {
                if(vizitat[i]==0) {
                    dfs(nr_noduri, i, culoare);
                    culoare++;
                }
            }
            k++;
            n1=(int)(Math.random()*1_000_000 % nr_noduri);
            n2=(int)(Math.random()*1_000_000 % nr_noduri);

            if(vizitat[n1]!=vizitat[n2]){
                matrix[n1][n2]=1;
                matrix[n2][n1]=1;
            }
        }
        System.out.println( "Radacina este: " + radacina);
        System.out.println( "Nr de noduri este: " + nr_noduri);
        for(int i=0; i< nr_noduri; i++)
            vizitat[i]=0;
        int sp=1;
        //Afisare_Textuala(nr_noduri, radacina, sp);
    }

    public static void main(String[] args) {
        bonus B= new bonus();
        B.generare();
    }
}

