import java.util.Scanner;

public class KleinsteGetal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer het eerste getal in:");
        double getal1 = scanner.nextDouble();

        System.out.println("Voer het tweede getal in:");
        double getal2 = scanner.nextDouble();

        double kleinsteGetal = Math.min(getal1, getal2);

        System.out.println("Het kleinste getal is: " + kleinsteGetal);

        scanner.close();
    }
}
