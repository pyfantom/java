import java.util.Scanner;


public class DemoMeetGegevens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] meetwaarden = new int[20];

        System.out.println("Voer 20 positieve gehele meetwaarden in:");

        for (int i = 0; i < meetwaarden.length; i++) {
            System.out.print("Meetwaarde " + (i + 1) + ": ");
            meetwaarden[i] = scanner.nextInt();
        }

        MeetGegevens meetGegevens = new MeetGegevens(meetwaarden);

        if (meetGegevens.zijnAlleElementenOnderlingVerschillend()) {
            int kleinsteVerschil = meetGegevens.bepaalKleinstePositiefVerschil();
            if (kleinsteVerschil != -1) {
                System.out.println("Alle meetwaarden zijn onderling verschillend.");
                System.out.println("Het kleinste positieve verschil tussen twee meetwaarden is: " + kleinsteVerschil);
            } else {
                System.out.println("Er zijn niet genoeg meetwaarden om een verschil te bepalen.");
            }
        } else {
            System.out.println("Niet alle meetwaarden zijn onderling verschillend.");
        }

        scanner.close();
    }
}

