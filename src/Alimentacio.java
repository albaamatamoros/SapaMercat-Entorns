import java.util.Date;

public class Alimentacio extends Producte{
    String dataCaducitat;

    //CONSTRUCTOR Alimentacio
    public Alimentacio(float preu, String nom, String codiDeBarres, String dataCaducitat) {
        super(preu, nom, codiDeBarres);
        setDataCaducitat(dataCaducitat);
    }

    public String getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(String dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    //Calculem el preu segons la data de caducitat.
    public float getPreu() {
        float preu = super.getPreu();
        //Creem un objecte Date que guarda la data i hora actual.
        Date data = new Date(System.currentTimeMillis());
        Date dataCad = new Date(dataCaducitat);

        //Fem un càlcul però obtenir la diferència de dies entre dues dates.
        int dias = (int) ((dataCad.getTime() - data.getTime()));

        //Retornem el nou preu del producte basant-nos en els dies que li queden per caducar.
        return (float) (preu - preu*(1 /(dias+1)) - (preu * 0.1));
    }

    @Override
    public String toString() {
        if (getPreu() <= 0){ return String.format("%10s 0€", nom); }
        else { return String.format("%10s %10.2f", nom, getPreu()); }

    }
}
