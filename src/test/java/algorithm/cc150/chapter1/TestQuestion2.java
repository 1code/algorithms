package algorithm.cc150.chapter1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import algorithm.TestBase;


/**
 * Implement a function void reverse(char[] str) which reverses a null-terminated string.
 *
 */
public class TestQuestion2 extends TestBase{

	private Question2 question;
	
	@Override
	protected void initInstance() {
		question = new Question2();
	}
	
	@Override
	public void testPosCase() {
		assertTrue(Arrays.equals("".toCharArray(), question.reverse(null)));
		
		assertArrayEquals("".toCharArray(), question.reverse("".toCharArray()));
		
		assertArrayEquals("abcde".toCharArray(), question.reverse("edcba".toCharArray()));
		assertArrayEquals(" ".toCharArray(), question.reverse(" ".toCharArray()));
		assertArrayEquals("1234567890!@#$%^&*()".toCharArray(), question.reverse(")(*&^%$#@!0987654321".toCharArray()));
	}

	@Override
	public void testNegCase() {
		assertFalse(Arrays.equals("abc".toCharArray(), question.reverse("abc".toCharArray())));
	}

	
}
