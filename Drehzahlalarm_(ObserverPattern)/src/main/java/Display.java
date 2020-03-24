public class Display implements IObserver {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public Display (){

    }

    public void update(double rpm)
    {
        if(rpm <0){
            System.out.println("Error");
        }
        if(rpm >= 0 && rpm <=8000){
            System.out.println(ANSI_GREEN+"RPM: "+rpm+ ANSI_RESET);
        }
        if(rpm >=0 && rpm >8000){
            System.out.println(ANSI_RED+"RPM: "+rpm+ANSI_RESET);
        }
    }
}
