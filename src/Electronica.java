public class Electronica extends Producte{
    int diesDeGarantia;

    //CONSTRUCTOR Electronica
    public Electronica(float preu, String nom, String codiDeBarres, int diesDeGarantia) {
        super(preu, nom, codiDeBarres);
        setDiesDeGarantia(diesDeGarantia);
    }

    public int getDiesDeGarantia() {
        return diesDeGarantia;
    }

    public void setDiesDeGarantia(int diesDeGarantia) {
        this.diesDeGarantia = diesDeGarantia;
    }

    public float getPreu() {
        float preu = super.getPreu();
        return (float) (preu + preu * ( diesDeGarantia / 365) * 0.1);
    }

    @Override
    public String toString() {
        if (getPreu() <= 0){ return String.format("%10s 0€", nom); }
        else { return String.format("%10s %10.2f", nom, getPreu()); }

    }
}
