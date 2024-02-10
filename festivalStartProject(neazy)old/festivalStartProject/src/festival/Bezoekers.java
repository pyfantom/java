package festival;

import java.time.LocalDate;


public class Bezoekers {

    // voorzie de hele klasse van Javadoc

    /* hier komen datavelden en constanten :
     * verzin echter geen extra datavelden!
     */
    private final LocalDate startFestival;
    private  int aantalDagen;
    private  String[] bezoekers;
    private  int[][] bezetting;


    // schrijf eerst de gevraagde constructor:
    public Bezoekers(LocalDate startFestival, int maxBezoekersPerDag, int aantalDagen) {
        this.startFestival = startFestival;
        this.aantalDagen = aantalDagen;
        this.bezoekers = new String[maxBezoekersPerDag];
        this.bezetting = new int[aantalDagen][maxBezoekersPerDag];
    }

    // vervolledig dan onderstaande methoden :
    public boolean boekBezoekerDag(String email, LocalDate dag) {
        int id = registreerBezoeker(email);
        if (id == -1 || dag.isBefore(startFestival) || dag.isAfter(startFestival.plusDays(aantalDagen - 1))){
            return false;
        }
        if (bezetting[(int) dag.toEpochDay()][id-1] == 1) {
            return false;
        }
        bezetting[(int) dag.toEpochDay()][id-1] = 1;
        return true;
    }

    public int registreerBezoeker(String email) {
        for (int i = 0; i < bezoekers.length; i++) {
            if (bezoekers[i] == null) {
                bezoekers[i] = email;
                return i+1;
            } else if (bezoekers[i].equals(email)) {
                return i+1;
            }
        }
        return -1;
    }

    public String geefBezoekersVolledigTicket() {
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
                sb.append(bezoekers[i]).append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

        public String geefBezoekersVoorDag() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aantalDagen; i++) {
            sb.append(startFestival.plusDays(i).toString()).append(": ");
            for (int j = 0; j < bezoekers.length; j++) {
                if (bezetting[i][j] == 1) {
                    sb.append(bezoekers[j]).append(",");
                }
            }
            if (sb.indexOf(",") != -1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}