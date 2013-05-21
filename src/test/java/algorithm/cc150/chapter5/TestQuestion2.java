package algorithm.cc150.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
 * print the binary representation. If the number cannot be represented accurately
 * in binary with less than 32 characters, print "ERROR". 
 *
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
		//	these test cases have some problems
		assertEquals("00111111001110000101000111101100", question.binary(0.72));
		assertEquals("00111110101000111101011100001010", question.binary(0.32));
		assertEquals("00111111011001100110011001100110", question.binary(0.90));
	}

	@Override
	@Test
	public void testNegCase() {
		//	no negative case
	}

}
