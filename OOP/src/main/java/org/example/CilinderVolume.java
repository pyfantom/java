package org.example;

import java.util.Scanner;

public class CilinderVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer de straal van de cilinder in (in cm):");
        double straal = scanner.nextDouble();
        System.out.println("Voer de hoogte van de cilinder in (in cm):");
        double hoogte = scanner.nextDouble();

        double volume = Math.PI * Math.pow(straal, 2) * hoogte;

        System.out.printf("Het volume van de cilinder is: %.2f cm³%n", volume);

        scanner.close();
    }
}

