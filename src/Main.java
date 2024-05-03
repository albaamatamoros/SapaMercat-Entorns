import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
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
    private static void afegirProducteAlimentacio(){}
    private static void afegirProducteTextil(){}
    private static void afegirProducteElectronica(){}

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