import java.util.Random;

public class DemoPaswoordenBeheer {
    public static void main(String[] args) {
        PaswoordenBeheer pwManager = new PaswoordenBeheer("user123", 5);

        String[] urls = {
                "git.ikdoeict.be", "student.ikdoeict.be", "intranet.odisee.be", "dropbox.com",
                "git.ikdoeict.be", "mail.google.com"
        }
        String[] passwords = {
                "azerty123", "tyuio789", "hi456", "hi456", "azerty456", "hi456"
        }

        for (int i = 0; i < urls.length; i++) {
            pwManager.voegAccountToe(urls[i], passwords[i]);
        }

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(urls.length);
            String randomUrl = urls[randomIndex];
            String inputPassword = "hi456"; // You can change this to take user input
            boolean isValid = pwManager.checkPaswoord(randomUrl, inputPassword);
            System.out.println("URL: " + randomUrl + ", Password: " + inputPassword + ", Valid: " + isValid);
        }

        String passwordVariation = pwManager.checkPaswoordVariatie();
        System.out.println("Password Variation: " + passwordVariation);
    }
}
