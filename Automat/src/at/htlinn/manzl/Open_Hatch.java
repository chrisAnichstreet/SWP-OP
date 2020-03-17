package at.htlinn.manzl;

public class Open_Hatch implements IState{
     private Context c;

    Open_Hatch(Context c){
        this.c = c;
        work();
    }

    @Override
    public void goNext() {

        c.setState( new Select_Product(c));
    }

    @Override
    public void work() {

        System.out.println("Your order is ready!\n Have a nice day!\n---------------------------------");

        goNext();
    }
}
