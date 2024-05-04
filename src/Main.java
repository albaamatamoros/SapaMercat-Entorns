import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    //ARRAYLIST i HASHMAP
    static ArrayList<Producte> productes = new ArrayList<>();
    static ArrayList<Producte> prodTextil = new ArrayList<>();
    //VARIABLES GLOBALS
    static String opcio;
    private static final int MAX_CARRO = 100;
    private static final int MAX_LLARG = 15;
    public static void main(String[] args) {
        //Cridem el mètode crearCarpetasIFitxers per crear les carpetes.
        crearCarpetesIFitxers();
        //Cridem el mètode menuInici.
        menuInici();
    }

    //CREACIÓ CARPETAS I FITXERS:
    public static void crearCarpetesIFitxers(){
        File dir1 = new File("./updates");
        File dir2 = new File("./logs");
        File dat1 = new File("./updates/UpdateTextilPrices.dat");
        File dat2 = new File("./logs/Exceptions.dat");
        try {
            boolean created = dir1.mkdirs();
            if (created) {
                System.out.println("updates creat correctament");
            } else { //Si created = false significa que el directory ja a sigut creat, sino saltaria una excepció.
                System.out.println("updates ja exsisteix");
            }
            boolean created2 = dir2.mkdirs();
            if (created2) {
                System.out.println("logs creat correctament\n");
            } else { //Si created = false significa que el directory ja a sigut creat, sino saltaria una excepció.
                System.out.println("logs ja exsisteix\n");
            }
            boolean created3 = dat1.createNewFile();
            if (created3){
                System.out.println("UpdateTextilPrices.dat creat correctament");
            } else {
                System.out.println("UpdateTextilPrices.dat ja exsisteix");
            }
            boolean created4 = dat2.createNewFile();
            if (created4){
                System.out.println("Exceptions.dat creat correctament\n");
            } else {
                System.out.println("Exceptions.dat ja exsisteix\n");
            }
        } catch (Exception e) {
            System.out.println("Les carpetes/fitxers no s'han pogut crear correctament");
            logException(e);
        }
    }

    //MENÚ INICI:
    public static void menuInici(){
        //Menú INICI
        do {
            System.out.println("BENVINGUT AL SAPAMERCAT");
            System.out.println("------------");
            System.out.println("-- INICI ---");
            System.out.println("------------");
            System.out.println("1) Introduir producte");
            System.out.println("2) Passar per caixa");
            System.out.println("3) Mostrar carret de compra");
            System.out.println("4) Cercar producte");
            System.out.println("0) Acabar");
            opcio = scan.nextLine();
            switch (opcio) {
                case "1":
                    //Mostrem el menú de productes
                    introduirProducte();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    break;
                default:
                    System.out.println("-------------------------------");
                    System.out.println("ATENCIÓ! Ha de ser entre 0 i 3");
                    System.out.println("-------------------------------");
            }
        } while (!(opcio.equals("0")));
    }

    public static void introduirProducte(){
        //MENÚ PRODUCTE:
        do {
            System.out.println("BENVINGUT AL SAPAMERCAT");
            System.out.println("---------------");
            System.out.println("-- PRODUCTE ---");
            System.out.println("---------------");
            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electrònica");
            System.out.println("0) Tornar");
            opcio = scan.nextLine();
            switch (opcio) {
                case "1":
                    afegirProducteAlimentacio();
                    break;
                case "2":
                    afegirProducteTextil();
                    break;
                case "3":
                    afegirProducteElectronica();
                    break;
                case "0":
                    menuInici();
                    break;
                default:
                    System.out.println("-------------------------------");
                    System.out.println("ATENCIÓ! Ha de ser entre 0 i 3");
                    System.out.println("-------------------------------");
            }
        } while (!(opcio.equals("0")));
    }

    //AFEGIR PRODUCTES:
    //Mètode per afegir un producte alimentacio.
    private static void afegirProducteAlimentacio(){
        String nom;
        float preu;
        String dataCaducitat;
        String codiBarres;
        try {
            //Fem un if per comprovar que al carro no entrin més de 100 productes.
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un aliment al carro:
                System.out.println("Afegir aliment");

                System.out.print("Nom producte (15 dígits MAX): ");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters ni pot estar buit.
                if (nom.length() > MAX_LLARG || nom.isEmpty()) throw new Exception("El nom del producte no pot ser superior a 15 ni pot estar buit");

                System.out.print("preu (,): ");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Codi de barres (4 dígits): ");
                codiBarres = scan.nextLine();

                if (!codiBarres.matches("\\d{4}")) throw new IllegalArgumentException("El codi de barres ha de ser de 4 digits i només pot contenir números");

                System.out.print("Data de caducitat (dd/MM/yyyy): ");
                dataCaducitat = scan.nextLine();

                //Cridem el mètode correctData per verificar el format de dataCaducita.
                Alimentacio.correctData(dataCaducitat);

                //Creem l'objecte Alimentació i el fiquem a l'arraylist productes.
                productes.add(new Alimentacio(preu, nom, codiBarres, dataCaducitat));
            }
        } catch (ParseException e) {
            System.out.println("El format de data de caducitat no és correcte");
            logException(e);
        } catch (InputMismatchException e) {
            System.out.println("Les dades introduïdes no són del tipus de dades demanades");
            logException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }
    private static void afegirProducteTextil(){
        String nom;
        float preu;
        String composicio;
        String codiBarres;
        try {
            //Fem un if per comprovar que al carro no entrin més de 100 productes.
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un tèxtil al carro:
                System.out.println("Afegir tèxtil");

                System.out.print("Nom producte (15 dígits MAX): ");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG || nom.isEmpty()) throw new Exception("El nom del producte no pot ser superior a 15 ni pot estar buit");

                System.out.print("preu (,): ");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Composició: ");
                composicio = scan.nextLine();

                if (!composicio.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("La composició no pot contenir números només lletres");

                System.out.print("Codi de barres (4 dígits): ");
                codiBarres = scan.nextLine();

                if (!codiBarres.matches("\\d{4}")) throw new IllegalArgumentException("El codi de barres ha de ser de 4 digits i només pot contenir números");

                //Comprovem que no es repeteixin dos prod tèxtil iguals.
                if (textilRepetit(codiBarres)){
                    System.out.println("No es pot repetir el codi de barres d'un producte textil");
                } else {
                    //Creem l'objecte Textil i el fiquem a l'arraylist productes.
                    productes.add(new Textil(preu, nom, codiBarres, composicio));
                    //Creem l'objecte Textil i el fiquem a l'arraylist prodTextil productes.
                    prodTextil.add(new Textil(preu, nom, codiBarres, composicio));
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Les dades introduïdes no són del tipus de dades demanades");
            logException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }
    private static void afegirProducteElectronica(){
        String nom;
        float preu;
        int garantia;
        String codiBarres;

        try {
            //Fem un if per comprovar que al carro no entrin més de 100 productes.
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un electrònica al carro:
                System.out.println("Afegir electrònica");

                System.out.print("Nom producte (15 dígits MAX): ");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG || nom.isEmpty()) throw new Exception("El nom del producte no pot ser superior a 15 ni pot estar buit");

                System.out.print("preu (,): ");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Garantia (dies): ");
                garantia = scan.nextInt();
                scan.nextLine();

                System.out.print("Codi de barres (4 dígits): ");
                codiBarres = scan.nextLine();

                if (!codiBarres.matches("\\d{4}")) throw new IllegalArgumentException("El codi de barres ha de ser de 4 digits i només pot contenir números");

                //Creem l'objecte Electronica i el fiquem a l'arraylist productes.
                productes.add(new Electronica(preu, nom, codiBarres, garantia));
            }
        }catch (InputMismatchException e) {
            System.out.println("Les dades introduïdes no són del tipus de dades demanades");
            logException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }

    //TEXTIL REPETIT:
    //Comprovem que el producte textil no estigui repetit.
    public static boolean textilRepetit(String codi){
        boolean repetit = false;
        for (Producte p : prodTextil){
            if (p.getCodiBarres().matches(codi)){
                repetit = true;
                break;
            }
        }
        return repetit;
    }

    //FITXER EXCEPTION:
    //Mètode per guardar excepcions en un fitxer .dat
    public static void logException(Exception e) {
        try {
            //Creem el fitxer on es registraran totes les excepcions.
            File fitxer = new File("./logs/Exceptions.dat");
            //Donem l'arxiu i el valor "true", aquest ultim és un indicador perquè afegeixi les dades al final de l'arxiu.
            FileOutputStream file = new FileOutputStream(fitxer, true);
            PrintStream writer = new PrintStream(file);

            //Agafem la data amb l'hora i tots els detalls possibles perquè quedi constància de quan va succeir aquest excepció.
            Date data = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");


            //Escrivim al fitxer totes les excepcions.
            writer.println("Excepció : " + simpleDateFormat.format(data) + " " + " : " + e.getMessage());
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("- No es troba el fitxer");
            logException(e);
        } catch (Exception ex){
            System.out.println("- No s'ha pogut escriure al fitxer");
            logException(e);
        }
    }
}