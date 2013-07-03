package algorithm.cc150.chapter3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * /** How would you design a stack which, in addition to push and pop, also has
 * a function min which returns the minimum elements? Push, pop and min should
 * all operate in O(1) time.
 * 
 */
public class TestQuestion2 extends TestBase {

  private Question2 question;

  @Override
  protected void initInstance() {
    question = new Question2();
  }

  @Override
  @Test
  public void testPosCase() {
    question.push(10); // [10] <- top     min: 10
    question.push(15); // [10 15] <- top  min: 10
    question.push(2); // [10 15 2] <- top  min: 2
    question.push(2); // [10 15 2 2] <- top  min: 2
    question.push(11); // [10 15 2 2 11] <- top  min: 2
    assertEquals(2, question.min());
    assertEquals(11, question.pop()); // [10 15 2 2] <- top    min: 2
    assertEquals(2, question.pop()); // [10 15 2] <- top     min: 2
    question.push(1); // [10 15 2 1] <- top      min: 1
    assertEquals(1, question.min());
    assertEquals(1, question.pop()); // [10 15 2] <- top      min: 1
    assertEquals(2, question.min());
    assertEquals(2, question.pop()); // [10 15] <- top       min: 10
    assertEquals(10, question.min());
    assertEquals(15, question.pop()); // [10 15] <- top      min: 10
    assertEquals(10, question.min());
  }

  @Override
  @Test
  public void testNegCase() {
  }

}
