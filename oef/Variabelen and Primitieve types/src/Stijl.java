public class Stijl {
    public static void main(String[] args) {
        final double g = 9.81; // symbolische constante
        double h = 10.0; // een hoogte

        // bereken valtijd en druk resultaat af
        double t = Math.sqrt((2 * h) / g);
        System.out.println("De valtijd bedraagt " + t);
    }
}

