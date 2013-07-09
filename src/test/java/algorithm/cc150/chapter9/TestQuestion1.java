package algorithm.cc150.chapter9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2
 * steps or 3 steps at a time. Implement a method to count how many possible
 * ways the child can run up the stairs.
 * 
 */
public class TestQuestion1 extends TestBase {

  private Question1 question;

  @Override
  protected void initInstance() {
    question = new Question1();
  }

  @Override
  @Test
  public void testPosCase() {
    assertEquals(0, question.numOfWays(0));
    assertEquals(1, question.numOfWays(1));
    assertEquals(2, question.numOfWays(2));
    assertEquals(4, question.numOfWays(3));
    assertEquals(7, question.numOfWays(4));
    assertEquals(13, question.numOfWays(5));
    assertEquals(24, question.numOfWays(6));
    assertEquals(44, question.numOfWays(7));
    assertEquals(81, question.numOfWays(8));
    assertEquals(149, question.numOfWays(9));

    assertEquals(501774317241l, question.numOfWays(45));
    assertEquals(5742568741225l, question.numOfWays(49));
    assertEquals(4680045560037375l, question.numOfWays(60));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
