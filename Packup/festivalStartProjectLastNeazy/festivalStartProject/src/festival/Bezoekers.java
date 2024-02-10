package festival;

import java.time.LocalDate;

/**
 * Deze klasse beheert de gegevens van de bezoekers en hun boekingen tijdens het festival.
 *
  * @author Neazy El Taiyeb
 */
public class Bezoekers {

    // voorzie de hele klasse van Javadoc
    /* hier komen datavelden en constanten :
     * verzin echter geen extra datavelden!
     */
    private final LocalDate START_FESTIVAL;
    private int aantalDagen;
    private String[] bezoekers;
    private int[][] bezetting;

    /**
     * Constructor voor het aanmaken van een Bezoekers object.
     *
     * @param startFestival      De startdatum wan festival.
     * @param maxBezoekersPerDag Hoe veel bezoekers per dag.
     * @param aantalDagen        Dagen van het festival.
     */

    // schrijf eerst de gevraagde constructor:
    public Bezoekers(LocalDate startFestival, int maxBezoekersPerDag, int aantalDagen) {
        START_FESTIVAL = startFestival;
        this.aantalDagen = aantalDagen;
        bezoekers = new String[maxBezoekersPerDag];
        bezetting = new int[aantalDagen][maxBezoekersPerDag];
    }

    // vervolledig dan onderstaande methoden :

    /**
     * Boekt een bezoeker voor een van festival dagen.
     *
     * @param emailadres Het e-mailadres van de bezoeker.
     * @param dag        Welke Dag(en) will de bezoeker boeken.
     * @return true als de boeking gelukt is, false als niet gelukt.
     */
    public boolean boekBezoekerDag(String emailadres, LocalDate dag) {
        try {
            int id = registreerBezoeker(emailadres);
            if (id == -1) {
                return false;
            }
            int dagIndex = (int) (dag.toEpochDay() - START_FESTIVAL.toEpochDay());
            if (dagIndex < 0 || dagIndex >= aantalDagen) {
                return false;
            }
            if (bezetting[dagIndex][id - 1] == 1) {
                return false;
            }
            bezetting[dagIndex][id - 1] = 1;
            return true;
        } catch (Exception e) {
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
            return false;
        }
    }

    /**
     * Registreert een bezoeker en geeft ID terug.
     *
     * @param emailAdres Het e-mailadres van  bezoeker.
     * @return Het ID van de geregistreerde bezoeker, -1 als registratie mislukt.
     */
    public int registreerBezoeker(String emailAdres) {
        try {
            if (emailAdres == null || emailAdres.trim().isEmpty()) {
                throw new IllegalArgumentException("Ongeldig e-mailadres");
            }

            for (int i = 0; i < bezoekers.length; i++) {
                if (bezoekers[i] == null) {
                    bezoekers[i] = emailAdres;
                    return i + 1;
                } else if (bezoekers[i].equals(emailAdres)) {
                    return i + 1;
                }
            }
            System.out.println("Er zijn geen beschikbare plekken voor bezoekers.");
            return -1;
        } catch (Exception e) {
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Geeft een lijst van bezoekers, die alle dagen van het festival beleven.
     *
     * @return Een string met e-mailadressen van bezoekers, die alle dagen van het festival beleven.
     */
    public String geefBezoekersFullTicket() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bezoekers.length; i++) {
            boolean heeftVolledigTicket = true;
            for (int j = 0; j < aantalDagen; j++) {
                if (bezetting[j][i] != 1) {
                    heeftVolledigTicket = false;
                    break;
                }
            }
            if (heeftVolledigTicket) {
                sb.append(bezoekers[i]).append(", ");
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    /**
     * Geeft reservatie  van bezoekers van het festival per dag weer .
     *
     * @return Een overzicht van bezoekers per dag.
     */
    public String geefOverzichtBezoekers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aantalDagen; i++) {
            sb.append(START_FESTIVAL.plusDays(i)).append("\n");
            sb.append("Bezoekers voor deze dag: ");
            for (int j = 0; j < bezoekers.length; j++) {
                if (bezetting[i][j] == 1) {
                    sb.append(bezoekers[j]).append(", ");
                }
            }
            if (sb.indexOf(",") != -1) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
