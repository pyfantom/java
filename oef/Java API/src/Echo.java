
import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer een zin in:");
        String zin = scanner.nextLine();

        System.out.println("Echo: " + zin);

        scanner.close();
    }
}
