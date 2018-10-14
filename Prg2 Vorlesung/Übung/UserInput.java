import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Wolfgang Mühlbauer on 23.06.2017.
 */
public class UserInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // read / parse double value
        double val;
        int numAttempts = 3;
        while (numAttempts > 0) {
            try {
                System.out.println("Bitte eine Zahl eingeben: ");
                val = scanner.nextDouble();
                System.out.println("Der folgende Double-Wert wurde eingelesen: " + val);
                numAttempts = 0;
            } catch (InputMismatchException e) {
                System.out.println("Falsche Eingabe, ungültiges Format für double!");
                String s = scanner.next();   // consume invalid token, scanner does not consume token in case of exception
                // e.printStackTrace();
            } finally {
                numAttempts--;
            }
        }

        // read / parse date:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd'.'MM'.'yyyy");
        try {
            System.out.println("Bitte ein Datum eingeben (TT.MM.JJJJ): ");
            String input = scanner.next();
            LocalDate date = LocalDate.parse(input, formatter);
            System.out.println("Das Datum ist " + date.toString());
        } catch (DateTimeParseException e) {
            System.out.println("Ungültiges Datum");
            e.printStackTrace();
        }
    }

}
