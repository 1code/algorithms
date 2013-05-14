package algorithm.cc150.chapter1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0. Do this in place.
 *
 */
public class TestQuestion7 extends TestBase {

	private Question7 question;
	
	@Override
	protected void initInstance() {
		question = new Question7();
	}

	@Override
	@Test
	public void testPosCase() {
		int[][] case1 = {
				{1, 0, 2, 0, 3},
				{1, 1, 3, 3, 2}
		};
		
		int[][] expectedCase1 = {
				{0, 0, 0, 0, 0},
				{1, 0, 3, 0, 2}
		};
		question.resetMatrix(case1);
		assertArrayEquals(expectedCase1, case1);
		
		int[][] case2 = {
				{1, 1, 2, 3, 0, 1},
				{1, 2, 0, 3, 3, 5},
				{3, 5, 1, 3, 1, 5}
		};
		
		int[][] expectedCase2 = {
				{0, 0, 0, 0, 0, 0},
				{0, 0 ,0, 0, 0, 0},
				{3, 5, 0, 3, 0, 5}
		};
		question.resetMatrix(case2);
		assertArrayEquals(expectedCase2, case2);
		
		int[][] case3 = {
				{0, 1, 2, 3, 4},
				{5, 5, 2, 2, 1},
				{6, 2, 5, 2, 6},
				{6, 1, 9, 8, 0}
		};
		int[][] expectedCase3 = {
				{0, 0, 0, 0, 0},
				{0, 5, 2, 2, 0},
				{0, 2, 5, 2, 6},
				{0, 0, 0, 0, 0}
		};
		question.resetMatrix(case3);
		assertArrayEquals(expectedCase3, case3);
		
		int[][] case4 = {
				
		};
		int[][] expectedCase4 = {
				
		};
		try {
			question.resetMatrix(case4);
			assertArrayEquals(expectedCase4, case4);
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}

	@Override
	@Test
	public void testNegCase() {
	}

}
