
import java.util.Scanner;

public class DemoLoopWedstrijd {
    public static void main(String[] args) {
        String[] atleten = {"Peter", "Kristien", "Thomas", "Katja", "Evert-Jan"};
        double[] tijden = {12.5, 14.8, 13.2, 14.5, 12.2};

        // Maak een object van de LoopWedstrijd-klasse aan
        LoopWedstrijd loopWedstrijd = new LoopWedstrijd("OdiseeRun", atleten, tijden);

        // Toon informatie over de wedstrijd
        loopWedstrijd.printWedstrijdInfo();

        // Bepaal en toon de winnaar
        String winnaar = loopWedstrijd.geefWinnaar();
        System.out.println("En het goud gaat naar....: " + winnaar);

        // Vraag gebruiker om nieuwe atleet en tijd, voeg toe en toon nieuwe winnaar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welke atleet wil je toevoegen?\n");
        String nieuweAtleet = scanner.nextLine();
        System.out.print("Welke tijd heeft hij/zij gelopen?\n");
        double nieuweTijd = scanner.nextDouble();

        loopWedstrijd.voegExtraPrestatieToe(nieuweAtleet, nieuweTijd);

        winnaar = loopWedstrijd.geefWinnaar();
        System.out.println("En het goud gaat naar....: " + winnaar);

        scanner.close();
    }
}

