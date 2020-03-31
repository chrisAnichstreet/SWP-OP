public class Main {

    public static void  main( String [] args){

        Motor motor = new Motor(0,96, true);
        GearBox gearbox= new GearBox(motor);
        gearbox.changeModus(MODE.STANDARD);
        gearbox.setVelocity(50);
        gearbox.setVelocity(80);
        gearbox.setVelocity(110);
        gearbox.changeModus(MODE.SPORT);
        gearbox.setVelocity(60);
        gearbox.setVelocity(80);
        gearbox.setVelocity(120);
        gearbox.setVelocity(165);
    }
}
