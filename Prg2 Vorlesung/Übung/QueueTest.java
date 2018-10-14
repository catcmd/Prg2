import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Wolfgang Mühlbauer on 04.05.2017.
 */
public class QueueTest {

    private Queue queue;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;


    @Before
    public void setUp() {
        queue = new Queue();
        contact1 = new Contact("Berger", 31232);
        contact2 = new Contact("Huber", 83882);
        contact3 = new Contact("Maier", 29399);
    }

    @Test
    public void testCreateQueue() {
        assertNull("Tail", queue.getTail());
        assertNull("Head",queue.getHead());
        assertEquals("Num contacts", 0, queue.getNumContacts());

        // Hint for experts: There exist also assertThat methods
    }


    @Test
    public void testEnqueue() {
        queue.enqueue(contact1);
        queue.enqueue(contact2);
        queue.enqueue(contact3);
        assertEquals("Number contacts", 3, queue.getNumContacts());
        assertSame("Tail", contact3, queue.getTail());
        assertSame("Head", contact1, queue.getHead());
    }

    @Test
    public void testDequeue() {
        queue.enqueue(contact1);
        queue.enqueue(contact2);
        queue.enqueue(contact3);
        Contact c = queue.dequeue();
        assertSame("Removed elem", contact1, c);
        assertSame("Tail", contact3, queue.getTail());
        assertSame("Head", contact2, queue.getHead());
    }

    @Test
    public void testDequeueLastElement() {
        queue.enqueue(contact1);
        Contact c = queue.dequeue();
        assertEquals("Number of queue elements", 0, queue.getNumContacts());  // vielleicht streichen
        assertNull("Tail", queue.getTail());
        assertNull("Head", queue.getHead());
    }


    @Test(timeout=50)
    public void testPerformance() {
        for (int i=0; i < 1000; i++) {
            Contact c = new Contact("Name"+i, i);
            queue.enqueue(c);
        }
    }

    @Test
    public void testContactCounter() {
        int before = Contact.getContactCounter();
        Contact c = new Contact("Mustermann", 32168);
        int after = Contact.getContactCounter();
        assertEquals(1, after-before);
    }

}