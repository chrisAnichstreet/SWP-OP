package at.htlinn.manzl;

public class Error implements IState{

    Context c;

    Error(Context c) {

        this.c = c;
        work();
    }

    @Override
    public void goNext() {
        c.setState( new Select_Product(c));
    }

    @Override
    public void work() {

        goNext();

    }
}
