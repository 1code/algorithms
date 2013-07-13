package algorithm.cc150.chapter17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Design an algorithm which counts the number of trailing zeros in n factorial.
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
    assertEquals(0, question.numZeros(0));
    assertEquals(0, question.numZeros(1));
    assertEquals(0, question.numZeros(2));
    assertEquals(0, question.numZeros(3));
    assertEquals(0, question.numZeros(4));
    assertEquals(1, question.numZeros(5));
    assertEquals(1, question.numZeros(6));
    assertEquals(1, question.numZeros(7));
    assertEquals(1, question.numZeros(8));
    assertEquals(1, question.numZeros(9));
    assertEquals(2, question.numZeros(10));
    assertEquals(2, question.numZeros(11));
    assertEquals(2, question.numZeros(12));
    assertEquals(2, question.numZeros(13));
    assertEquals(2, question.numZeros(14));
    assertEquals(3, question.numZeros(15));
    assertEquals(4, question.numZeros(20));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
