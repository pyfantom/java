package festival;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Deze klasse beheert de interactie met de gebruiker voor het festival.
 *  * @author Neazy El Taiyeb
 */
public class Festival {

    public static void main(String[] args) {
        /* implementeer hier de verschillende stappen om de gegevens van het festival op te vragen,
         * een object van de klasse Bezoekers aan te maken en
         * de gepaste methode-oproepen te doen naar dit object.
         */
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Voer de naam van het festival in: ");
            String festivalNaam = scanner.nextLine();

            System.out.print("Hoeveel dagen duurt je festival? ");
            int festivalDuur = scanner.nextInt();

            System.out.print("Hoeveel bezoekers kan je per dag ontvangen? ");
            int maxBezoekersPerDag = scanner.nextInt();

            System.out.print("Wanneer zal je festival doorgaan? Geef de startdatum als volgt (jaar-maand-dag): ");
            String startDatumString = scanner.next();
            LocalDate START_FESTIVAL = LocalDate.parse(startDatumString);

            Bezoekers bezoekers = new Bezoekers(START_FESTIVAL, maxBezoekersPerDag, festivalDuur);

            scanner.nextLine();

            System.out.println("Geef je bezoekers in via hun login, gevolgd door de dagen waarvoor ze boeken in volgend formaat:");
            System.out.println("login1 (111 ...), login2 (xx1 ...), ...");
            String bezoekerData = scanner.nextLine();
            String[] bezoekerDataParts = bezoekerData.split(",");

            for (int i = 0; i < bezoekerDataParts.length; i++) {

                String[] person = bezoekerDataParts[i].split("\\(");
                String email = person[0].trim();
                String bookingDays = person[1].replaceAll("[^x1]", "");
                for (int j = 0; j < festivalDuur; j++) {
                    if (bookingDays.charAt(j) == '1') {
                        bezoekers.boekBezoekerDag(email, START_FESTIVAL.plusDays(j));
                    }
                }
            }

            System.out.println("\nBezoekers voor " + festivalNaam + " Festival:\n"); //ok
            System.out.println(bezoekers.geefOverzichtBezoekers());
            System.out.println();
            System.out.println("Bezoekers met een volledig ticket:");
            System.out.println(bezoekers.geefBezoekersFullTicket());
        } catch (InputMismatchException e) {
            System.out.println("Foutieve invoer. Zorg ervoor dat je geldige getallen invoert.");
        } catch (Exception e) {
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }


    }
}
