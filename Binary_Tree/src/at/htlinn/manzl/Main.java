package at.htlinn.manzl;

public class Main {

    public static void main(String[] args) {

    pulls tree = new pulls();
    tree.add(4);
    tree.add(17);
    tree.add(8);
    tree.add(9);
    tree.add(10);
    tree.add(12);
    tree.add(11);
    tree.add(2);

    System.out.println("Jetz Zeige die Eingaben !");
    //System.out.println(tree.Get(1));
    System.out.println(tree.Get(17));
        System.out.println(tree.Get(8));
    System.out.println(tree.Get(9));
        System.out.println(tree.Get(10));
        System.out.println(tree.Get(12));
        System.out.println(tree.Get(11));
        System.out.println(tree.Get(2));

        tree.Delete(17);


        System.out.println("Jetz Sollte 17 Gelöscht sein ! (Sollte)");
        System.out.println(tree.Get(17));
        System.out.println(tree.Get(8));
        System.out.println(tree.Get(9));
        System.out.println(tree.Get(10));
        System.out.println(tree.Get(12));
        System.out.println(tree.Get(11));
        System.out.println(tree.Get(2));


    }



}
