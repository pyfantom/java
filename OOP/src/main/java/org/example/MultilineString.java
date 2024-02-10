package org.example;

public class MultilineString {
    public static void main(String[] args) {
        String multilineString = "Python wordt geleverd met een uitgebreide bibliotheek\n" +
                "om van alles en nog wat standaard te kunnen bewerken.\n" +
                "Het is erg eenvoudig om in Python herbruikbare code te schrijven.";

        System.out.println(multilineString);

        String vervangenString = multilineString.replace("Python", "Java");
        System.out.println(vervangenString);
    }
}
