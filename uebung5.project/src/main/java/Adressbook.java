public class Adressbook {

    /**
     * Variablen
     */
    public final long EMERGENCY_NUMBER  = 112;
    private int numContacts;
    private Contact head;

    /**
     *
     */
    public Adressbook()
    {

    }

    /**
     * Speichert aktuelle Anzahl and Kontakten in der Liste
     * @return
     */
    public int getNumContacts() {
        return numContacts;
    }

    /**
     * Fügt einen Kontakt "c" an den Anfang der Liste
     * @param c
     */
    public void toFront(Contact c)
    {
        c.setNext(head);
        head = c;

        numContacts++;
    }

    /**
     * Sucht in Kotakt nach einem bestimmten Namen und gibt Null zurück wenn nicht existiert
     * @param name
     * @return name
     */
    public Contact search(String name)
    {
        Contact currentContact = head;

        while(currentContact != null) //null pointer ref wert
        {
            if(currentContact.getName() == name)
            {
                return currentContact;
            }
            currentContact = currentContact.getNext();
        }

        return null;
    }


    /**
     * Deletes Contact "c"
     * @param c
     */
    public void delete(Contact c)
    {
        Contact currentContact = head;
        Contact lastContact = null;

        if(head == null || currentContact.getNext() == null )
        {
            head = null;
        }
        else
        {
            while (currentContact.getNext() != null) //null pointer ref wert
            {
                if (currentContact == c)//currentContact und c sind vom gleichen typ Contact
                {
                    lastContact.setNext(currentContact.getNext());//löschen
                }
                lastContact = currentContact;
                currentContact = currentContact.getNext();

            }
        }
    }

    public void print()
    {
        Contact currentContact = head;

        while(currentContact != null) //null pointer ref wert
        {
            System.out.println(currentContact.toString());

            currentContact = currentContact.getNext();

        }
    }
}
