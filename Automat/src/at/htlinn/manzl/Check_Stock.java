package at.htlinn.manzl;


import java.io.IOException;
import java.util.ArrayList;

public class Check_Stock implements IState {



    Context c;
    public Check_Stock(Context context){
        this.c = context;
        work();
    }


    public void goNext(Boolean decide){

        if(decide){
            c.setState(new Check_Employee(c));
        }
        else {
            c.setState(new Error(c));
        }
    }

    @Override
    public void goNext() {

    }

    @Override
    public void work(){

        try{
            if ((c.getStock(c.getProduct_number())) >= 1) {

                goNext(true);
            }
            else{
                System.out.println("Selected Product is out of stock.");
                goNext(false);
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("Selected Product does not exist.");
            goNext(false);
        }

    }
}
