import java.util.Scanner;

/**
 * Created by Wolfgang Mühlbauer on 19.05.2017.
 */


public class StringOopsSolution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Type your name: ");
        String name = console.next();
        process(name);
    }

    public static void process(String name) {       // F1: string -> String (keine Anführungszeichen bei Parameter)
        if (name.equals("Duck")) {                  // F2+3 == -> equals und String in Anführungszeichen
            System.out.println("Hello Donald!");
        }
        name = name.toUpperCase();                  // F4: toUpperCase ist Objektmethodesiehe -> name.toUpperCase(.)
                                                    // F5: String ist immutable -> weise Ergebnis Variable zu
        name = name.substring(1, 3);                                      // F6+F7: siehe F6 und F7
        System.out.println(name + " has " + name.length() + " letters");  // F8: length() mit Klammern

    }
}
