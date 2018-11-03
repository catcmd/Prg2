import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class ShapeTest {

    Shape test[];

    @Before
    public void setUp() throws Exception {
        test = new Shape[3];
    }

    @After
    public void tearDown() throws Exception {
        for(int i = 0; i < test.length; i++) {
            test[i] = null;
        }
    }

    
}