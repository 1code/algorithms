package algorithm.cc150.chapter7;

import org.junit.Test;

import algorithm.TestBase;

/**
 * There are three ants on different vertices of a triangle. What is the 
 * probability of collision (between any two or all of them) if they start
 * walking on the sides of the triangle? Assume that each ant randomly picks 
 * a direction, with either direction being equally likely to be chosen,
 * and that they walk at the same speed.
 * Assume they will stop once they come to another vertex.
 */
public class TestQuestion2 extends TestBase {

	private Question2 question;
	@Override
	protected void initInstance() {
		question = new Question2();
	}

	@Override
	@Test
	public void testPosCase() {
		
	}

	@Override
	@Test
	public void testNegCase() {
		// TODO Auto-generated method stub
		
	}

}
