public class Queue {

    /**
     * Variablen
     */
    private int numContacts;
    private Contact head;
    private  Contact tail;

    /**
     * Queue legt neue Warteschlange an
     */
    public Queue()
    {
        this.head = null;
        this.tail = null;
    }

    /**
     * Fügt der Warteschlange neuen Kontakt hinzu
     * @param c
     */
    public void enqueue(Contact c)
    {
        if(head == null && tail == null)
        {
            head = c;
            tail = c;
            c.setNext(null);

            numContacts++; //Zählt Contacts um 1 hoch
        }
        else
        {
            tail.setNext(c);
            tail = c;
            c.setNext(null);

            numContacts++; //Zählt Contacts um 1 hoch
        }
    }

    /**
     * Entfernt den ältesten Kontakt aus der Warteschlange
     * und gibt ihn aus.
     * @return c
     */
    public Contact dequeue()
    {
        Contact tmp = null;

        if(head != null && tail !=null)
        {
            tmp = head;
            head = head.getNext();

            numContacts--; //Verringert Contacts um 1
        }

        return tmp;
    }

    public int getNumContacts() {
        return numContacts;
    }

    public Contact getTail() {
        return tail;
    }

    public Contact getHead() {
        return head;
    }
}
