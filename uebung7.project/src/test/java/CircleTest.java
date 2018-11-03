import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    Circle c1;

    @Before
    public void setUp() throws Exception {
        c1 = new Circle(2);
    }

    @After
    public void tearDown() throws Exception {
        c1 = null;
    }

    @Test
    public void testRadius2() {
        assertEquals(12.6, c1.getArea(), 0.05);
    }

}