package org.example;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer twee gehele getallen in:");
        int getal1 = scanner.nextInt();
        int getal2 = scanner.nextInt();
        System.out.println("De som van de getallen is: " + (getal1 + getal2));

        System.out.println("Voer een reëel getal in:");
        double reeelGetal = scanner.nextDouble();
        System.out.println("De verdubbelde waarde is: " + (reeelGetal * 2));

        System.out.println("Voer twee getallen in voor machtsverheffing (basis en exponent):");
        double basis = scanner.nextDouble();
        double exponent = scanner.nextDouble();
        System.out.println("Het resultaat van de machtsverheffing is: " + Math.pow(basis, exponent));

        System.out.println("Voer een getal in voor de berekening van de vierkantswortel:");
        double getalVoorWortel = scanner.nextDouble();
        System.out.println("De vierkantswortel van het getal is: " + Math.sqrt(getalVoorWortel));

        scanner.close();
    }
}

