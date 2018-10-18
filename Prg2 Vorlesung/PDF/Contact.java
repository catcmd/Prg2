import java.util.function.Consumer;

/**
 * Created by Wolfgang Mühlbauer on 06.04.2016.
 */
public class Contact {

    // instance counter: static member is used to generate id of a contact
    private static int contactCounter = 0;

    // reference to next node in chain, or null if there isn't one.
    private Contact next;

    // attributes
    private String name;
    private long phone;
    private int id;


    // value constructor 1: phone number unknown, set to 0
    public Contact(String name) {
        contactCounter++;
        id = contactCounter;
        this.name = name;
        this.next = null;
        this.phone = 0;
    }

    // value constructor 2: also sets phone number
    public Contact(String name, long phone) {
        this(name);   // call other constructor
        this.phone = phone;
    }


    // string representation of contact including name and phone
    public String toString() {
        return name + "-" + phone;
    }

    public long getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Contact getNext() {
        return next;
    }

    public void setNext(Contact next) {
        this.next = next;
    }


}
