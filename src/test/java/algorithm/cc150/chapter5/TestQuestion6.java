package algorithm.cc150.chapter5;

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
		
	}

	@Override
	@Test
	public void testNegCase() {
		//	no negative case
	}

}
