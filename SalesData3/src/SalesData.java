import java.util.Arrays;

public class SalesData {
    private static final int MAX_WEKEN = 8; // Maximum aantal weken
    private double[][] sales; // Array voor verkoopcijfers

    public SalesData(int maxWeken) {
        if (maxWeken > MAX_WEKEN) {
            maxWeken = MAX_WEKEN; // Beperk tot maximaal 8 weken
        }
        sales = new double[maxWeken][8]; // Weken x dagen
    }

    public void voegWeekToe(double[] verkoop, int weeknummer) {
        if (weeknummer < 1 || weeknummer > MAX_WEKEN) {
            System.out.println("Ongeldig weeknummer.");
            return;
        }
        int index = weeknummer - 1; // Array-index
        sales[index] = Arrays.copyOf(verkoop, 8); // Voeg verkoopcijfers toe
    }

    public double geefGemiddelde(int weeknummer) {
        int index = weeknummer - 1; // Array-index
        if (index < 0 || index >= sales.length) {
            System.out.println("Ongeldig weeknummer.");
            return 0.0;
        }
        double totaal = 0.0;
        for (double bedrag : sales[index]) {
            totaal += bedrag;
        }
        return totaal / 8; // Gemiddelde over 8 dagen
    }

    public double geefGemiddelde(String dag) {
        int dagIndex = Arrays.asList("maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag").indexOf(dag);
        if (dagIndex == -1) {
            System.out.println("Ongeldige dag.");
            return 0.0;
        }
        double totaal = 0.0;
        int teller = 0;
        for (double[] week : sales) {
            totaal += week[dagIndex];
            if (week[dagIndex] != 0.0) { // Alleen ingevulde dagen
                teller++;
            }
        }
        return totaal / teller; // Gemiddelde over ingevulde weken
    }
}
