public class Command_Addition implements ICommand {
    private Do_Addition add = new Do_Addition();
    private Do_Subtraction sub = new Do_Subtraction();
    private int value;

    public Command_Addition() {

    }

    public void execute() {
        add.Addition(Invoker.getInvo().getResult(),value);
    }

    public void undo() {
        sub.Subtraction(Invoker.getInvo().getResult(),value);
    }

    public void redo() {
        execute();
    }

    public void setValue(int value) {
        this.value = value;
    }
}
