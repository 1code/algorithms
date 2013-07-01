package algorithm.cc150.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given a positive integer, print the next smallest and the next largest number
 * that have the same number of 1 bits in their binary representation.
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
    assertEquals(7, question.nextSmallest(11));
    assertEquals(13, question.nextLargest(11));
    assertEquals(11, question.nextSmallest(13));
    assertEquals(11, question.nextLargest(7));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
