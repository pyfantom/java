
package festival;
import java.time.LocalDate;
import java.util.Scanner;

public class Festival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer de naam van het festival in: ");
        String festivalNaam = scanner.nextLine();

        System.out.print("Hoeveel dagen duurt je festival? ");
        int festivalDuur = scanner.nextInt();

        System.out.print("Hoeveel bezoekers kan je per dag ontvangen? ");
        int maxBezoekersPerDag = scanner.nextInt();

        System.out.print("Wanneer zal je festival doorgaan? Geef de startdatum als volgt (jaar-maand-dag): ");
        String startDatumString = scanner.next();
        LocalDate startDatum = LocalDate.parse(startDatumString);

        Bezoekers bezoekers = new Bezoekers(startDatum, maxBezoekersPerDag, festivalDuur);

        scanner.nextLine(); // consuming the remaining newline

        System.out.println("Geef je bezoekers in via hun login, gevolgd door de dagen waarvoor ze boeken in volgend formaat:");
        System.out.println("login1 (111), login2 (x1x), login3 (xx1), ...");

      
            String bezoekerData = scanner.nextLine();
            String[] bezoekerDataParts = bezoekerData.split(" ");

            String email = bezoekerDataParts[0];
            for (int j = 0; j < festivalDuur; j++) {
                if (bezoekerDataParts[1].charAt(j) == '1') {
                    bezoekers.boekBezoekerDag(email, startDatum.plusDays(j));
                }
            }
        }

        System.out.println("\nBezoekers voor " + festivalNaam + " Festival:\n");
        for (int i = 0; i < festivalDuur; i++) {
            LocalDate dag = startDatum.plusDays(i);
            System.out.println(dag + "\nBezoekers voor deze dag: " + bezoekers.geefBezoekersVoorDag());
            System.out.println();
        }

        System.out.println("Bezoekers met een volledig ticket:");
        System.out.println(bezoekers.geefBezoekersVolledigTicket());
    }
}