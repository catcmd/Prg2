import org.junit.*;

import java.util.*;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * Created by Wolfgang Mühlbauer on 03.06.2016.
 */





public class TestIndex  {

	private static Logger logger = Logger.getLogger(Index.class.getName());

	private List<String>[] book = null;
	private Set<String> keywords = null;

	@Before
	public void setUp() {
		// generate book with 6 pages and a few keywords

		book = new List[6];

		//	no entries on page 0
		book[0] = new ArrayList<String>();

		book[1] = new ArrayList<String>();
		book[1].add("otto");
		book[1].add("robert");
		book[1].add("hugo");

		book[2] = new ArrayList<String>();
		book[2].add("otto");
		book[2].add("ernst");
		book[2].add("rudi");

		// no entries on page 3
		book[3] = new ArrayList<String>();

		book[4] = new ArrayList<String>();
		book[4].add("otto");
		book[4].add("hugo");
		book[4].add("jack");

		book[5] = new ArrayList<String>();
		book[5].add("otto");
		book[5].add("susi");
		book[5].add("jack");

		keywords = new HashSet<String>();
		keywords.add("otto");
		keywords.add("susi");
		keywords.add("jack");
	}

	@Test
	public void testIndex() {
		Map<String, SortedSet<Integer>> idx = Index.makeIndex(book);
		assertEquals("Size of Index", 7, idx.size());
		assertEquals("Pages where otto shows up", 4, idx.get("otto").size());
		assertTrue(idx.get("otto").contains(1));
		assertTrue(idx.get("otto").contains(2));
		assertTrue(idx.get("otto").contains(4));
		assertTrue(idx.get("otto").contains(5));
		assertFalse(idx.get("susi").contains(3));

		logger.info("\n" + Index.toString(idx));
	}



}
