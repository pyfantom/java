import java.util.Scanner;

class MeetGegevens {
    private int[] meetwaarden;

    public MeetGegevens(int[] meetwaarden) {
        this.meetwaarden = meetwaarden;
    }

    public boolean zijnAlleElementenOnderlingVerschillend() {
        for (int i = 0; i < meetwaarden.length; i++) {
            for (int j = i + 1; j < meetwaarden.length; j++) {
                if (meetwaarden[i] == meetwaarden[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int bepaalKleinstePositiefVerschil() {
        if (meetwaarden.length < 2) {
            return -1; // Ongeldig resultaat als er niet genoeg meetwaarden zijn
        }

        int kleinsteVerschil = Integer.MAX_VALUE;
        for (int i = 0; i < meetwaarden.length; i++) {
            for (int j = i + 1; j < meetwaarden.length; j++) {
                int verschil = Math.abs(meetwaarden[i] - meetwaarden[j]);
                if (verschil < kleinsteVerschil) {
                    kleinsteVerschil = verschil;
                }
            }
        }
        return kleinsteVerschil;
    }
}

