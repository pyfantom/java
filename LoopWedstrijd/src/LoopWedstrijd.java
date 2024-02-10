public class LoopWedstrijd {
    private String naam;
    private String[] atleten;
    private double[] tijden;

    public LoopWedstrijd(String naam, String[] atleten, double[] tijden) {
        this.naam = naam;
        this.atleten = atleten;
        this.tijden = tijden;
    }

    public String geefWinnaar() {
        int indexWinnaar = 0;
        double besteTijd = tijden[0];

        // Zoek de index van de atleet met de beste tijd
        for (int i = 1; i < tijden.length; i++) {
            if (tijden[i] < besteTijd) {
                indexWinnaar = i;
                besteTijd = tijden[i];
            }
        }

        return atleten[indexWinnaar];
    }

    public void voegExtraPrestatieToe(String atleet, double tijd) {
        // Controleer of de atleet al bestaat
        for (String bestaandeAtleet : atleten) {
            if (bestaandeAtleet.equals(atleet)) {
                System.out.println("Deze atleet bestaat al.");
                return;
            }
        }

        // Voeg de nieuwe atleet en tijd toe
        String[] nieuweAtleten = Arrays.copyOf(atleten, atleten.length + 1);
        nieuweAtleten[nieuweAtleten.length - 1] = atleet;

        double[] nieuweTijden = Arrays.copyOf(tijden, tijden.length + 1);
        nieuweTijden[nieuweTijden.length - 1] = tijd;

        atleten = nieuweAtleten;
        tijden = nieuweTijden;

        System.out.println("Nieuwe atleet toegevoegd: " + atleet);
    }

    public void printWedstrijdInfo() {
        System.out.println("Gegevens van loopwedstrijd: " + naam);
        System.out.println("Deelnemers:");
        for (String atleet : atleten) {
            System.out.print(atleet + " ");
        }
        System.out.println("\nTijden:");
        for (double tijd : tijden) {
            System.out.print(tijd + " ");
        }
        System.out.println();
    }
}
