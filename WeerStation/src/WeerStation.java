import java.text.DecimalFormat;

public class WeerStation {
    private String[][] meetwaarden;
    private static final int AANTAL_DAGEN = 31;
    private static final int AANTAL_METINGEN = 4;
    private static final DecimalFormat DF = new DecimalFormat("0.00");

    public String WeerStation(String maand, int jaar) {
        meetwaarden = new String[AANTAL_DAGEN][AANTAL_METINGEN + 1];
        for (int i = 0; i < AANTAL_DAGEN; i++) {
            meetwaarden[i][0] = Integer.toString(i + 1);
        }
        System.out.println("Weerstation voor " + maand + " " + jaar + " is aangemaakt.");
    }

    public void voegDagToe(int dag, int[] waarden) {
        if (dag < 1 || dag > AANTAL_DAGEN) {
            System.out.println("Ongeldige dag.");
            return;
        }
        for (int i = 0; i < AANTAL_METINGEN; i++) {
            meetwaarden[dag - 1][i + 1] = Integer.toString(waarden[i]);
        }
        System.out.println("Meetwaarden toegevoegd voor dag " + dag);
    }

    public String geefOverzichtMeetwaarden() {
        StringBuilder overzicht = new StringBuilder();
        overzicht.append("Gegevens voor de maand:\n");
        overzicht.append("Dag Temp Lucht Neerslagkans Windsterkte\n");
        overzicht.append("---------------------------------------\n");
        for (int i = 0; i < AANTAL_DAGEN; i++) {
            if (meetwaarden[i][1] != null) {
                for (int j = 0; j < AANTAL_METINGEN + 1; j++) {
                    overzicht.append(meetwaarden[i][j] != null ? meetwaarden[i][j] + " " : "0 ");
                }
                overzicht.append("\n");
            }
        }
        return overzicht.toString();
    }

    public double[] berekenGemiddelden() {
        double[] gemiddelden = new double[AANTAL_METINGEN];
        for (int j = 1; j <= AANTAL_METINGEN; j++) {
            double totaal = 0.0;
            int teller = 0;
            for (int i = 0; i < AANTAL_DAGEN; i++) {
                if (meetwaarden[i][j] != null) {
                    totaal += Double.parseDouble(meetwaarden[i][j]);
                    teller++;
                }
            }
            gemiddelden[j - 1] = totaal / teller;
        }
        return gemiddelden;
    }

    public boolean bevatKoudeGolf() {
        for (int i = 0; i <= AANTAL_DAGEN - 5; i++) {
            int koudegolfTeller = 0;
            for (int j = i; j < i + 5; j++) {
                if (meetwaarden[j][1] != null && Integer.parseInt(meetwaarden[j][1]) < 0) {
                    koudegolfTeller++;
                }
            }
            if (koudegolfTeller >= 3) {
                return true;
            }
        }
        return false;
    }
}
