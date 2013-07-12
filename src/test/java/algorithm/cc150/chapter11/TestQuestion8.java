package algorithm.cc150.chapter11;

import static org.junit.Assert.assertEquals;

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
    int[] stream = {1, 2, 3, 4, 6, 1, 2, 7, 4, 2, 3, 2, 1, 5,  6,  7,  9, 10};
    int[] ranks =  {0, 1, 2, 3, 4, 1, 3, 7, 6, 4, 6, 5, 2, 11, 13, 15, 16, 17};
    for (int i = 0; i < stream.length; ++i) {
      question.track(stream[i]);
      assertEquals(ranks[i], question.getRankOfNumber(stream[i]));
    }
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

}
