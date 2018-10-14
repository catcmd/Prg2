/**
 * Created by Wolfgang Mühlbauer on 03.06.2016.
 */


import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static junit.framework.TestCase.assertTrue;


public class TestUtil {

	private List<String> list1;
	private List<String> list2;

	@Before
	public void setUp() {
		list1 = new ArrayList<String>();
		list1.addAll(
				Arrays.asList(
						new String[] { "wort1", "wort2", "wort3", "wort4", "wort5" }));
		list2 = new ArrayList<String>();
		list2.addAll(
				Arrays.asList(
						new String[] { "wort5", "wort4", "wort3", "wort2", "wort1" }));
	}


	@Test
	public void testReverse2() {
		List<String> list3 = Util.reverse2(list1);
		assertTrue(list2.equals(list3));
	}

	@Test
	public void testReverse1() {
		Util.reverse1(list2);
		assertTrue(list1.equals(list2));
	}

}
