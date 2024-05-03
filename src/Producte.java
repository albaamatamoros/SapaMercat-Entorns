public abstract class Producte {

    float preu;
    String nom;
    String codiDeBarres;

    //CONSTRUCTOR Producte
    public Producte(float preu, String nom, String codiDeBarres) {
        this.preu = preu;
        this.nom = nom;
        this.codiDeBarres = codiDeBarres;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodiBarres() {
        return codiDeBarres;
    }

    public void setCodiDeBarres(String codiDeBarres) {
        this.codiDeBarres = codiDeBarres;
    }

    @Override
    public String toString() {
        return "Producte{" +
                "preu=" + preu +
                ", nom='" + nom + '\'' +
                ", codiDeBarres=" + codiDeBarres +
                '}';
    }
}
