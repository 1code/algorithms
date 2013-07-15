package algorithm.cc150.chapter18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Count the number of digit '2' within range of 0 to n.
 * 
 */
public class TestQuestion4 extends TestBase {

  private Question4 question;

  @Override
  protected void initInstance() {
    question = new Question4();
  }

  @Override
  @Test
  public void testPosCase() {
    int t0 = 0;
    assertEquals(0, question.numOf2(t0));
    int t1 = 2;
    assertEquals(1, question.numOf2(t1));
    int t2 = 10;
    assertEquals(1, question.numOf2(t2));
    int t3 = 12;
    assertEquals(2, question.numOf2(t3));
    int t4 = 20;
    assertEquals(3, question.numOf2(t4));
    int t5 = 21;
    assertEquals(4, question.numOf2(t5));
    int t6 = 22;
    assertEquals(6, question.numOf2(t6));
    
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
