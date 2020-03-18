public interface ICommand
{
    void execute();
    void undo();
    void redo();
    void setValue(int value);


}