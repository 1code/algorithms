package algorithm.cc150.chapter17;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import algorithm.TestBase;

/**
 * You are given an array of integers (both positive and negative). Find the
 * contiguous sequence with the largest sum. Return the sum. EXAMPLE Input: 2,
 * -8, 3, -2, 4, -10 Output: 5
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
    int[] arr1 = { -2, -6, -1, -5, -7, -9, -3 };
    assertEquals(-1, question.largestContinuousSum(arr1));
    int[] arr2 = { -1, 1, -3, 5, 1, -2, 7, -1 };
    assertEquals(11, question.largestContinuousSum(arr2));
    int[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    assertEquals(55, question.largestContinuousSum(arr3));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
