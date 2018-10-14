import org.junit.Test;
import java.util.logging.Logger;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Wolfgang Mühlbauer on 12.05.2017.
 */
public class ShapeTest {

    // Logger: convenient class for testing, allows to define different log levels etc.
    private static Logger logger =
            Logger.getLogger(ShapeTest.class.getName());



    // test if circle area compute corectly (delta is tolerance, recommended for double values)
    @Test
    public void testCircleArea() {
        Circle c = new Circle(2.0);
        assertEquals("Area", 12.6, c.getArea(), 0.1);
    }

    // test that length/width are the same after adjusting only one attribute
    @Test
    public void testSquare() {
        // beide Seiten gleich lang
        Square s = new Square(5.0);
        s.setLength(2);
        assertTrue("Equal side length", s.getLength() == s.getWidth());
    }


    // manage 4 differnet shapes in one array
    @Test
    public void testPolymorphism() {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Shape("red");
        shapes[1] = new Circle(1.0, "green");
        shapes[2] = new Rectangle(1.0, 2.0, "blue");
        shapes[3] = new Square(1.0, "yellow");

        for (Shape s : shapes) {
            logger.info(s.toString());          // alternative to jusing System.out.println(.)
        }
    }

}