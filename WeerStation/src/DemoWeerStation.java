import java.util.Scanner;

public class DemoWeerStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welkom, wat wil je doen?\n");
        System.out.println("[D]: Toevoegen van meetwaarden voor een nieuwe dag");
        System.out.println("[A]: Afprinten van de metingen");
        System.out.println("[R]: Weerrapport genereren");
        System.out.println("[S]: Stoppen");

        boolean doorgaan = true;
        while (doorgaan) {
            System.out.print("Keuze: ");
            String keuze = scanner.next().toUpperCase();

            switch (keuze) {
                case "D":
                    // Implementeer [D] optie hier
                    break;
                case "A":
                    // Implementeer [A] optie hier
                    break;
                case "R":
                    // Implementeer [R] optie hier
                    break;
                case "S":
                    doorgaan = false;
                    System.out.println("Programma gestopt.");
                    break;
                default:
                    System.out.println("Ongeldige keuze.");
            }
        }

        scanner.close();
    }
}
