package algorithm.cc150.chapter7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Design an algorithm to find the kth number such that the only prime factors
 * are 3, 5, and 7.
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
    assertEquals(0, question.kth(0));
    assertEquals(3, question.kth(1));
    assertEquals(5, question.kth(2));
    assertEquals(7, question.kth(3));
    assertEquals(9, question.kth(4));
    assertEquals(15, question.kth(5));
    assertEquals(21, question.kth(6));
    assertEquals(25, question.kth(7));
    assertEquals(27, question.kth(8));
    assertEquals(35, question.kth(9));
    assertEquals(45, question.kth(10));
    assertEquals(49, question.kth(11));
    assertEquals(63, question.kth(12));
  }

  @Override
  @Test
  public void testNegCase() {

  }

}
