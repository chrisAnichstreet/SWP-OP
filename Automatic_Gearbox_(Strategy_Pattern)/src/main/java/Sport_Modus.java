public class Sport_Modus implements IModus {

    private double gearvalue;
    void Sport_Modus (){}

    public void execute(Motor motor) {
        if(motor.isTurbo()){
            gearvalue = Math.floor(((motor.getVelocity() / (1.6 * motor.getKW_Wert()))*10)/2); //"Größerer" Hubraum -> Höhere Leistung -> noch später Schalten , Hohe Drehzahlen

        }
        gearvalue = Math.floor(((motor.getVelocity() / (1.3 * motor.getKW_Wert()))*10)/2); //Geringere Leistung -> Spät Schalten -> Hohe Drehzahl

        printGears();

    }

    public void printGears() {

        System.out.println("Selected Mode:"+"\u001B[31m"+" SPORT"+"\u001B[0m"+"     GEAR: "+"\u001B[34m"+gearvalue+"\u001B[0m");

    }
}
