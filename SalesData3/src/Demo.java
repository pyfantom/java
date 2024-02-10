public class Demo {
    public static void main(String[] args) {
        SalesData salesData = new SalesData(8);

        double[] week9 = {1245.67, 1490.07, 1679.87, 2371.46, 1783.92, 1461.99, 2059.77};
        salesData.voegWeekToe(week9, 9);

        double[] week10 = {2541.36, 2965.88, 1965.32, 1845.23, 7021.11, 9652.74, 1469.36};
        salesData.voegWeekToe(week10, 10);

        double[] week16 = {2589.55, 1970.26, 1468.70, 1950.05, 3800.25, 1250.16, 1111.16};
        salesData.voegWeekToe(week16, 16);

        // Print gemiddelde verkoopcijfers voor week 10 en week 16
        System.out.println("Week 10:");
        System.out.println("Gemiddelde verkoop: " + salesData.geefGemiddelde(10));

        System.out.println("Week 16:");
        System.out.println("Gemiddelde verkoop: " + salesData.geefGemiddelde(16));

        // Print gemiddelde verkoopcijfers per dag
        System.out.println("Gemiddelde verkoop per dag:");
        System.out.println("maandag: " + salesData.geefGemiddelde("maandag"));
        System.out.println("dinsdag: " + salesData.geefGemiddelde("dinsdag"));
        System.out.println("woensdag: " + salesData.geefGemiddelde("woensdag"));
        System.out.println("donderdag: " + salesData.geefGemiddelde("donderdag"));
        System.out.println("vrijdag: " + salesData.geefGemiddelde("vrijdag"));
        System.out.println("zaterdag: " + salesData.geefGemiddelde("zaterdag"));
        System.out.println("zondag: " + salesData.geefGemiddelde("zondag"));
    }
}
