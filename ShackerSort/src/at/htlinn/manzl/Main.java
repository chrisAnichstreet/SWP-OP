package at.htlinn.manzl;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> shakeit = new ArrayList<Integer>();

        // Random number generator
        for(int i = 0; i<100000;i++)
        {
            Random rand = new Random();
            shakeit.add(rand.nextInt(500)+1);
        }


        boolean transf= true;
        int holder ;

        //Zeitmessung:
        long startTime = System.currentTimeMillis();

        while(transf)
        {
            transf = false;
            for(int i = 1; i<shakeit.size(); i++)
            {
                if(shakeit.get(i)<shakeit.get(i-1))
                {
                   holder = shakeit.get(i-1);
                   shakeit.set(i-1,shakeit.get(i));
                   shakeit.set(i,holder);
                   transf=true;
                }
            }
            for(int i = (shakeit.size()-1); i>1; i--)
            {
                if(shakeit.get(i)<shakeit.get(i-1))
                {
                    holder = shakeit.get(i-1);
                    shakeit.set(i-1,shakeit.get(i));
                    shakeit.set(i,holder);
                    transf = true;
                }
            }
        }

        //Zeitmessung Ende:
        long finishTime = System.currentTimeMillis();
        long Racetime = finishTime - startTime;


        for(int i = 1; i<shakeit.size(); i++)
        {
            System.out.println(shakeit.get(i));
        }
        //Zeitausgabe
        System.out.println("And the Algotythm took: "+Racetime+" Milli- Seconds!");
    }
}
