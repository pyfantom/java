package festival;

import java.time.LocalDate;
import java.util.Arrays;


public class Bezoekers {

    // voorzie de hele klasse van Javadoc


    /* hier komen datavelden en constanten :
     * verzin echter geen extra datavelden!
     */
    private final LocalDate startFestival;// Startdatum festival
    private int aantalDagen;// Aantal dagen festival
    private String[] bezoekers;// Array om bezoekers data input bij te hounden
    public int[][] bezetting;// Array om de bezetting van bezoekers per dag bij te houden


    // schrijf eerst de gevraagde constructor:


    public Bezoekers(LocalDate startFestival, int maxBezoekersPerDag, int aantalDagen) {
        this.startFestival = startFestival;
        this.aantalDagen = aantalDagen;
        this.bezoekers = new String[maxBezoekersPerDag];
        this.bezetting = new int[aantalDagen][maxBezoekersPerDag];

    }
    // vervolledig dan onderstaande methoden :

    //public boolean boekBezoekerDag(String emailadres, LocalDate dag);
        public void boekBezoekerDag(String email, int dag, boolean status) {
            int id = registreerBezoeker(email);
            if (id == -1) {
                return;
            }
            if (bezetting[(int) dag][id-1] == 1) {
                return;
            }
            bezetting[(int) dag][id-1] = 1;
            return;
        }


   // public int registreerBezoeker(String emailadres);
        public int registreerBezoeker(String email) {
            for (int i = 0; i < bezoekers.length; i++) {
                if (bezoekers[i] == null) {
                    bezoekers[i] = email;
                    return i + 1;
                } else if (bezoekers[i].equals(email)) {
                    return i + 1;
                }
            }
            return -1;
        }

        //public String geefBezoekersFullTicket();
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



        //public String  geefOverzichtBezoekers();
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





