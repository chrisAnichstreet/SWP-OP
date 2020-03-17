package at.htlinn.manzl;

public class Build_Consignment implements IState{

    private Context c;

    Build_Consignment(Context c)
    {
        this.c = c;
        work();
    }


    @Override
    public void goNext() {
        c.setState(new Open_Hatch(c));
    }

    @Override
    public void work() {

        System.out.println("Building consignment...");
        c.setStock(c.getProduct_number());
        goNext();

    }
}
