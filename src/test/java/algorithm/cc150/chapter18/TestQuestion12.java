package algorithm.cc150.chapter18;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given an NxN matrix of positive and negative integers, write code to find the
 * submatrix with the largest possible sum.
 * 
 */
public class TestQuestion12 extends TestBase {
  
  private Question12 question;

  @Override
  protected void initInstance() {
    question = new Question12();
  }

  @Override
  @Test
  public void testPosCase() {
    int[][] mat1 = {
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1}
    };
    int[] results1 = {0, 0, 5, 5};
    assertArrayEquals(results1, question.maxSubMatrix(mat1));
    
    int[][] mat2 = {
        {2,  2,  2,  2,  2, 2},
        {2, -1, -1, -1, -1, 2},
        {2, -1,  1,  1, -1, 2},
        {2, -1,  1,  1, -1, 2},
        {2, -1, -1, -1, -1, 2},
        {2,  2,  2,  2,  2, 2}
    };
    int[] results2 = {0, 0, 5, 5};
    assertArrayEquals(results2, question.maxSubMatrix(mat2));
    
    int[][] mat3 = {
        {-1,  2, 2, 2, -1},
        { 2, -1, 1, 1,  1},
        {-2,  1, 1, 1, -1},
        {-2,  1, 1, 1,  1},
        {-2,  1, 1, 1, -1},
    };
    int[] results3 = {0, 1, 4, 3};
    assertArrayEquals(results3, question.maxSubMatrix(mat3));
    
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }
  
}
