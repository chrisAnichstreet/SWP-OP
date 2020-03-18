public class OutputHandler {

    static OutputHandler out;

    OutputHandler(){

    }

    public static OutputHandler getOut(){
        if(out == null){
            out = new OutputHandler();
        }

        return out;
    }


    public void toBinary(int decimal) {

        System.out.println(Integer.toBinaryString(decimal));
    }
}
