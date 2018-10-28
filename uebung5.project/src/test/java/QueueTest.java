import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    /**
     * Variablen
     */
    Queue q1;

    Contact c1;
    Contact c2;
    Contact c3;

    @Before
    public void setUp() throws Exception {
        q1 = new Queue();

        this.c1 = new Contact("Hans", 987);
        this.c2 = new Contact("Benedict Maus", 7043);
        this.c3 = new Contact("Chris", 123);
    }

    @After
    public void tearDown() throws Exception {
        c1 = null;
        c2 = null;
        c3 = null;
    }

    @Test
    public void testEnqueue() {
        q1.enqueue(c1);
        q1.enqueue(c2);
        q1.enqueue(c3);

        assertEquals(c1, q1.getHead());
        assertEquals(c3, q1.getTail());
        assertEquals(3, q1.getNumContacts());
    }

    @Test
    public void dequeue() {
        q1.dequeue();

        assertNull(q1.getHead());
        assertEquals(0, q1.getNumContacts());

        q1.enqueue(c1);
        q1.enqueue(c2);
        q1.enqueue(c3);

        assertEquals(c1, q1.getHead());
        assertEquals(c1, q1.dequeue());

        assertEquals(2, q1.getNumContacts());
    }

    @Test
    public void getNumContacts() {
        q1.enqueue(c1);
        q1.enqueue(c2);
        q1.enqueue(c3);

        assertEquals(3, q1.getNumContacts());
    }

    @Test
    public void getTail() {
        assertEquals(0, q1.getNumContacts());

        q1.enqueue(c1);
        assertEquals(1, q1.getNumContacts());

        q1.enqueue(c2);
        q1.enqueue(c3);
        assertEquals(3, q1.getNumContacts());
    }


    @Test
    public void getHead() {

        q1.enqueue(c1);
        q1.enqueue(c2);
        q1.enqueue(c3);

        assertEquals(3, q1.getNumContacts());

        q1.dequeue();

        assertEquals(2, q1.getNumContacts());

        q1.dequeue();

        assertEquals(1, q1.getNumContacts());

        q1.dequeue();

        assertEquals(0, q1.getNumContacts());

    }
}