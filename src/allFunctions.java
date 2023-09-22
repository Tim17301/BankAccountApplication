import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class allFunctions {
    static HashMap<String, Konto> allKontos = new HashMap<String, Konto>();
    static Scanner scanner = new Scanner(System.in);
    public static void kontoErstellen() {
        System.out.println("Konto erstellen:");
        System.out.println("");

        Konto konto = new Konto();

        String name;
        String vorname;
        String nachname;
        System.out.println("Bitte gebe deinen Vornamen ein:");
        vorname = scanner.nextLine();
        konto.setVorname(vorname);

        System.out.println("Bitte gebe deinen Nachnamen ein:");
        nachname = scanner.nextLine();
        konto.setVorname(nachname);

        name = vorname + " " + nachname;

        System.out.println("Bitte gebe deinen Startguthaben ein:");
        konto.setStartGuthaben(scanner.nextDouble());
        scanner.nextLine();

        allKontos.put(name, konto);
    }

    public static void kontoLöschen() {
        System.out.println("konto löschen");
    }

    public static void kontoListeAusgeben() {
        System.out.println("Liste aller Kontos: ");

        for(Map.Entry e : allKontos.entrySet()){
            Konto currenctKonto = (Konto) e.getValue();
            System.out.println(e.getKey() + " = " + currenctKonto.getStartGuthaben());
        }
    }

    public static void guthabenAusgeben() {
        System.out.println("guthaben ausgeben");
    }

    public static void auszahlen() {
        System.out.println("auszahlen");
    }


    public static void einzahlen() {
        System.out.println("einzahlen");
    }

    public static void programmBeenden() {
        System.out.println("beenden");
    }
}
