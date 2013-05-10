package algorithm.cc150.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import algorithm.cc150.TestBase;

public class TestQuestion1 extends TestBase{
	
	private Question1 question;
	
	@Override
	protected void initInstance() {
		question = new Question1();
	}
	
	@Test
	public void testEmptyString() {
		assertTrue(question.allUnique(""));
	}
	
	@Test
	public void testUniqueStrings() {
		assertTrue(question.allUnique("12345abcde"));
		assertTrue(question.allUnique("1SD&^@2345abcde"));
	}
	
	public void testNonUniqueStrings() {
		assertFalse(question.allUnique("abcdefge"));
		assertFalse(question.allUnique("abcdefge_12345a"));
		assertFalse(question.allUnique("(#*&Q$KDFSDFLJdsfus"));
	}

	
}
