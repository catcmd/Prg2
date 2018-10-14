/**
 * Implementation of a queue data structure using a single linked list.
 *
 * @author Wolfgang Mühlbauer
 * @version 1.0
 */
public class Queue {

    // number of contacts saved in queue
    private int numContacts;

    // last contact added
    private Contact tail;

    // next contact to be removed
    private Contact head;

    /**
     * generates an empty queue
     */
    public Queue() {
        tail = null;
        head = null;
        numContacts = 0;
    }

    /**
     * inserts a new contact into the queue
     *
     * @param c contact to be inserted
     */
    public void enqueue(Contact c) {
        c.setNext(null);            // make sure that element to be added does not point to any other element
        if (tail == null) {         // queue is currently empty
            head = c;
        }
        else {                      // there is at least one element in queue
            tail.setNext(c);
        }
        tail = c;
        numContacts++;
    }

    /**
     * removes contact from the queue
     *
     * @return removed contact
     */
    public Contact dequeue() {
        if (numContacts > 0) {      // only remove element if there is at least one element in the queue
            Contact c = head;
            head = head.getNext();
            numContacts--;
            if (numContacts == 0) {         // queue is now empty
                tail = null;
            }
            return c;
        }
        return null;
    }

    /**
     * get tail of queue
     *
     * @return tail
     */
    public Contact getTail() {
        return tail;
    }

    /**
     * get head of queue
     *
     * @return head
     */
    public Contact getHead() {
        return head;
    }

    /**
     * get number of contacts stored in queue
     *
     * @return number of stored contacts.
     */
    public int getNumContacts() {
        return numContacts;
    }
}
