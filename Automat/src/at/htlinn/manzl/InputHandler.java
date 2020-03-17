package at.htlinn.manzl;

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

    public int Scan(){

        int num = 0;
        String str = null;
        do {
            try {
                str = obj.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(str.equals(null));

        try{
            num = Integer.parseInt(str);;
        } catch (Exception e){
            e.printStackTrace();

        }

        return num;
    }
}
