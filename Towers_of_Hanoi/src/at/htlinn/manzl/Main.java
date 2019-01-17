package at.htlinn.manzl;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        // DECLERATION
       /* ArrayList<Integer> stapelOne = new ArrayList<>();
        ArrayList<Integer> mystapelaux = new ArrayList<>();
        ArrayList<Integer> mystapeltarget = new ArrayList<>();
        int n = 4;
        for (int i=n; i>=1; i--)
        {
            stapelOne.add(i);
        }

        move(n, stapelOne, mystapelaux, mystapeltarget);
*/
        ArrayList<Integer> quicklist = new ArrayList<>();
        quicklist.add(15);
        quicklist.add(8);
        quicklist.add(7);
        quicklist.add(4);
        quicklist.add(25);
        quicklist.add(135);
        quicklist.add(1);
        quicklist.add(67);
        System.out.println(quickAFsort(quicklist));
        // quick(ar);
    }

    /*   public static ArrayList<Integer> quick(ArrayList<Integer> ar =new ArrayList<>())

       {
           ArrayList<Integer> ar = new ArrayList<>();
           ArrayList<Integer> arOne = new ArrayList<>();
           ArrayList<Integer> arTwo = new ArrayList<>();

           int zenit = ar.get(ar.size() / 2);

           if ((ar.size()) % 2 > 0) {
               zenit = (ar.get(ar.size() / 2 + 1));
           }

           for (int i = 0; i <= (ar.size() - 1); i++) {
               if (ar.get(i) < zenit) {
                   arOne.add(ar.get(i));
               }
               if (ar.get(i) >= zenit) {
                   arTwo.add(ar.get(i));
               }
           }
           ar.clear();
           return (ar.add(quick(arOne).add(quick(arTwo))));

       }

       public static towers(int stapel, ArrayList<Integer> a) {


           if ((stapelOne.size() == 0) || (stapelOne.size() == 1)) {
               move(stapelOne, targetstapel);
           }

       }
   */
   /*
    public static void move(int n, ArrayList<Integer> src, ArrayList<Integer>aux, ArrayList<Integer>target) {
        if(n==0){
            return;
        }
        move(n-1, src, target, aux);
        target.add(src.remove(src.size()-1 ));
        move(n-1,aux,src,target);
        System.out.println(target);
    }
    */
    public static  ArrayList<Integer> quickAFsort(ArrayList<Integer> quick)
    {
        if(quick.size() <= 1)
        {
            return quick;
        }

        int zenit = quick.get(quick.size()-1);

        ArrayList<Integer> quicklistUnderPivot = new ArrayList<>();
        ArrayList<Integer> quicklistOverAndPivot = new ArrayList<>();

        for (int i = 0; i <= (quick.size() - 1); i++) {
            if (quick.get(i) < zenit) {
                quicklistUnderPivot.add(quick.get(i));
            }
            if (quick.get(i) > zenit) {
                quicklistOverAndPivot.add(quick.get(i));
            }
        }
        quick.clear();
        quick.addAll(quickAFsort(quicklistUnderPivot));
        quick.add(zenit);
        quick.addAll(quickAFsort(quicklistOverAndPivot));
        return quick;
    }


    static ArrayList<Integer> quicker(ArrayList<Integer> quick)
    {
        int zenit = quick.get((quick.size()/2));

        for (int i = 0; i<=quick.size() ; i++)
        {
            if( quick.get(i) < zenit < (quick.size()-i))
            {

            }

        }
    }
}
