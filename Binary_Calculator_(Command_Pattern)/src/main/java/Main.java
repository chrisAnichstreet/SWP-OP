import javax.swing.*;

public class Main {

    public static void main (String[] args)
    {
        //Setup:
        System.out.println("Binary Calculator.\n=================\nOnly Enter '0' and '1' als Values.\nPossible Operations are '+' (addition), '-' (subtraction), 'undo' (undo one operation), 'redo' (redo an operation) and '=' to execute an calculation." );



        while(true){

            InputHandler.IHM().Scan();

        }
    }
}
