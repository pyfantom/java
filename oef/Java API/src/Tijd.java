import java.util.Scanner;

public class Tijd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geef je input (uur : minuten : seconden) :");

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(":|\\s+");
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        System.out.println(h+" uur "+m+" min "+s+" sec ");
        scanner.close();
    }
}
