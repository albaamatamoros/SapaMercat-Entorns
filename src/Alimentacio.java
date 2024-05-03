public class Alimentacio extends Producte{
    String dataCaducitat;

    //CONSTRUCTOR Alimentacio
    public Alimentacio(float preu, String nom, String codiDeBarres, String dataCaducitat) {
        super(preu, nom, codiDeBarres);
        this.dataCaducitat = dataCaducitat;
    }
}
