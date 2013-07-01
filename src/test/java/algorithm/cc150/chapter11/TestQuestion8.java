package algorithm.cc150.chapter11;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Imagine you are reading in a stream of integers. Periodically, you wish to be
 * able to look up the rank of a number x (the number of values less than or
 * equal to x). Implement the data structures and algorithms to support these
 * operations. That is, implement the method track(int x), which is called when
 * each number is generated, and the method getRankOfNumber(int x), which
 * returns the number of values less than or equal to x (not including x
 * itself).
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
    // TODO Auto-generated method stub

  }

  @Override
  @Test
  public void testNegCase() {
    // TODO Auto-generated method stub

  }

}
