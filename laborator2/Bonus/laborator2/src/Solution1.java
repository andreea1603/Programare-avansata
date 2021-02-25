import java.util.Arrays;
public class Solution1 {
    Problem p;
    int total_Cost;
    String[] destinations;
    String[] sources;
    int[] units;


    public Solution1(Problem p)
    {
        this.p=p;
        this.destinations= new String[1];
        this.sources= new String[1];
        this.units= new int[1];
    }

    int minimum_Line(int [][]matrix, int n, int position)
    {
        int min=10000;
        for(int i=0; i<n; i++)
            if(matrix[position][i]<min && p.d[i].demand!=0 && p.s[position].supply!=0)
                min=matrix[position][i];

        return min;
    }
    int second_Minimum_Line(int [][]matrix, int n, int position)
    {
        int min1=10000, min2=10000;
        for(int i=0; i<n; i++) {
            if (matrix[position][i] < min1 && p.d[i].demand!=0 && p.s[position].supply!=0) {
                min2 = min1;
                min1 = matrix[position][i];
            }
            else
            {
                if(matrix[position][i]<min2 && p.d[i].demand!=0 && p.s[position].supply!=0)
                    min2=matrix[position][i];
            }
        }
        return min2;
    }
    int minimum_Colomn(int [][]matrix, int n, int position)
    {
        int min=0;
        for(int i=0; i<n; i++)
            if(matrix[i][position]<min && p.s[i].supply!=0 && p.d[position].demand!=0)
                min=matrix[i][position];

        return min;
    }
    int second_Minimum_Column(int [][]matrix, int n, int position)
    {
        int min1=10000, min2=10000;
        for(int i=0; i<n; i++) {
            if (matrix[i][position] < min1 && p.s[i].supply!=0 && p.d[position].demand!=0) {
                min2 = min1;
                min1 = matrix[i][position];
            }
            else
            {
                if(matrix[i][position]<min2 &&  p.s[i].supply!=0 && p.d[position].demand!=0)
                    min2=matrix[i][position];
            }
        }
        return min2;
    }
    int minimum_Distance_Row(int [][]matrix, int n, int position)
    {
        int minim=10000;
        for(int i=0; i<this.p.s.length; i++)
            for(int j=i+1; j<this.p.d.length;j++)
            {
                if(Math.abs(p.costs[position][i]-p.costs[position][j])<minim &&p.d[i].demand!=0 && p.d[j].demand!=0 && p.s[position].supply!=0)
                    minim=Math.abs(p.costs[position][i]-p.costs[position][j]);

            }
        return minim;
    }
    int minimum_Distance_Column(int [][]matrix, int n, int position)
    {
        int minim=10000;
        for(int i=0; i<n-1; i++)
            for(int j=i+1; j<n;j++)
            {
                if(Math.abs(p.costs[i][position]-p.costs[j][position])<minim && p.s[i].supply!=0 && p.s[j].supply!=0 && p.d[position].demand!=0)
                    minim=Math.abs(p.costs[i][position]-p.costs[j][position]);

            }
        return minim;
    }

    int maximum_Value(int vec[])
    {
        int maxim=0, poz=0;
        for(int i=0; i<vec.length; i++)
            if(maxim<vec[i] && vec[i]!=10000)
            {
                maxim=vec[i];
                poz=i;
            }
        return poz;
    }

    void resolve()
    {
        int []row_Difference=new int[this.p.s.length];
        int []column_Difference= new int[this.p.d.length];
        int total_Cost =0, nr=0;
        int [][]matrix_Costs= new int[p.s.length][p.d.length];

        while(nr!=4) {
            nr++;
            for (int i = 0; i < p.s.length; i++) //pe linia cu sursa
            {
                int minimum_Distance = 0;
                minimum_Distance = minimum_Distance_Row(p.costs, p.s.length, i);
               // System.out.println(minimum_Distance);
                row_Difference[i] = minimum_Distance;
            }
            for (int i = 0; i < p.d.length; i++) //pe linia cu sursa
            {
                int minimum_Distance = 0;
               /// System.out.println(minimum_Distance);
                minimum_Distance = minimum_Distance_Column(p.costs, p.d.length, i);
                column_Difference[i] = minimum_Distance;
            }
            //System.out.println(Arrays.toString(row_Difference) + Arrays.toString(column_Difference));

            int maximum_Value_Difference = 0, pozition = 0, is_Row = 0;

            if (row_Difference[maximum_Value(row_Difference)] > maximum_Value_Difference) {
                pozition = maximum_Value(row_Difference);
                maximum_Value_Difference=row_Difference[maximum_Value(row_Difference)];
                is_Row = 1;
            }

            if (column_Difference[maximum_Value(column_Difference)] > maximum_Value_Difference) {
                maximum_Value_Difference=column_Difference[maximum_Value(column_Difference)];
                pozition = maximum_Value(column_Difference);
                is_Row = 0;
            }

            if (is_Row == 1) {
                int minimum_Row = 10000, pozition_2 = 0;
                for (int i = 0; i < p.d.length; i++)
                    if (minimum_Row > p.costs[pozition][i] && p.s[pozition].supply!=0 && p.d[i].demand!=0) {
                        minimum_Row = p.costs[pozition][i];
                        pozition_2 = i;
                    }

                if (p.s[pozition].supply < p.d[pozition_2].demand) {
                    total_Cost = total_Cost + p.costs[pozition][pozition_2] * p.s[pozition].supply;
                    matrix_Costs[pozition][pozition_2]=p.costs[pozition][pozition_2]*p.s[pozition].supply;

                    p.d[pozition_2].demand = p.d[pozition_2].demand - p.s[pozition].supply;
                    p.s[pozition].supply = 0;

                } else {
                    total_Cost = total_Cost + p.costs[pozition][pozition_2] * p.d[pozition_2].demand;
                    matrix_Costs[pozition][pozition_2]=p.costs[pozition][pozition_2] * p.d[pozition_2].demand;

                    p.s[pozition].supply = p.s[pozition].supply - p.d[pozition_2].demand;
                    p.d[pozition_2].demand = 0;
                    }
            } else {
                int minimum_Column = 10000, pozition_2 = 0;
                for (int i = 0; i < p.s.length; i++)
                    if (minimum_Column > p.costs[i][pozition] && p.s[i].supply!=0 && p.d[pozition].demand!=0) {
                        minimum_Column = p.costs[i][pozition];
                        pozition_2 = i;
                    }
                //System.out.println("position 2: " + pozition_2);
                if (p.d[pozition].demand < p.s[pozition_2].supply) {
                    matrix_Costs[pozition_2][pozition]=p.costs[pozition_2][pozition] * p.d[pozition].demand;;

                    total_Cost = total_Cost + p.costs[pozition_2][pozition] * p.d[pozition].demand;
                    p.s[pozition_2].supply = p.s[pozition_2].supply - p.d[pozition].demand;
                    p.d[pozition].demand = 0;

                } else {
                    total_Cost = total_Cost + p.costs[pozition_2][pozition] * p.s[pozition_2].supply;
                    matrix_Costs[pozition_2][pozition]= p.costs[pozition][pozition_2] * p.s[pozition_2].supply;

                    p.s[pozition_2].supply = p.s[pozition_2].supply - p.d[pozition].demand;
                    p.s[pozition_2].supply = 0;
                }
            }

        }
        for(int i=0; i < p.d.length;i++)
        {
            for(int j=0; j< p.s.length; j++)
            {
                if(p.d[i].demand!=0 && p.s[j].supply!=0)
                {
                    total_Cost=total_Cost+p.costs[j][i]*p.d[i].demand;
                    matrix_Costs[j][i]=p.costs[j][i]*p.d[i].demand;
                    p.d[i].demand=0;
                    p.s[j].supply=0;
                }

            }
        }
        for(int i=0; i < p.d.length;i++) {
            System.out.println(Arrays.toString(matrix_Costs[i]));

        }
        System.out.println(total_Cost);
    }
}