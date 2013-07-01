package algorithm.cc150.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * An array A contains all the integers from 0 to n, except for one number which
 * is missing. In this problem, we cannot access an entire integer in A with a
 * single operation. The elements of A are represented in binary, and the only
 * operation we can use to access them is "fetch the jth bit of A[i]", which
 * takes constant time. Write code to find the missing integer. Can you do it in
 * O(n) time?
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
    int[] arr1 = { 1, 2, 3, 4, 5 };
    assertEquals(0, question.findMissing(arr1, 5));

    int[] arr2 = { 0, 1, 2, 3, 5, 6, 7, 8, 9, 10 };
    assertEquals(0, question.findMissing(arr2, 10));

    int[] arr3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertEquals(10, question.findMissing(arr3, 10));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
