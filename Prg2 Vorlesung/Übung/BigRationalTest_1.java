import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Wolfgang Mühlbauer on 23.05.2017.
 */
public class BigRationalTest {


    @Test
    public void testConstructors() {

        BigRational r1 = new BigRational();
        assertEquals("Default Constructor Numerator", 0, r1.getNumerator());
        assertEquals("Default Constructor Denominator", 1, r1.getDenominator());

        BigRational r2 = new BigRational(1, 2);
        assertEquals("Value Constructor Numerator 1", 1, r2.getNumerator());
        assertEquals("Value Constructor Denominator 1", 2, r2.getDenominator());

        BigRational r3 = new BigRational(5, -15);
        assertEquals("Value Constructor Numerator 2", -1, r3.getNumerator());
        assertEquals("Value Constructor Denominator 2", 3, r3.getDenominator());

        BigRational r4 = new BigRational(3,6);
        assertEquals("Value Constructor Numerator 3", 1, r4.getNumerator());
        assertEquals("Value Constructor Denominator 3", 2, r4.getDenominator());

        BigRational r5 = new BigRational(2);
        assertEquals("Value Constructor Numerator Whole number", 2, r5.getNumerator());
        assertEquals("Value Constructor Denominator Whole number", 1, r5.getDenominator());

        BigRational r6= new BigRational(3.1415);
        assertEquals("Value Constructor Numerator Double 1", 6283, r6.getNumerator());
        assertEquals("Value Constructor Denominator Double 1", 2000, r6.getDenominator());

        BigRational r7 = new BigRational(2.5);
        assertEquals("Value Constructor Numerator Double 2", 5, r7.getNumerator());
        assertEquals("Value Constructor Denominator Double 2", 2, r7.getDenominator());

        BigRational r8 = new BigRational("1/2");
        assertEquals("Value Constructor Numerator String", 1, r8.getNumerator());
        assertEquals("Value Constructor Denominator String", 2, r8.getDenominator());

    }

    @Test
    public void testArithmetic() {

           // test multiplication
        BigRational r1 = new BigRational(1, 2);
        BigRational r2 = new BigRational(2, 3);
        BigRational r3 = r1.multiply(r2); // 1/2 * 2/3 = 2/6 (1/3)
        assertEquals("Multiplication Numerator", 1, r3.getNumerator());
        assertEquals("Multiplication Denominator", 3, r3.getDenominator());

        // test inverting
        BigRational r4 = r1.invert(); // 2/1
        assertEquals("Invert Numerator", 2, r4.getNumerator());
        assertEquals("Invert Denominator", 1, r4.getDenominator());

        // test division
        BigRational r5 = r1.divide(r2); // 1/2 * 3/2 = 3/4
        assertEquals("Division Numerator", 3, r5.getNumerator());
        assertEquals("Division Denominator", 4, r5.getDenominator());


        // test addition
        BigRational r6 = r1.add(r2); // 1/2 + 2/3 = 7/6
        assertEquals("Addition Numerator", 7, r6.getNumerator());
        assertEquals("Addition Denominator", 6, r6.getDenominator());

        // test subtraction
        BigRational r7 = r1.subtract(r2); // 1/2 - 2/3 = -1/6
        assertEquals("Subtraction Numerator", -1, r7.getNumerator());
        assertEquals("Subtraction Denominator", 6, r7.getDenominator());

        // test negation
        BigRational r8 = r1.negate(); // -1/2
        assertEquals("Negation Numerator", -1, r8.getNumerator());
        assertEquals("Negation Denominator", 2, r8.getDenominator());

        // test doubleValue
        double d1 = r5.doubleValue();   // r5 == 3/4 = 0.75
        assertEquals("Double value", 0.75, d1, 0.001);
    }

    @Test
    public void testBig() {

        BigInteger a1 = new BigInteger("1");
        BigInteger a2 = new BigInteger("5");
        BigInteger b1 = new BigInteger("222222222222222222222222222222");
        BigInteger b2 = new BigInteger("333333333333333333333333333333");
        BigInteger b3 = new BigInteger ("666666666666666666666666666666");

        BigRational r1 = new BigRational(a1,b1);
        BigRational r2 = new BigRational(a1,b2);
        BigRational r3 = r1.add(r2);

        assertEquals( new BigRational(a2, b3), r3);

    }

    @Test
    public void testEqualsCompare() {

        BigRational r1 = new BigRational(1, 2);
        BigRational r2 = new BigRational(2, 3);
        BigRational r3 = new BigRational(1, 2);
        BigRational r4 = new BigRational(2, 4);

        assertTrue(r1.equals(r1));
        assertTrue(r1.equals(r3));
        assertFalse(r1.equals(r2));
        assertFalse(r1.equals(new String("1")));
        assertTrue(r1.equals(r4));

        assertTrue(r1.hashCode()==r3.hashCode());
        assertTrue(r1.hashCode()==r4.hashCode());

        assertTrue(r1.compareTo(r1) == 0);
        assertTrue(r1.compareTo(r3) == 0);
        assertTrue(r1.compareTo(r2) < 0);
        assertTrue(r2.compareTo(r3) > 0);


    }


}