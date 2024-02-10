public class Tax {
    public static void main(String[] args) {
        double PRODUCT_COST = 105.99;
        final double BTW_PERCENTAGE = 0.21;

        double aangerekendeBTW = BTW_PERCENTAGE * PRODUCT_COST;
        double totaleKostprijs = PRODUCT_COST + aangerekendeBTW;

        System.out.println("Aangerekende BTW: " + aangerekendeBTW + " EUR");
        System.out.println("Totale Kostprijs: " + totaleKostprijs + " EUR");
    }
}
