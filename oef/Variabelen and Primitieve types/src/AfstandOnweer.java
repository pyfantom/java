public class AfstandOnweer {
    public static void main(String[] args) {
        final double SNELHEID_GELUID = 340.0; // in meters per seconde
        int tijdSpanne = 1000; // in seconden

        double afstandInMeters = SNELHEID_GELUID * tijdSpanne;
        double afstandInKilometers = afstandInMeters / 1000.0;

        System.out.println("Afstand van onweer: " + afstandInKilometers + " kilometer");
    }
}

