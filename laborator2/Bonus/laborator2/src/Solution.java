import java.util.Arrays;

public class Solution {
    Problem p;
    int total_Cost;
    String[] destinations;
    String[] sources;
    int[] units;

    public Solution(Problem p)
    {
        this.p=p;
        this.destinations= new String[1];
        this.sources= new String[1];
        this.units= new int[1];
    }
    void resolve()
    {
        for(int i=0; i< p.s.length; i++)    ///parcurg cantitarea de la surselor
        {
            while(p.s[i].supply!=0)         //trec la urmatoarea sursa doar daca am epuizat cantitatea de la sursa curenta
            {
                for(int j=0; j < p.d.length; j++)   //verific si actualizez cantitatile necesare pentru fiecare destinatie
                {                                   // ce pot fi luate de la sursa si aduse la destinatia j
                    if(p.d[j].demand!=0 && p.s[i].supply!=0)
                    {
                        if(p.s[i].supply<p.d[j].demand){    //cantitatea din sursa < cantitatea din destinatie, atunci putem adauga
                                                        //tot ce a ramas din sursa curenta pentru a completa cantitatea din destinatie
                            System.out.println(destinations.length);
                            this.destinations[destinations.length-1]=p.d[j].name;
                            this.sources[sources.length-1]=p.s[i].names;
                            this.units[units.length-1]= p.s[i].supply;
                            this.destinations = Arrays.copyOf(this.destinations, this.destinations.length + 1);
                            this.sources = Arrays.copyOf(this.sources, this.sources.length + 1);
                            this.p.d[j].demand= this.p.d[j].demand - this.p.s[i].supply;
                            this.p.s[i].supply=0;
                            total_Cost=total_Cost+p.costs[i][j]*this.units[units.length-1];;
                            this.units = Arrays.copyOf(this.units, this.units.length + 1);
                            //mai sus adaug in solutie sursa, destinatia si unitatile adaugate

                        }
                        else
                        {
                            this.destinations[destinations.length-1]=p.d[j].name;
                            this.sources[sources.length-1]=p.s[i].names;
                            this.units[units.length-1]= p.d[j].demand;
                            this.destinations = Arrays.copyOf(this.destinations, this.destinations.length + 1);
                            this.sources = Arrays.copyOf(this.sources, this.sources.length + 1);
                            this.p.s[i].supply= this.p.s[i].supply- this.p.d[j].demand;
                            this.p.d[j].demand=0;
                            total_Cost=total_Cost+p.costs[i][j]*this.units[units.length-1];
                            this.units = Arrays.copyOf(this.units, this.units.length + 1);

                        }
                    }
                }
            }

            if(p.s[i].supply!=0)
            {
                System.out.println("Date incorecte" + p.s[i].supply);
                break;
            }
        }
    }
}
