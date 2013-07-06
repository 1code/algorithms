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
    assertEquals(7, question.prev(11));
    assertEquals(13, question.next(11));
    assertEquals(11, question.prev(13));
    assertEquals(11, question.next(7));
    assertEquals(2, question.next(1));
    assertEquals(1, question.prev(2));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
