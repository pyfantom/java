package org.example;
public class SomMethod {
    public static void main(String[] args) {
        System.out.println("Welkom bij de Python les");

        int resultaat = som(5, 10);
        System.out.println("Het resultaat is: " + resultaat);
    }

    public static int som(int a, int b) {
        return a + b;
    }
}

