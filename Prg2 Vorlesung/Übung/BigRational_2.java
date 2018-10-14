/**
 * Created by Wolfgang Mühlbauer on 20.04.2016
 */

import java.math.BigInteger;



/** This class represents immutable fractions (dt. "Brüche"). In contrast to exercise 4, this class
 * relies on BigInteger instead of the primitive data type int for numerator and denominator.
 */
final public class BigRational  {

    // constants
	public static final String DELIMITER = "/";         // Bruchstrich
	private final static long PRECISION = 10000000l;    // precision, used for conversion to "double"


	private BigInteger numerator;       // "Zähler"
	private BigInteger denominator;     // "Nenner"


	/**
	 * Calculates "greatest common divisor" (dt. größter gemeinsamer Teiler)
	 * @param   a (positive) whole number
	 * @param   b (positive) whole number
	 * @return  GCD
	 */
	private static BigInteger gcd(BigInteger a, BigInteger b) {
		a = a.abs();
		b = b.abs();
		if (a.compareTo(b) < 0)
			return gcd(b, a);
		if (b.compareTo(BigInteger.ZERO)==0)
			return a;       // zero is divided by each number
		BigInteger c = new BigInteger("1");
		while (c.compareTo(BigInteger.ZERO) != 0) {
			c = a.mod(b); // BigInteger
			a = b;
			b = c;
		}

		return a;
	}
	/**
	 * reduces ("kürzt") the fraction; denominator must be always positive!
	 */
	private void norm() {
		BigInteger gcd = gcd(numerator, denominator);
		numerator = numerator.divide(gcd);
		denominator = denominator.divide(gcd);

        // make numberator positive
		if (denominator.compareTo(BigInteger.ZERO) < 0) {
			numerator = numerator.negate();
			denominator = denominator.negate();
		}
	}

	// constructors
	/**
	 * default constructor: set fraction to 0/1
	 */
	public BigRational() {
		numerator = BigInteger.ZERO;
		denominator = BigInteger.ONE; 
	}
	/**
	 * generate fraction if denominator and numerator use primitive data type long
	 * @param num numerator
	 * @param den denominator
	 */
	public BigRational(long num, long den) { 
		numerator = BigInteger.valueOf(num);
		denominator = BigInteger.valueOf(den);
		norm();
	}
	/**
	 * generate fraction if denominator and numerator are already of type BigInteger
	 * @param num numerator
	 * @param den denominator
	 */
	public BigRational(BigInteger num, BigInteger den) {
		numerator = num;    // direct assignment of reference (note: BigInteger is immutable)
		denominator = den;
		norm();
	}

	/**
	 * generate fraction from primitive data type long (whole number)
	 * @param val  long
	 */
	public BigRational(long val) {
		this(val, 1);
	}

	/**
	 * generate fraction from primitive data type double
	 * @param val double-Wert
	 */
	public BigRational(double val) { 
		this((long) (val * PRECISION), PRECISION);
	}

	/**
	 * generate fraction if String looks like "x/y" -> x numerator and y denominator
	 * @param val  String
	 */
	public BigRational(String val) {
        // using split function
        String[] parts = val.split(DELIMITER);
        numerator = new BigInteger(parts[0]);
        denominator = new BigInteger(parts[1]);
        norm();

        /* alternative: use Scanner class
        Scanner scanner = new Scanner(val);
        scanner.useDelimiter("/");
        numerator = new BigInteger(scanner.next());
        denominator = new BigInteger(scanner.next());
        norm();
        */

        // error handling can be ignored here!

	}


	// get-Methoden
	public long getNumerator() {
		return numerator.longValue();
	}

	public long getDenominator() { 
		return denominator.longValue();
	}

	// simple conversions
	/**
	 * returns fraction as double by dividing numerator by denominator
	 * @return fraction as double
	 */
	public double doubleValue() {
		return numerator.doubleValue() / denominator.doubleValue();
	}

    /**
     * string representation of fraction
     * @return fraction as "a/b"
     */
    @Override
    public String toString() {
        return numerator.toString() + DELIMITER + denominator.toString();
    }

	/**
	 * Negation = multiply with (-1)
	 * @return negated fraction
	 */
	public BigRational negate() {
		return new BigRational(numerator.negate(), denominator);
	}

	/**
	 * calculate inverted fracdtion
	 * @return inverted fraction (a/b -> b/a)
	 */
	public BigRational invert() {
		return new BigRational(denominator, numerator);
	}

	// operations

    /**
	 * add val to this fraction
     * @param val fraction to be added
	 * @return result
	 */
	public BigRational add(BigRational val) {
		return new BigRational(
				numerator.multiply(val.denominator).add(
						val.numerator.multiply(denominator)),
						denominator.multiply(val.denominator));
        // normalization is done within constructor
	}

	/**
	 * substract val from this fraction
     * @param val fraction to be substracted
	 * @return result
	 */
	public BigRational subtract(BigRational val) {
		return add(val.negate());
	}

	/**
	 * multiply this fraction with val
	 * @param val is multplied with this fraction
	 * @return result
	 */
	public BigRational multiply(BigRational val) {
		// variante 1
		/**
		BigInteger i1 = numerator.multiply(val.numerator);
		BigInteger i2 = denominator.multiply(val.denominator);
		return new BigRational(i1, i2);
		*/

		//variant 2
		return new BigRational(
				numerator.multiply(val.numerator),
				denominator.multiply(val.denominator));
	}

	/**
	 * divides this fraction by val
	 * @param val fraction by which this fraction is divided
	 * @return result
	 */
	public BigRational divide(BigRational val) {
		return multiply(val.invert());
	}

    /**
     * overrides equals from super class "Object"
     * @param obj object to be compared with this object
     * @return true if both objects are "semantically" equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this) // nur zur Performance Optimierung - auch ohne korrekt
            return true;

		// Don't call equals method of super class in this case
        // if (super.equals(obj) == false) return false;

        if (this.getClass() != obj.getClass())
            return false;

        BigRational other = (BigRational) obj;

        // check if numerator and denominator are the same
        if (other.numerator.equals(this.numerator) && other.denominator.equals(this.denominator))
            return true;
        else
            return false;
    }


	/**
	 * overrides hashCode from super class "Object"
	 * @return hash value of the object
	 */
	@Override
	public int hashCode() {
		int result = numerator.hashCode();
		result = 31 * result + denominator.hashCode();
		return result;
	}

	/**
     * compares this fraction with other fraction
     * @param other fraction
     * @return 0 if both are equal; <0 if this < x; >0 if this > x
     */
	public int compareTo(BigRational other) {
		// to compare: extend both fraction to common denominator
	    BigInteger tmp1 = this.numerator.multiply(other.denominator);
		BigInteger tmp2 = other.numerator.multiply(this.denominator);
		return tmp1.compareTo(tmp2);

		// alternative: if result from subtraction is negative, than "this" is smaller than "other"
		//return this.subtract(other).numerator.intValue();
	}



}