
import java.util.ArrayList;


public class Invoker {
    //History of Commands
    ArrayList<ICommand> commands = new ArrayList<ICommand>();
    //Index des letzten Kommandos 0 bedeutet aktuell, 1 bedeutet der letzte, 2 der vorletzte etc.
    int comlevel = 0;


    //Das ergebnis der Aller letzten Rechnung
    int result = 0;

    static Invoker invo;

    //TODO numOne ist immer das Ergebnis der Letzten rechnung (also wenn nach dem Ergebnis sofort ein Operator angegeben wird) Falls eine Zahl angegeben wird ist das sofort numOne.
    private int numOne;
    private int numTwo;

    Invoker() {
    }

    public void addCommand(ICommand command)
    {
        if(comlevel!=0){
            for(int i = Math.abs(comlevel); i>0; i--)
            {
                commands.remove(commands.size()-i);
            }
            comlevel = 0;
        }
        commands.add(command);
    }

    public void undoCommand()
    {
        try {
            commands.get(commands.size() - comlevel-1).undo();
            comlevel++;
        }catch(Exception e){
            System.out.println("No further operations to undo!");
            e.printStackTrace();
        }
    }

    public void redoCommand()
    {
        if(comlevel!=0) {
            try {
                commands.get(commands.size() - comlevel - 1).redo();
                comlevel--;
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        else{
            System.out.println("No further operations to redo!");
        }
    }

    public ICommand getCommand(){
        return commands.get(commands.size()-1);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }



    public static Invoker getInvo()
    {
        if(invo== null){
            invo = new Invoker();
        }
        return invo;
    }
}
