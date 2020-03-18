//Receiver One
public class Do_Addition {

    public Do_Addition()
    {

    }

    public void Addition(int result, int value)
    {
       result= result+value;
       Invoker.getInvo().setResult(result);
       OutputHandler.getOut().toBinary(result);
    }

}
