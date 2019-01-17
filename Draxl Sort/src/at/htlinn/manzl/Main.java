package at.htlinn.manzl;

import com.sun.javaws.exceptions.InvalidArgumentException;
import sun.plugin2.message.Message;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        ArrayList<Integer> tosort = new ArrayList<Integer>();

        ArrayList<Integer> sorted = new ArrayList<Integer>();

        // Random number generator
        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            tosort.add(rand.nextInt(500) + 1);
        }

        int min = (tosort.get(0));
        int minindex = 0;

        //Zeitmessung:
        long startTime = System.currentTimeMillis();


        while (tosort.size() != 0) {
            min = (tosort.get(0));
            minindex = 0;
            for (int k = 0; k < (tosort.size()); k++) {
                if (tosort.get(k) < min) {
                    min = tosort.get(k);
                    minindex = k;
                }
            }
            sorted.add(tosort.get(minindex));
            tosort.remove(minindex);
        }
        //Zeitmessung Ende:
        long finishTime = System.currentTimeMillis();
        long Racetime = finishTime - startTime;
        System.out.println("And the Algotythm took: " + Racetime + " Nano Seconds!");


        System.out.println("Vorrausgegangene Arraylist");
        for (int i = 0; i < (tosort.size()); i++) {
            System.out.println(tosort.get(i));
        }

        System.out.println("Nun kommt der Selection Sort !");
        for (int i = 0; i < (sorted.size()); i++) {
            System.out.println(sorted.get(i));
        }

        //Zeitausgabe
        System.out.println("And the Algotythm took: " + Racetime + " Milli-Seconds!");

        //long number = 50;
        //System.out.println(fac(number));


        // Palindrome
        String name = "ANNA";
        if(isPalindrom(name)){
            System.out.println("Yes,it is a Palindrom");
        }
        else System.out.println(("No, it is not a Palindrom"));

        int n = 12;
        try
        {
            fac(n);
        }catch (IllegalArgumentException e){
            System.out.println("Try Again !");
        }


        // RACE : Recursiv VS Endrecursiv:
        long startTimeREC = System.nanoTime();
        long facRecvalueREC =facRec(1200);
        long finishTimeREC = System.nanoTime();
        long RacetimeREC = finishTimeREC - startTimeREC;
        System.out.println("REC Value : "+facRecvalueREC+" and the Algotythm took: " + RacetimeREC + " NANO Seconds!");

        long startTimeRECE = System.nanoTime();
        long facRecvalueRECE =facRecEnd(1200,1);
        long finishTimeRECE = System.nanoTime();
        long RacetimeRECE = finishTimeRECE - startTimeRECE;
        System.out.println("EndRec Value : "+facRecvalueRECE+" and the Algotythm took: " + RacetimeRECE + " NANO Seconds!");

    }

    public static long fac(long f)throws IllegalArgumentException
    {
        if(f<0)
        {
            throw new IllegalArgumentException();
        }
        long num = 1;
        for (int i = 1; i < f; i++) {
            num = num * i;
        }
        return num;
    }
    public static long facRec(long f)throws IllegalArgumentException
    {
        if (f < 0) {
            throw new IllegalArgumentException();
        }
        if(f ==1){
            return 1;
        }
        return facRec(f-1) * f;

    }
    public static long facRecEnd(long f, long i)throws IllegalArgumentException
    {
        if (f < 0) {
            throw new IllegalArgumentException();
        }
        if(f ==1){
            return i;
        }
        i= i*f;
        return facRecEnd(f-1,i);
    }

    public static boolean isPalindrom(String s)
    {
        String check="";
        for(int i =(s.length())-1; i>=0 ; i--)
        {
            check+=(s.charAt(i));
    }
        System.out.println((check));
        if (check.equals(s)){

            return  true;
        }
        else {return false;}

    }
    public static boolean recisPalindrom(String s)
    {
        if(s.length()==1)
        {
            return true;
        }
        if(s.substring(0)==s.substring(s.length()-1))
        {
            s.
        }
    }
}

