package algorithm.cc150.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write a program to swap odd and even bits in an integer with
 * as few instructions as possible (e.g., bit 0 and bit 1 are swapped, 
 * bit 2 and bit 3 are swapped, and so on). 
 *
 */
public class TestQuestion6 extends TestBase {

	private Question6 question;
	
	@Override
	protected void initInstance() {
		question = new Question6();
	}

	@Override
	@Test
	public void testPosCase() {
		assertEquals(38, question.numInstructions(25));
		assertEquals(15, question.numInstructions(15));
		assertEquals(33, question.numInstructions(18));
		assertEquals(10, question.numInstructions(5));
		assertEquals(0, question.numInstructions(0));
	}

	@Override
	@Test
	public void testNegCase() {
		//	no negative case
	}

}
