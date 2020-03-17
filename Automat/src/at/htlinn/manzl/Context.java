package at.htlinn.manzl;

import java.util.ArrayList;

public class Context {

    private IState state;
    private ArrayList<Integer> stock = new ArrayList<Integer>();

    private int product_number;

    /*public Context(){
        setState((IState) new Check_Stock(this));
    }*/

    public Context(){
        stock.add(5);
        stock.add(2);
        stock.add(7);
        stock.add(0);
        state = (IState) new Select_Product(this);
    }

    public void advance()
    {

    }
    public void setState(IState state)
    {
        this.state = state;
    }

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }
    public void setProduct_number() {
        this.product_number = 0;
    }


    public int getStock(int i){

        return stock.get(i);
    }

    //der Stock an der Stelle der Productnumber wird um ein verringert
    public void setStock(int pn){
        stock.set(pn,(stock.get(pn))-1);
    }
}
