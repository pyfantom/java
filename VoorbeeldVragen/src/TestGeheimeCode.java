import java.util.Scanner;

public class TestGeheimeCode {
    public static void main(String[] args) {
        int[] geheimeCodeArray = {5, 3, 8, 4, 0};
        GeheimeCode geheimeCode = new GeheimeCode(geheimeCodeArray);

        Scanner scanner = new Scanner(System.in);
        int maxAantalPogingen = 10;

        System.out.println("Welkom bij het Geheime Code-spel!");
        System.out.println("Probeer de code van 5 cijfers te raden.");
        System.out.println("Elke keer krijg je feedback over het aantal juiste cijfers op de juiste positie en hun som.");

        for (int poging = 1; poging <= maxAantalPogingen; poging++) {
            System.out.println("\nPoging " + poging + " van " + maxAantalPogingen);
            System.out.print("Voer je gok in (5 cijfers gescheiden door spaties): ");

            int[] gok = new int[5];
            for (int i = 0; i < gok.length; i++) {
                gok[i] = scanner.nextInt();
            }

            int juistePosities = geheimeCode.telJuistePositie(gok);
            int somJuistePosities = geheimeCode.telSomJuistePositie(gok);

            System.out.println("Aantal juiste cijfers op juiste positie: " + juistePosities);
            System.out.println("Som van juiste cijfers op juiste positie: " + somJuistePosities);

            if (juistePosities == 5) {
                System.out.println("Gefeliciteerd! Je hebt de code geraden!");
                break;
            } else if (poging == maxAantalPogingen) {
                System.out.println("Helaas, je hebt geen pogingen meer.");
                System.out.println("De juiste code was: " + geheimeCodeArray[0] + " " + geheimeCodeArray[1] + " " + geheimeCodeArray[2] + " " + geheimeCodeArray[3] + " " + geheimeCodeArray[4]);
            } else {
                System.out.println("Probeer het opnieuw.");
            }
        }

        scanner.close();
    }
}