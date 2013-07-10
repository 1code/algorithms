package algorithm.cc150.chapter9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5
 * cents) and pennies (1 cent), write code to calculate the number of ways of
 * representing n cents.
 * 
 */
public class TestQuestion8 extends TestBase {

  private Question8 question;

  @Override
  protected void initInstance() {
    question = new Question8();
  }

  @Override
  @Test
  public void testPosCase() {
    int n0 = 0;
    assertEquals(1, question.numberOfWays(n0));
    int n1 = 5;
    assertEquals(2, question.numberOfWays(n1));
    int n2 = 6;
    assertEquals(2, question.numberOfWays(n2));
    int n3 = 10;
    assertEquals(4, question.numberOfWays(n3));
    int n4 = 20;
    assertEquals(9, question.numberOfWays(n4));
    int n5 = 25;
    assertEquals(13, question.numberOfWays(n5));
  }

  @Override
  @Test
  public void testNegCase() {
    // TODO Auto-generated method stub

  }

}
