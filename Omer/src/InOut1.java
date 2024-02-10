import java.util.Scanner;

public class InOut1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("wat is uw naam?");
        String naam = input.next();
        System.out.println("wat is uw leeftijd?");
        int leeftijd = input.nextInt();
        System.out.println("heb je werk  true/false?");
        boolean heeftWerk = input.nextBoolean();
        System.out.println("jou naam is "+naam+" ,je bent "+leeftijd+" jaar oud en dat te werkt is " +heeftWerk);



    }
}