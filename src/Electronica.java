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


    @Override
    public String toString() {
        if (getPreu() <= 0){ return String.format("%10s 0€", nom); }
        else { return String.format("%10s %10.2f", nom, getPreu()); }

    }
}
