public class Command_Subtraction implements ICommand{

    private Do_Addition add = new Do_Addition();
    private Do_Subtraction sub = new Do_Subtraction();
    private int value;

    public void execute() {
        sub.Subtraction(Invoker.getInvo().result,value);
    }

    public void undo() {
        add.Addition(Invoker.getInvo().result,value);
    }

    public void redo() {
        execute();
    }

    public void setValue(int value) {
        this.value = value;
    }


}
