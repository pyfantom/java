public class Permutatie {
    public static void main(String[] args) {
        double var1 = 1.4;
        double var2 = 1.5;
        double var3 = 1.6;

        System.out.println("Variabele var1 is : " + var1);
        System.out.println("Variabele var2 is : " + var2);
        System.out.println("Variabele var3 is : " + var3);

        // Permutatie
        double temp = var1;
        var1 = var2;
        var2 = var3;
        var3 = temp;

        System.out.println("Na permutatie");
        System.out.println("Variabele var1 is : " + var1);
        System.out.println("Variabele var2 is : " + var2);
        System.out.println("Variabele var3 is : " + var3);
    }
}

