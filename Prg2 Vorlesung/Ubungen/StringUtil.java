/**
 * Created by Wolfgang Mühlbauer on 20.04.2017
 */


import java.util.Arrays;


public class StringUtil {

    /**
     * extracts all String tokens (delimiter: whitespaces) and sorts tokens
     * @param s string from which to extract tokens
     * @return  array of (sorted) strings
     */
    public static String[] string2StringArray(String s) {
        String[] parts = s.split("\\s+");
        Arrays.sort(parts);
        return parts;
    }


    /**
     * joins elements of a String array to a single string; adding 1 whitespace between the different elements
     * (Arrays.toString or join method not allowed)
     * @param arr array of strings
     * @return result
     */
    public static String stringArray2String(String[] arr) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            buf.append(arr[i]);
            if (i < arr.length - 1) buf.append(" ");
        }
        return new String(buf);

    }


    /**
     * checks if two strings are anagrams
     * @param string1
     * @param string2
     * @return true if both strings are anagrams
     */
    public static boolean areAnagrams(String string1, String string2) {

        if (string1.equals(string2)) {
            return false;
        }
        String workingCopy1 = removeJunk(string1);
        String workingCopy2 = removeJunk(string2);

        workingCopy1 = workingCopy1.toLowerCase();
        workingCopy2 = workingCopy2.toLowerCase();

        workingCopy1 = sort(workingCopy1);
        workingCopy2 = sort(workingCopy2);

        return workingCopy1.equals(workingCopy2);
    }

    /**
     * removes all characters of a string that are not letters
     * @param string
     * @return string without "non-letter" characters
     */
    private static String removeJunk(String string) {
        int i, len = string.length();
        StringBuilder dest = new StringBuilder(len);
        char c;

        for (i = (len - 1); i >= 0; i--) {
            c = string.charAt(i);
            if (Character.isLetter(c)) {
                dest.append(c);
            }
        }

        return dest.toString();
    }

    /**
     * take all characters from a string and form a new string where these letters are alphabetically sorted.
     * @param string
     * @return string with same letters but sorted.
     */
    private static String sort(String string) {
        char[] charArray = string.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }


}
