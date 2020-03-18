

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {

    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

    private static InputHandler ih = null;

    InputHandler()
    {

    }

    public static  InputHandler IHM(){

        if(ih ==null){
            ih = new InputHandler();
        }

        return ih;
    }

    public void Scan(){

        int num =9;
        String str = null;
        do {
            try {
                str = obj.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(str.equals(null));



        if(str.equals("+")){

            Invoker.getInvo().addCommand(new Command_Addition());
        }

        if(str.equals("-")){
            Invoker.getInvo().addCommand(new Command_Subtraction());
        }

        if(str.equals("=")){
            Invoker.getInvo().getCommand().execute();
        }

        if(str.equals("redo")){
            Invoker.getInvo().redoCommand();
        }

        if(str.equals("undo")){
            Invoker.getInvo().undoCommand();
        }

        if(str.equals("clear")){
            Invoker.getInvo().setResult(0);
        }

        if( StringUtils.isNumeric(str)){
            ToInt(str);
        }
    }

    private void ToInt(String str)
    {
        int binary ;
        int decimal = 0;
        if(str.contains("2") || str.contains("3") || str.contains("4") || str.contains("5") || str.contains("6") || str.contains("7") || str.contains("8") || str.contains("9"))
        {
            System.out.println("Values entered must only contatin Zeros and Ones! "+str+" is not an binary number.");
            return;
        }


        try{
            decimal=Integer.parseInt(str,2);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            Invoker.getInvo().getCommand().setValue(decimal);
        }catch(Exception e){
            System.out.println("A Operation must me set bevor an Value is entered.");
        }
    }
}
