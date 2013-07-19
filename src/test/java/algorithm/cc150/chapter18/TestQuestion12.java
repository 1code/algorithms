package algorithm.cc150.chapter18;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
    int[][] mat0 = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };
    int result0 = 9;
    assertEquals(result0, question.maxSubMatrix(mat0));
    
    int[][] mat1 = {
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1}
    };
    int result1 = 36;
    assertEquals(result1, question.maxSubMatrix(mat1));
    
    int[][] mat2 = {
        {2,  2,  2,  2,  2, 2},
        {2, -1, -1, -1, -1, 2},
        {2, -1,  1,  1, -1, 2},
        {2, -1,  1,  1, -1, 2},
        {2, -1, -1, -1, -1, 2},
        {2,  2,  2,  2,  2, 2}
    };
    int results2 = 32;
    assertEquals(results2, question.maxSubMatrix(mat2));
    
    int[][] mat3 = {
        {-1,  2, 2, 2, -1},
        { 2, -1, 1, 1,  1},
        {-2,  1, 1, 1, -1},
        {-2,  1, 1, 1,  1},
        {-2,  1, 1, 1, -1},
    };
    int results3 = 16;
    assertEquals(results3, question.maxSubMatrix(mat3));
    
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }
  
}
