package me.coley.util;

public class StringUtil {

	/**
	 * Gets the selected word based on the given position in the given text.
	 * 
	 * @param pos
	 * @param text
	 * @return
	 */
	public static String getWordAtIndex(int pos, String text) {
		return getWordAtIndex(pos, text, false);
	}

	/**
	 * Gets the selected word based on the given position in the given text.
	 * Allows for the '/' char to be counted as a word character.
	 * 
	 * @param pos
	 * @param text
	 * @param extra
	 *            '/' counting as a word char
	 * @return
	 */
	public static String getWordAtIndex(int pos, String text, boolean extra) {
		int index;
		int index2;
		for (index = pos - 1; index > 0 && !StringUtil.isNonWord(text.charAt(index), extra); index--);
		for (index2 = pos; index2 < text.length() && !StringUtil.isNonWord(text.charAt(index2), extra); index2++);
		return text.substring(index + 1, index2);
	}

	/**
	 * Checks if the given character is a non-word character.
	 * 
	 * @param c
	 * @param extra
	 *            True if including '/' as a word-character.
	 * @return
	 */
	public static boolean isNonWord(char c, boolean extra) {
		if (c >= 'a' && c <= 'z') {
			return false;
		}
		if (c >= 'A' && c <= 'Z') {
			return false;
		}
		if (c >= '0' && c <= '9') {
			return false;
		}
		if (extra && c == '/') {
			return false;
		}
		return true;
	}

}
