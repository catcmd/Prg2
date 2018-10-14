/**
 * Created by Wolfgang Mühlbauer on 06.04.2016.
 */



public class AddressBook {

    // class member, constant
    public final static long EMERGENCY_NUMBER = 112;

    // instance members
    private Contact head;       // start of list
    private int numContacts;    // number of contacts in address book

    // constructor
    public AddressBook() {
        head = null;
        numContacts = 0;
    }

    // returns number of contacts that are stored in addressbook
    public int getNumContacts() {
        return numContacts;
    }


    // add contact to beginning of list
    public void insertToFront(Contact c) {
        c.setNext(head);
        head = c;
        numContacts++;
    }

    // search for a contact with "name" (assumption: name is unique)
    public Contact search(String name) {
        Contact current = head;
        while (current != null && !current.getName().equals(name)) {
            current = current.getNext();
        }
        return current;  // Note: "current" is "null" if address book is empty
    }


    // delete contact c from list
    public void delete(Contact c) {
        Contact current = head;
        Contact previous = null;        // during search for contact, stores predecessor of current
        while (current != null && current != c) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {          // entry to delete was found in list
            if (previous == null) {     // entry to delete is first element
                head = current.getNext();
            }
            else {                      // entry to delete is not first element
                previous.setNext(current.getNext());
            }
            numContacts--;
        }
    }

        // prints all contacts from addressbook
    public void print() {
        Contact current = head;
        System.out.print(numContacts + " contacts");
        while (current != null) {
            System.out.print("[" + current.toString() + "]");
            current = current.getNext();
        }
        System.out.println();
    }

}
