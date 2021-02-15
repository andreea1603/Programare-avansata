/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author andre
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public class Lab1 {
    public static void main (String[] args)
    {
        Lab1 lab1=new Lab1();
        System.out.println("Hello world!");
        
        String[] languages ={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int result = (int) (Math.random() * 1_000_000);
        
        result = result * 3 ;
        int binar = Integer.parseInt("10101", 2);
        result = result + binar ;

        int decimal=Integer.parseInt("FF",16);  
        result = result + decimal ;
        result = result * 6;

        int c =0, n;
        n = result;
        
        while (n != 0)
        {
            c = c + n%10 ;
            n= n / 10;
        }

        int sum=0, ok=0;
        while (ok ==0)
        {
            while ( c != 0 )
            {
                sum = sum + c % 10 ; 
                c = c / 10;
            }
            if(sum <= 9)
                ok = 1;
            else
            {
             c = sum; 
             sum = 0;
            }
        }
        
        result=sum;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] );
    }
}

