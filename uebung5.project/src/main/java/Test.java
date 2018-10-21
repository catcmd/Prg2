public class Test {

    public static void main(String[] args)
    {
        /**
         * Test: Erstellen eines Neuen Adressbuchs
         */
        Adressbook testAdressbook = new Adressbook();

        /**
         * Test: Erstelle neuer Kontakte
         */
        Contact testContact1 = new Contact("Memeet", 564301);
        Contact testContact2 = new Contact("Ferret", 666);

        /**
         * Test: Für Einfügen von Kontakten
         */
        testAdressbook.toFront(testContact1);
        testAdressbook.toFront(testContact2);


        /**
         * Test: Anzahl der Kontakte
         */
        if(testAdressbook.getNumContacts() == 2)
        {
           System.out.print("True, ");
        }
        else
        {
           System.out.println("False, ");
        }
        System.out.println("Anzahl: " + testAdressbook.getNumContacts());
        testAdressbook.print();

        /**
         * Test: Search for Kontakt
         */

        Contact testErgebnisSearch = testAdressbook.search("Memeet");
        if( testErgebnisSearch == testContact1)
        {
            System.out.print("True, ");
        }
        else
        {
            System.out.print("False, ");
        }
        System.out.println("Kontakt " + testErgebnisSearch);

        /**
         * Test: Delete Kontakt
         */

        testAdressbook.delete(testContact2);
        Contact testDeleteSearch = testAdressbook.search("Ferret");
        if( testErgebnisSearch != testContact2)
        {
            System.out.print("True, ");
        }
        else
        {
            System.out.print("False, ");
        }
        System.out.println("Delete neuer Head Kontakt " + testErgebnisSearch);













    }
}
