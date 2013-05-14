package algorithm.cc150.chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 *
 */
public class TestQuestion1 extends TestBase{
	
	private Question1 question;
	
	@Override
	protected void initInstance() {
		question = new Question1();
	}

	@Override
	@Test
	public void testPosCase() {
		assertTrue(question.allUnique(""));
		assertTrue(question.allUnique("12345abcde"));
		assertTrue(question.allUnique("1SD&^@ 2345abcde"));
	}

	@Override
	@Test
	public void testNegCase() {
		assertFalse(question.allUnique("aaaaaaa"));
		assertFalse(question.allUnique("abcdefge"));
		assertFalse(question.allUnique("abcdefge_12345a"));
		assertFalse(question.allUnique("(#*&Q$KDFSDFLJdsfus"));
	}

	
}
