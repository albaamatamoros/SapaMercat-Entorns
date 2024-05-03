public class Electronica extends Producte{

    int diesDeGarantia;

    //CONSTRUCTOR Electronica
    public Electronica(float preu, String nom, String codiDeBarres, int diesDeGarantia) {
        super(preu, nom, codiDeBarres);
        this.diesDeGarantia = diesDeGarantia;
    }

}
