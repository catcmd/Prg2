import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Wolfgang Mühlbauer on 19.05.2017.
 */
public class StringUtilTest {


    @Test
    public void testString2StringArray1() {
        String s = "kurt fährt auto";
        String[] expected = {"auto", "fährt", "kurt"};
        String[] actualResult = StringUtil.string2StringArray(s);
        assertArrayEquals("Single whitespaces as delimiter", expected, actualResult);
    }






















    @Test
    public void testString2StringArray2() {
        String s = "kurt fährt     auto";
        String[] array = {"auto", "fährt", "kurt"};
        assertArrayEquals("Multiple whitespaces as delimiter", array, StringUtil.string2StringArray(s));
    }

    @Test
    public void stringArray2String() {
        String[] array = {"kurt", "fährt", "auto"};
        assertEquals("kurt fährt auto", StringUtil.stringArray2String(array));
    }

    @Test
    public void testAreAnagrams() {
        assertTrue("Anagram with whitespaces", StringUtil.areAnagrams("Debit Card", "Bad Credit"));
        assertTrue("Anagram with whitespaces", StringUtil.areAnagrams("derbe Hotline", "Bohlen, Dieter"));
        assertFalse("Same words", StringUtil.areAnagrams("Haus", "Haus"));
        assertFalse("Same words", StringUtil.areAnagrams("joy", "enjoy"));

    }


}