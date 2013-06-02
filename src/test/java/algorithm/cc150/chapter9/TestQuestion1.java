package algorithm.cc150.chapter9;

import org.junit.Test;

import algorithm.TestBase;

/**
 * 	A child is running up a staircase with n steps, and can hop either 1 step, 
 * 	2 steps or 3 steps at a time. Implement a method to count how many possible 
 * 	ways the child can run up the stairs.
 *
 */
public class TestQuestion1 extends TestBase {

	private Question1 question;
	@Override
	protected void initInstance() {
		question = new Question1();
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
