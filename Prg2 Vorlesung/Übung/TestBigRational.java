import java.math.BigInteger;

/**
 * Created by Wolfgang Mühlbauer on 01.04.2016.
 */
public class TestBigRational {



    public static void main(String[] args) {
        testConstructors();
        testArithmetic();
        testEqualsCompare();
        testBig();
    }

    public static void testConstructors() {

        System.out.print("Testing constructors ...");

        BigRational r1 = new BigRational();
        assert r1.getNumerator() == 0 && r1.getDenominator() == 1;

        BigRational r2 = new BigRational(1, 2);
        assert r2.getNumerator() == 1 && r2.getDenominator() == 2;

        BigRational r3 = new BigRational(5, -15);
        assert r3.getNumerator() == -1 && r3.getDenominator() == 3;

        BigRational r4 = new BigRational(3,6);
        assert r4.getNumerator() == 1 && r4.getDenominator() == 2;

        BigRational r5 = new BigRational(2);
        assert r5.getNumerator() == 2 && r5.getDenominator() == 1;

        BigRational r6= new BigRational(3.1415);
        assert r6.getNumerator() == 6283 && r6.getDenominator() == 2000;

        BigRational r7 = new BigRational(2.5);
        assert r7.getNumerator() == 5 && r7.getDenominator() == 2;

        BigRational r8 = new BigRational("1/2");
        assert r8.getNumerator() == 1 && r8.getDenominator() == 2;

        BigRational r9 = new BigRational("4/-6");
        assert r9.getNumerator() == -2 && r9.getDenominator() == 3;

        // if program executation arrives here -> no error
        System.out.println("No errors found");

    }


    public static void testArithmetic() {

        System.out.print("Testing arithmetics ... ");

        // test multiplication
        BigRational r1 = new BigRational(1, 2);
        BigRational r2 = new BigRational(2, 3);
        BigRational r3 = r1.multiply(r2); // 1/2 * 2/3 = 2/6 (1/3)
        assert r3.getNumerator() == 1 && r3.getDenominator() == 3;

        // test inverting
        BigRational r4 = r1.invert(); // 2/1
        assert r4.getNumerator() == 2 && r4.getDenominator() == 1;

        // test division
        BigRational r5 = r1.divide(r2); // 1/2 * 3/2 = 3/4
        assert r5.getNumerator() == 3 && r5.getDenominator() == 4;

        // test addition
        BigRational r6 = r1.add(r2); // 1/2 + 2/3 = 7/6
        assert r6.getNumerator() == 7 && r6.getDenominator() == 6;

        // test subtraction
        BigRational r7 = r1.subtract(r2); // 1/2 - 2/3 = -1/6
        assert r7.getNumerator() == -1 && r7.getDenominator() == 6;

        // test negation
        BigRational r8 = r1.negate(); // -1/2
        assert r8.getNumerator() == -1 && r8.getDenominator() == 2;

        // test doubleValue
        double d1 = r5.doubleValue();   // r5 == 3/4 = 0.75
        assert d1 <= 0.750001 && d1 >= 0.749999;

        // if program executation arrives here -> no error
        System.out.println("No errors found");


    }

    public static void testBig() {

        System.out.print("Testing with big numbers ... ");

        BigInteger a1 = new BigInteger("1");
        BigInteger a2 = new BigInteger("5");
        BigInteger b1 = new BigInteger("222222222222222222222222222222");
        BigInteger b2 = new BigInteger("333333333333333333333333333333");
        BigInteger b3 = new BigInteger("666666666666666666666666666666");

        BigRational r1 = new BigRational(a1,b1);
        BigRational r2 = new BigRational(a1,b2);
        BigRational r3 = r1.add(r2);
        BigRational r4 = new BigRational (a2,b3);

        assert r1.getNumerator() == 1;
        assert r2.getNumerator() == 1;
        assert r3.equals(r4);

        // if program executation arrives here -> no error
        System.out.println("No errors found (Result for r3 = " + r3.toString() + ")");

    }

    public static void testEqualsCompare() {

        System.out.print("Testing equals implementation ... ");

        BigRational r1 = new BigRational(1, 2);
        BigRational r2 = new BigRational(2, 3);
        BigRational r3 = new BigRational(1, 2);
        BigRational r4 = new BigRational(2, 4);

        assert r1.equals(r1);
        assert r1.equals(r3);
        assert !(r1.equals(r2));
        assert !(r1.equals(new String("1")));
        assert r1.equals(r4);

        assert r1.hashCode()==r1.hashCode();
        assert r1.hashCode()==r3.hashCode();
        assert r1.hashCode()==r4.hashCode();

        assert(r1.compareTo(r1) == 0);
        assert(r1.compareTo(r3) == 0);
        assert(r1.compareTo(r2) < 0);
        assert(r2.compareTo(r3) > 0);

        // if program executation arrives here -> no error
        System.out.println("No errors found");

    }


}
