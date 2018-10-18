/**
 *
 * Created by Wolfgang Mühlbauer on 03.06.2016.
 */

import java.util.*;


public abstract class Index {

	/**
	 * generate index (data structure "map") where key is a string that represents the keyword and
	 * value is a set (sorted by increasing page number) with all book pages on which the keyword appears.
	 * 
	 * @param keywords array of lists where each lists contains the keywords of an individual book page
	 * @return index where key is a String with the keyword, and value how often keyword occurs in book.
	 */
	public static Map<String, SortedSet<Integer>> makeIndex(List<String>[] keywords) {

		// Hint 1: Since index must be sorted alphabetically, TreeMap must be used and not HashMap!
		// Hint 2: wrapper "Integer" must be used since primitive data types not allowed in Java Collection
		Map<String, SortedSet<Integer>> result = new TreeMap<String, SortedSet<Integer>>();

		// iterate over all book pages (array!)
		for (int page = 0; page < keywords.length; ++page) {

			// iterate over all keywords of a book page (List!)
			for (int i = 0; i < keywords[page].size(); i++) {

				String keyword = keywords[page].get(i);

				// check if keyword was already found on a previous page
				SortedSet<Integer> pages = result.get(keyword);
				if (pages == null) {
					// if keyword hit the first time, create new empty TreeSet
					// no HashSet to get increasing page numbers
					pages = new TreeSet<Integer>();
					result.put(keyword, pages);
				}
				pages.add(new Integer(page));

			}
		}

		return result;
	}



	/**
	 * returns a string with the content of the index (one line per keyword)
	 *
	 * @return string that displays the content of the index.
	 */
	public static String toString(Map<String, SortedSet<Integer>> idx) {

		StringBuffer result = new StringBuffer();

		for (Map.Entry<String, SortedSet<Integer>> e : idx.entrySet()) {

			String keyword = e.getKey();
			SortedSet<Integer> pages = e.getValue();
			result.append(keyword + ": ");

			// iterate over all pages with keyword using for each loop
			for (Integer i : pages) {
			// alternative -> for (int i = 0; i < pages.size(), i++) ....
				result.append(i + " ");
			}
			result.append("\n");

		}
		return result.toString();
	}


	public void test() {

	}
}
