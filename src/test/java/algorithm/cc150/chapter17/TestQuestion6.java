package algorithm.cc150.chapter17;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import algorithm.TestBase;

/**
 * Given an array of integers, write a method to find indices m and n such that
 * if you sorted elements m through n, the entire array would be sorted.
 * Minimize n - m (that is, find the smallest such sequence).
 * 
 * EXAMPLE
 * Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 * Result: 3, 9
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
    int[] arr1 = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
    assertArrayEquals(new int[] {3, 9}, question.findIndices(arr1));
    int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
    assertArrayEquals(new int[] {-1, -1}, question.findIndices(arr2));
    int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    assertArrayEquals(new int[] {0, 8}, question.findIndices(arr3));
    int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 3, 6, 7, 8, 9};
    assertArrayEquals(new int[] {3, 8}, question.findIndices(arr4));
    int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    assertArrayEquals(new int[] {0, 9}, question.findIndices(arr5));
  }

  @Override
  @Test
  public void testNegCase() {   
    // no negative case
  }

}
