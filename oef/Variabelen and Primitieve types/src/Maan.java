public class Maan {
    public static void main(String[] args) {
        final double ZWAARTEKRACHT_AARDE = 9.81;
        final double ZWAARTEKRACHT_MAAN = 1.62;

        double massaOpAarde = 70.0; // Vervang door je massa in kg

        double gewichtOpAarde = massaOpAarde * ZWAARTEKRACHT_AARDE;
        double gewichtOpMaan = massaOpAarde * ZWAARTEKRACHT_MAAN;

        System.out.println("Gewicht op Aarde: " + gewichtOpAarde + " Newton");
        System.out.println("Gewicht op de Maan: " + gewichtOpMaan + " Newton");
    }
}
