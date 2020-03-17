package at.htlinn.manzl;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Select_Product implements IState {


    private Context c;

    public Select_Product(Context c)
    {
        this.c = c;
        c.setProduct_number();
        work();
    }

    public void goNext()
    {
        c.setState(new Check_Stock(c));
    }

    @Override
    public void work(){
        System.out.println("Select a Product:");
        c.setProduct_number(InputHandler.IHM().Scan());
        goNext();
    }
}
