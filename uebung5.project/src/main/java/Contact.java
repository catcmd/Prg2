public class Contact {
    /**
     * Variables
     */
    private static int contactCounter;
    private String name;
    private long phone;
    private int id;

    Contact next;

    /**
     * Constructor für Objekt name für einen Kontakt
     * Kontakt wird mit nur namen erschaffen
     * @param name
     */

    Contact(String name)
    {
        this.name = name;
    }

    /**
     * Überladener Construktor Objekt Phone und Name für einen Kontakt
     * Kontakt kann mit name und phone number erschaffen werden
     * @param name
     * @param phone
     */

    Contact(String name, long phone)
    {
        this(name);

        this.phone = phone;
    }

    /**
     * getPhone returned den Wert Phone
     * @return
     */

    public long getPhone() {

       return phone;
    }

    /**
     * getName returned den Wert Name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den nächsten Contact
     * @param next
     */

    public void setNext(Contact next)
    {
        this.next = next;
    }

    public Contact getNext()
    {
        return this.next;
    }

    /**
     * Liefert einen String zurück der das Obj. beschreibt diese soll den Namen und Telefonnummer
     * enthalten
     * @return
     */
    @Override
    public String toString() {
        return "Name: " + name + " Phonenumber: " + phone;
    }

}
