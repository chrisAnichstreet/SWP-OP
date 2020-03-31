public class Standard_Modus implements IModus {
    private double gearvalue;

    public Standard_Modus (){}

    public void execute(Motor motor) {

        if(motor.isTurbo()){
           gearvalue = Math.floor(((motor.getVelocity() / (1.1 * motor.getKW_Wert()))*10)/2); //"Größerer" Hubraum -> Höhere Leistung -> etwas später Schalten (immer noch früh), Sprit Sparen

        }
        gearvalue = Math.floor(((motor.getVelocity() / (0.8 * motor.getKW_Wert()))*10)/2); //Geringere Leistung -> Früher Schalten -> Sprit sparen

        printGears();
    }


    public void printGears() {

        System.out.println("Selected Mode:"+"\u001B[32m"+ " STANDARD"+"\u001B[0m"+"  GEAR: "+"\u001B[34m"+gearvalue+"\u001B[0m");

    }

}
