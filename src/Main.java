import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static String opcio;

    public static void main(String[] args) {
        //Cridem el mètode menuInici.
        menuInici();
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
}