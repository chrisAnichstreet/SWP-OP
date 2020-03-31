public class GearBox{

    private IModus modus ;
    private Motor motor;

    public GearBox (Motor motor){
        this.motor = motor;
    }

    public void execute(){
        modus.execute(motor);
    }

    public void changeModus(MODE mode){

        if(mode == MODE.STANDARD){
            this.modus = new Standard_Modus();
        }
        if(mode == MODE.SPORT){
            this.modus = new Sport_Modus();
        }


    }
    public void setVelocity(double velocity){
        motor.setVelocity(velocity);

        execute();
    }
}
