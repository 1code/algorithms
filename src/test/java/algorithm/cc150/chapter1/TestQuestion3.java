package algorithm.cc150.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 */
public class TestQuestion3 extends TestBase {

	private Question3 question;
	@Override
	protected void initInstance() {
		// TODO Auto-generated method stub
		question = new Question3();
	}

	@Override
	@Test
	public void testPosCase() {
		// TODO Auto-generated method stub
		assertTrue(question.isPermutation("", ""));
		assertTrue(question.isPermutation("abcde", "bdeac"));
		assertTrue(question.isPermutation("@!#$%^&*()", ")(*&^%$#!@"));
		assertTrue(question.isPermutation("aaa", "aaa"));
	}

	@Override
	@Test
	public void testNegCase() {
		// TODO Auto-generated method stub
		assertFalse(question.isPermutation(null, ""));
		assertFalse(question.isPermutation("", null));
		assertFalse(question.isPermutation("aaa", "aaaa"));
		assertFalse(question.isPermutation("Aaa", "aaa"));
		assertFalse(question.isPermutation("ASDFQER@#$dsaf3dffa3", "ASFD#@fst4WEF@3 sdFA"));
	}

}
