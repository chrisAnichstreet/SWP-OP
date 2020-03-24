public class Main {
    public static void main(String[] args ){


        Tachometer tachometer = new Tachometer();
        Display display = new Display();
        tachometer.subscribe(display);

        for(int i = 7990; i<= 8010; i++){
            tachometer.update(i);
        }

    }
}
