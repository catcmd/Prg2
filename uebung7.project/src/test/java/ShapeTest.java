import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTest {

    Shape test[] = new Shape[4];

    @Before
    public void setUp() throws Exception {
            test[0] = new Shape("green");
            test[1] = new Rectangle(2, 4);
            test[2] = new Circle(3, "green");
            test[3] = new Square(4,"red");
    }

    @After
    public void tearDown() throws Exception {
        if(test != null){
            for(int i = 0; i < test.length; i++) {
            test[i] = null;
            }
        }
    }

    @Test
    public void printElements(){
        for(int i = 0; i < test.length; i++) {
            test[i].toString();

            System.out.println(test[i].toString());

        }
    }
}