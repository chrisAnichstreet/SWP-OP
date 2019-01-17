package at.htlinn.manzl;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int values;
        try
        {
        values = pascal(4,2);
        System.out.println("Rekursives Aufrufen:"+values);
        iteratpascal(4,2);
        }catch (IllegalArgumentException e)
        {
            System.out.println("Incorrect values");
        }
        System.out.println(fibonacci(5));


    }
    public static int pascal(int zeile, int spalte) throws IllegalArgumentException
    {
        if (spalte > zeile){
            throw new IllegalArgumentException();
        }
        if ((spalte==0) || (zeile==0))
        {
            return 1;
        }
        if ( zeile == spalte)
        {
            return 1;
        }
        return (pascal((zeile-1),(spalte-1)) + pascal((zeile-1),spalte));


    }
    public static int iteratpascal(int zeile, int spalte)
    {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
       // arr.add(ArrayList<Integer>);



        for(int i = zeile; i<=zeile; i++)
        {
            for(int j = 0; j<=i; j++)
            {

                if((spalte == j)&&(zeile==i))
                {
                    return arr.get(i,j);
                }
            }

        }
        return  10;
    }
    public static int fibonacci(int index)
    {
        if(index==0)
        {
            return 1;
        }
        if (index ==1)
        {
            return 2;
        }
        return fibonacci(index-2)+fibonacci(index-1);
    }
}