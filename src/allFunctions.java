import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class allFunctions {
    static HashMap<String, Konto> allKontos = new HashMap<String, Konto>();
    static Scanner scanner = new Scanner(System.in);
    public static void kontoErstellen() {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;

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
                konto.setNachname(nachname);

                name = vorname + " " + nachname;

        while (!inputValid) {
            System.out.println("Bitte gebe deinen Startguthaben ein:");
            double startGuthaben;
            try {
                startGuthaben = scanner.nextDouble();
                scanner.nextLine(); // Um das Zeilenumbruchproblem zu vermeiden

                konto.setStartGuthaben(startGuthaben);
                allKontos.put(name, konto);

                inputValid = true; // Wenn alles erfolgreich ist, beende die Schleife
            } catch (InputMismatchException e){
                System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            } catch (Exception ex){
                System.out.println("Fehler: Es ist ein unerwarteter Fehler aufgetreten.");
                ex.printStackTrace(); // Hier kannst du die Fehlerdetails ausgeben, um bei der Fehlerbehebung zu helfen.
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            }//catch
        }//while (!inputValid)

    }//kontoerstellen()

    public static void kontoLöschen() {
        System.out.println("konto löschen");
    }

    public static void kontoListeAusgeben() {
        System.out.println("Liste aller Kontos: ");

        for(Map.Entry e : allKontos.entrySet()){
            Konto currenctKonto = (Konto) e.getValue();
            System.out.println(e.getKey() + " = " + currenctKonto.getStartGuthaben());
        }
        System.out.println("");
        System.out.println("");
    }

    public static void guthabenAusgeben() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guthaben:");

        System.out.println("Bitte gebe deine Kundennumer ein:");
        String Kundennummer = scanner.nextLine();
        Konto konto = allKontos.get(Kundennummer);
        System.out.println(konto.getStartGuthaben());
    }

    public static void auszahlen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Betrag zum auszahlen angeben:");
    }


    public static void einzahlen() {
        System.out.println("einzahlen");
    }

}
