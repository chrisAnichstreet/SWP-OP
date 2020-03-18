public class Do_Subtraction {

    public Do_Subtraction(){

    }

    public void Subtraction(int result, int value) {

        result= result-value;
        Invoker.getInvo().setResult(result);
        OutputHandler.getOut().toBinary(result);
    }
}
