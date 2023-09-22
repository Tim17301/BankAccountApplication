import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        allFunctions allFunctionsClass = new allFunctions();


        boolean end = false;
        while (!end){
            System.out.println("(1) Konto erstellen");
            System.out.println("(2) Konto löschen");
            System.out.println("(3) Liste aller Kontos anzeigen");
            System.out.println("(4) Guthaben abfragen");
            System.out.println("(5) Auszahlen");
            System.out.println("(6) Einzahlen");
            System.out.println("(7) Programm beenden");

            int menuAuswahl = scanner.nextInt();
            switch(menuAuswahl){
                case 1:
                    allFunctionsClass.kontoErstellen();
                    break;
                case 2:
                    allFunctionsClass.kontoLöschen();
                    break;
                case 3:
                    allFunctionsClass.kontoListeAusgeben();
                    break;
                case 4:
                    allFunctionsClass.guthabenAusgeben();
                    break;
                case 5:
                    allFunctionsClass.auszahlen();
                    break;
                case 6:
                    allFunctionsClass.einzahlen();
                    break;
                case 7:
                    end = true;
                    break;
            }  //switch
        } //while


    } //menu

} //Main Klasse
