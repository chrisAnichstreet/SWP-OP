public class Motor {

    private double velocity;
    private double KW_Wert;
    private boolean Turbo;

    public Motor (double velocity, double KW_Wert, boolean Turbo)
    {
        this.velocity = velocity;
        this.KW_Wert = KW_Wert;
        this.Turbo = Turbo;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getKW_Wert() {
        return KW_Wert;
    }

    public void setKW_Wert(double KW_Wert) {
        this.KW_Wert = KW_Wert;
    }

    public boolean isTurbo() {
        return Turbo;
    }

    public void setTurbo(boolean turbo) {
        Turbo = turbo;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
}urb
