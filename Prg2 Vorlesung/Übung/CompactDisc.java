import java.util.Arrays;


public class CompactDisc implements Comparable<CompactDisc> {

	private final static String[] TO_REMOVE = {"der", "die", "das", "ein", "eine", "einer", "eines", "the", "a"};

	// attributes
	private String interpreter;
	private String title;
	private int yearOfPublication;
	private String recordLabel;

	// Getter (no setter since immutable class is required)
	public String getInterpreter() {
		return interpreter;
	}

	public String getTitle() {
		return title;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	// constructor
	public CompactDisc(String interpreter, String title, int yearOfPublication, String recordLabel) {
		this.interpreter = interpreter;
		this.title = title;
		this.yearOfPublication = yearOfPublication;
		this.recordLabel = recordLabel;
	}


	@Override
	public String toString() {
		return "CD: '" + title + "' von '" + interpreter + "' im Jahr "
				+ yearOfPublication + " bei '" + recordLabel + "'";
	}

	@Override
	public int hashCode() {
		int result = (interpreter == null) ? 0 : interpreter.toLowerCase().hashCode();
		result = 31 * result + ((title == null) ? 0 : title.toLowerCase().hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (this.getClass() != obj.getClass())
			return false;

		CompactDisc other = (CompactDisc) obj;
		if (interpreter == null) {
			if (other.interpreter != null)
				return false;
		} else if (!interpreter.toLowerCase().equals(other.interpreter.toLowerCase()))
			return false;

		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.toLowerCase().equals(other.title.toLowerCase()))
			return false;
		return true;
 	}





	@Override
	public int compareTo(CompactDisc other) {

		// sort tokens that should not be considered ("der", "die", "das", ...)
		String[] toRemoveSorted = Arrays.copyOf(TO_REMOVE, TO_REMOVE.length);
		Arrays.sort(toRemoveSorted);


		// determine first word for both interpreters (in lower case)
		String interpreterLC = interpreter.toLowerCase();
		String otherInterpreterLC = other.interpreter.toLowerCase();
		String thisFirstToken = interpreterLC.split(" ")[0];
		String otherFirstToken = otherInterpreterLC.split(" ")[0];

		// check for both interpreters if first word must be ignored -> if yes then remove it
		if(Arrays.binarySearch(toRemoveSorted, thisFirstToken) >= 0) {
			interpreterLC = interpreterLC.substring(thisFirstToken.length());
		}
		if(Arrays.binarySearch(toRemoveSorted, otherFirstToken)>=0) {
			otherInterpreterLC = otherInterpreterLC.substring(otherFirstToken.length());
		}

		// call compareTo on the two strings (class String already implements compareTo method)
		return interpreterLC.trim().compareTo(otherInterpreterLC.trim());
	}


	/*
	// alternative 1: implementation with substring
	@Override
	public int compareTo(CompactDisc other) {

		String interpretLC = interpreter.toLowerCase();
		String otherInterpretLC = other.interpreter.toLowerCase();

		// Hint: Be careful -> Do not change interpretLC and otherInterpretLC -> violates immutability of class!
		String interpretClean = interpretLC;
		String otherInterpretClean = otherInterpretLC;

		// iterate over all beginning words that should be ignored
		// if interpreter begins with such a word, then remove it
		for (int i = 0; i < TO_REMOVE.length; i++) {
			if (interpretLC.substring(0,
					Math.min(interpretLC.length(), TO_REMOVE[i].length()))
					.equals(TO_REMOVE[i])) {
				interpretClean = interpretLC.substring(TO_REMOVE[i].length());
			}
			if (otherInterpretLC.substring(0,
					Math.min(otherInterpretLC.length(), TO_REMOVE[i].length()))
					.equals(TO_REMOVE[i])) {
				otherInterpretClean = otherInterpretLC.substring(TO_REMOVE[i]
						.length());
			}
		}
		// call compareTo on the two strings (class String already implements compareTo method)
		return interpretClean.trim().compareTo(otherInterpretClean.trim());
	}
	*/

/*
	// alternative 2: implementation with regular expression
	@Override
	public int compareTo(CompactDisc other) {

	    String toReplace = "(?i)((der)|(die)|(das)|(ein)|(eine)|(einer)|(eines)|(the)|(a))\\s";

	    return this.interpreter.replaceFirst(toReplace, "").trim().compareToIgnoreCase(other.interpreter.replaceFirst(toReplace, "").trim());
	}
	*/


}


