package algorithm.cc150.chapter1;

/**
 * Implement a function void reverse(String str) which reverses a null-terminated string.
 *
 */
public class Question2 {
	public char[] reverse(char[] str) {
		if (str == null)
			return new char[]{};
		
		for (int i = 0; i < str.length / 2; ++i) {
			char tmp = str[i];
			str[i] = str[str.length - i - 1];
			str[str.length - i - 1] = tmp;
		}
		return str;
	}
}
