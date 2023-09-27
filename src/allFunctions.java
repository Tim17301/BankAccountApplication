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
        Scanner scanner = new Scanner(System.in);
        boolean inputValidKundenummer = false;
        System.out.println("Konto löschen:");

        //Läuft bis man eine richtige Kundennummer eingegeben hat
        while (!inputValidKundenummer){
            System.out.println("Bitte gebe deine Kundennummer ein:");
            String Kundennummer = scanner.nextLine();
            try {
                Konto konto = allKontos.get(Kundennummer);
                allKontos.remove(Kundennummer);

                inputValidKundenummer = true; // Wenn alles erfolgreich ist, beende die Schleife
            } catch (NullPointerException e){
                System.out.println("Fehler: Bitte geben Sie eine gültige Kundennummer ein.");
                //scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            } catch (Exception ex){
                System.out.println("Fehler: Es ist ein unerwarteter Fehler aufgetreten.");
                ex.printStackTrace(); // Hier kannst du die Fehlerdetails ausgeben, um bei der Fehlerbehebung zu helfen.
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            }//catch
        }//while (!inputValidKundenummer)
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
        boolean inputValidKundenummer = false;
        System.out.println("Guthaben:");

        //Läuft bis man eine richtige Kundennummer eingegeben hat
        while (!inputValidKundenummer){
            System.out.println("Bitte gebe deine Kundennummer ein:");
            String Kundennummer = scanner.nextLine();
            try {
                Konto konto = allKontos.get(Kundennummer);
                System.out.println("Ihr aktuelles Guthaben lautet: " + konto.getStartGuthaben());

                inputValidKundenummer = true; // Wenn alles erfolgreich ist, beende die Schleife
            } catch (NullPointerException e){
                System.out.println("Fehler: Bitte geben Sie eine gültige Kundennummer ein.");
                //scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            } catch (Exception ex){
                System.out.println("Fehler: Es ist ein unerwarteter Fehler aufgetreten.");
                ex.printStackTrace(); // Hier kannst du die Fehlerdetails ausgeben, um bei der Fehlerbehebung zu helfen.
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            }//catch
        }//while (!inputValidKundenummer)

    }//guthabenAusgeben()

    public static void auszahlen() {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;
        boolean inputValidKundenummer = false;
        Konto konto = null;

        //Läuft bis man eine richtige Kundennummer eingegeben hat
        while (!inputValidKundenummer){
            System.out.println("Bitte gebe deine Kundennummer ein:");
            String Kundennummer = scanner.nextLine();
            try {
                konto = allKontos.get(Kundennummer);

                inputValidKundenummer = true; // Wenn alles erfolgreich ist, beende die Schleife
            } catch (NullPointerException e){
                System.out.println("Fehler: Bitte geben Sie eine gültige Kundennummer ein.");
                //scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            } catch (Exception ex){
                System.out.println("Fehler: Es ist ein unerwarteter Fehler aufgetreten.");
                ex.printStackTrace(); // Hier kannst du die Fehlerdetails ausgeben, um bei der Fehlerbehebung zu helfen.
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            }//catch
        }//while (!inputValidKundenummer)

        while (!inputValid){
            double aktuellesGuthaben = konto.getStartGuthaben();
            System.out.println("Betrag zum auszahlen angeben:");
            try {
                double auszahlBetrag = scanner.nextDouble();
                konto.setStartGuthaben(aktuellesGuthaben - auszahlBetrag);
                System.out.println("Abhebung erfolgreich!");
                System.out.println("Ihr neuer Kontostand lautet: " + konto.getStartGuthaben());

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
    }//auszahlen()


    public static void einzahlen() {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;
        boolean inputValidKundenummer = false;
        Konto konto = null;

        //Läuft bis man eine richtige Kundennummer eingegeben hat
        while (!inputValidKundenummer){
            System.out.println("Bitte gebe deine Kundennummer ein:");
            String Kundennummer = scanner.nextLine();
            try {
                konto = allKontos.get(Kundennummer);

                inputValidKundenummer = true; // Wenn alles erfolgreich ist, beende die Schleife
            } catch (NullPointerException e){
                System.out.println("Fehler: Bitte geben Sie eine gültige Kundennummer ein.");
                //scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            } catch (Exception ex){
                System.out.println("Fehler: Es ist ein unerwarteter Fehler aufgetreten.");
                ex.printStackTrace(); // Hier kannst du die Fehlerdetails ausgeben, um bei der Fehlerbehebung zu helfen.
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            }//catch
        }//while (!inputValidKundenummer)

        while (!inputValid){
            double aktuellesGuthaben = konto.getStartGuthaben();
            System.out.println("Betrag zum einzahlen angeben:");
            try {
                double einzahlBetrag = scanner.nextDouble();
                konto.setStartGuthaben(aktuellesGuthaben + einzahlBetrag);
                System.out.println("Einzahlung erfolgreich!");
                System.out.println("Ihr neuer Kontostand lautet: " + konto.getStartGuthaben());

                inputValid = true; // Wenn alles erfolgreich ist, beende die Schleife
            } catch (InputMismatchException e){
                System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            } catch (Exception ex){
                System.out.println("Fehler: Es ist ein unerwarteter Fehler aufgetreten.");
                ex.printStackTrace(); // Die Fehlerdetails ausgeben, um bei der Fehlerbehebung zu helfen.
                scanner.nextLine(); //Fehlerhafte Eingabe verwerfen
            }//catch
        }//while (!inputValid)
    }//einzahlen()

}//allFunctions Klasse
