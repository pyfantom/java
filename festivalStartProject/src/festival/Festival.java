package festival;

import java.time.LocalDate;
import java.util.Scanner;

public class Festival {
    public static void main(String[] args) {
        /* implementeer hier de verschillende stappen om de gegevens van het festival op te vragen,
         * een object van de klasse Bezoekers aan te maken en
         * de gepaste methode-oproepen te doen naar dit object.
        */
        Scanner scanner = new Scanner(System.in);
        // اسم الاحتفال
        System.out.print("Voer de naam van het festival in: ");
        String festivalNaam = scanner.nextLine();
        //String festivalNaam = "djdjj";
        // عدد الايام
        System.out.print("Hoeveel dagen duurt je festival? ");
        int festivalDuur = scanner.nextInt();
        //int festivalDuur = 2;
        // اقصى عدد للزوار
        System.out.print("Hoeveel bezoekers kan je per dag ontvangen? ");
        int maxBezoekersPerDag = scanner.nextInt();
        //int maxBezoekersPerDag = 2;
        // حدد اول ايام الاحتفال
        System.out.print("Wanneer zal je festival doorgaan? Geef de startdatum als volgt (jaar-maand-dag): ");
        String startDatumString = scanner.next();
        //String startDatumString = "2023-01-01";
        LocalDate startDatum = LocalDate.parse(startDatumString);

        Bezoekers bezoekers = new Bezoekers(startDatum, maxBezoekersPerDag, festivalDuur);

        scanner.nextLine(); // consuming the remaining newline

        System.out
                .println("Geef je bezoekers in via hun login, gevolgd door de dagen waarvoor ze boeken in volgend formaat:");
        System.out.println("login1 (111 ...), login2 (xx1 ...), ...");
        String bezoekerData = scanner.nextLine();
        //String bezoekerData = "sfwan (1x),altaieb (11)";
        String[] bezoekerDataParts = bezoekerData.split(","); // Split only the first space

        for (int i = 0; i < bezoekerDataParts.length; i++) {
            String[] person = bezoekerDataParts[i].split(" ");
            String email = person[0];
            String bookingDays = person[1].replaceAll("[^x1]", ""); // Extract 'x' and '1' characters
            for (int j = 0; j < festivalDuur; j++) {
                if (bookingDays.charAt(j) == '1') {
                    bezoekers.boekBezoekerDag(email, j, true);
                }
            }
        }

        System.out.println("\nBezoekers voor " + festivalNaam + " Festival:\n");
        for (int i = 0; i < festivalDuur; i++) {
            LocalDate dag = startDatum.plusDays(i);
        }
        System.out.println("\nBezoekers voor deze dag: \n" + bezoekers.geefBezoekersVoorDag());
        System.out.println();
        System.out.println("Bezoekers met een volledig ticket:");
        System.out.println(bezoekers.geefBezoekersVolledigTicket());


    }
}
