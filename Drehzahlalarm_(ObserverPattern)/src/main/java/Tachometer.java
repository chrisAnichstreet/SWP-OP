import java.util.ArrayList;

public class Tachometer implements IObserver{

    private double rpm;
    private ArrayList<Display> subscribers = new ArrayList<Display>();

    public Tachometer(){

    }


    public void update(double rpm) {
        this.rpm = rpm;
        dispatchInfo();
    }

    public void subscribe(Display display){
        subscribers.add(display);
    }

    public void dispatchInfo(){
        for(Display k : subscribers){
            k.update(rpm);
        }
    }
}
