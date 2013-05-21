package algorithm.cc150.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write a function to determine the number of bits required to 
 * convert integer A to integer B. 
 *
 */
public class TestQuestion5 extends TestBase {

	private Question5 question;
	
	@Override
	protected void initInstance() {
		question = new Question5();
	}

	@Override
	@Test
	public void testPosCase() {
		int A1 = 7;		//	0111
		int B1 = 11;	//	1011
		assertEquals(2, question.convertSteps(A1, B1));
		
		int A2 = 15;	//	1111
		int B2 = 1;		//	0001
		assertEquals(3, question.convertSteps(A2, B2));
		
		int A3 = 0;		//	000000
		int B3 = 32;	//	100000
		assertEquals(1, question.convertSteps(A3, B3));
		
		int A4 = 0;		//	00000
		int B4 = 31;	//	11111
		assertEquals(5, question.convertSteps(A4, B4));
	}

	@Override
	@Test
	public void testNegCase() {
		//	no negative case
	}

}
