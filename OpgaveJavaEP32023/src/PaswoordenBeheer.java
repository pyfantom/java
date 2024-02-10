/**
 * Auteur : Neazy El Taiyeb
 *
 */


import java.util.Arrays;

/**
 * een applicatie om paswoorden te beheren. De gebruiker kan voor elke account die hij nieuw aanmaakt
 * beslissen of de applicatie
 * het paswoord al dan niet moet bijhouden
 */
class PaswoordenBeheer {
    private String login;
    private static final int MAX_ACCOUNTS = 5;
    private String[][] accounts;
    private int accountCount;

    public PaswoordenBeheer(String userLogin, int maxAccounts) {
        login = userLogin;
        accounts = new String[MAX_ACCOUNTS][2];
        accountCount = 0;
    }

    public boolean voegAccountToe(String nieuweUrl, String eenPaswoord) {
        if (accountCount >= MAX_ACCOUNTS) {
            return false;
        }

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i][0].equals(nieuweUrl)) {
                return false; // als url zelvd opnieuw ingevoerd
            }
        }

        accounts[accountCount][0] = nieuweUrl;
        accounts[accountCount][1] = eenPaswoord;
        accountCount++;
        return true;
    }

    public boolean checkPaswoord(String eenUrl, String eenPaswoord) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i][0].equals(eenUrl) && accounts[i][1].equals(eenPaswoord)) {
                return true;
            }
        }
        return false;
    }

    public String checkPaswoordVariatie() {
        String[] uniquePasswords = new String[MAX_ACCOUNTS];
        int uniqueCount = 0;
        for (int i = 0; i < accountCount; i++) {
            if (!Arrays.asList(uniquePasswords).contains(accounts[i][1])) {
                uniquePasswords[uniqueCount] = accounts[i][1];
                uniqueCount++;
            }
        }

        if (uniqueCount == accountCount) {
            return "Excellent";
        } else if (uniqueCount == accountCount - 1) {
            return "Voldoende";
        } else {
            return "Onvoldoende";
        }
    }
}

