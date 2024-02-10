public class Euro {
    public static void main(String[] args) {
        char euroSymbol = '\u20AC'; // UTF-16 representation of the euro symbol

        int decimalValue = (int) euroSymbol; // Convert to decimal value

        System.out.println("De decimale waarde van het € symbool = " + decimalValue);
    }
}

