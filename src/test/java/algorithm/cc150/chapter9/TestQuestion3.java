package algorithm.cc150.chapter9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]
 * = i. Given a sorted array, write a method to find a magic index, if one
 * exists, in array A.
 * 
 * FOLLOW UP What if the values are not distinct?
 * 
 */
public class TestQuestion3 extends TestBase {

  private Question3 question;

  @Override
  protected void initInstance() {
    question = new Question3();
  }

  @Override
  @Test
  public void testPosCase() {
    int[] arr1 = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
    assertEquals(7, question.findMagicIndex(arr1));
    
    int[] arr2 = {-1, -1, 2, 2, 3, 4, 5, 6, 7};
    assertEquals(2, question.findMagicIndex(arr2));
    
    int[] arr3 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    assertEquals(5, question.findMagicIndex(arr3));
  }

  @Override
  @Test
  public void testNegCase() {

  }

}
