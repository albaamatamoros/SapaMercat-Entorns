public class Textil extends Producte{

    String composicioTextil;

    //CONSTRUCTOR Textil
    public Textil(float preu, String nom, String codiDeBarres, String composicioTextil) {
        super(preu, nom, codiDeBarres);
        setComposicioTextil(composicioTextil);
    }

    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }


}
