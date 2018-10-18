/**
 * Created by Wolfgang Mühlbauer on 03.06.2016.
 */

import java.util.*;


/** abstract class  */
public abstract class Util {

	/**
	 * reverse the order of the elements in "list". Do not create a new list.
	 *
	 *  @param list list to be reversed
	 *  @return new list with reversed order
	 */
	public static <E> void reverse1(List<E> list) {
		int i = 0;
		int j = list.size() - 1;

		// i moves from left to right, j from right to left; stop when i and j meet
		while (i < j) {
			// swap elements at position i and j
			E t = list.get(i);
			list.set(i++, list.get(j));
			list.set(j--, t);
		}
	}

	/** creates a new list that contains all elements of "list" in the reversed order.
	 *  Data type of result is the same as of "list" if a default constructor exists.
	 *  Otherwise, the result has the data type array list.
	 *
	 *  @param list list to be reversed
	 *  @return new list with reversed order
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> reverse2(List<E> list) {
		List<E> result = null;
		try {
			result = list.getClass().newInstance();
		} catch (Exception e) {
			result = new ArrayList<E>();
		}

		for (int i = list.size()-1; i >= 0; i--) {
			result.add(list.get(i));
		}
		return result;
	}



	/*
	// alternative without generics
	public static List<Object> reverse2(List<Object> list) {
		List<Object> result = null;
		try {
			result = (List<Object>) list.getClass().newInstance();
		} catch (Exception e) {
			result = new ArrayList<Object>();
		}

		for (int i = list.size()-1; i >= 0; i--) {
			result.add(list.get(i));
		}
		return result;
	}
	*/



}
