package at.htlinn.manzl;

import java.util.ArrayList;

public class Check_Employee implements IState {
    private Context c;
    private ArrayList<Integer> employees = new ArrayList<>();


    Check_Employee (Context context){
        this.c = context;
        for(int i =0; i<=50;i++){
        employees.add(i);

        }
        work();
    }



    public void goNext(Boolean decide) {

        if(decide){
        c.setState(new Build_Consignment(c));
        }
        else{
            c.setState(new Error(c));
        }
    }

    @Override
    public void goNext() {

    }

    @Override
    public void work() {

        System.out.println("Please enter your Identification number:");

        int emp_no = InputHandler.IHM().Scan();

        for(int k:employees){
            if(k == emp_no)
            {
                goNext(true);
            }
        }

        System.out.println("This employee number does not exist.");
        goNext(false);

    }
}
