import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    Square s1;

    @Before
    public void setUp() throws Exception {
       s1 = new Square(4);
    }

    @After
    public void tearDown() throws Exception {
        s1 = null;
    }

    @Test
    public void changeSide() {
        assertEquals(4, s1.getSide(), 0.05);
        s1.setLength(5);
        assertEquals(5, s1.getWidth(), 0.05);
    }

}