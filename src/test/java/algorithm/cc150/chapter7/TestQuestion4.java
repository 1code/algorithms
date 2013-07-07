package algorithm.cc150.chapter7;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write methods to implement the multiply, subtract, and divide operations for
 * integers. Use only the add operator.
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
    int a1 = -5;
    int b1 = 2;
    assertEquals(a1 - b1, question.subtract(a1, b1));
    assertEquals(a1 * b1, question.mul(a1, b1));
    assertEquals(a1 / b1, question.div(a1, b1));
    
    int a2 = 30;
    int b2 = -4;
    assertEquals(a2 - b2, question.subtract(a2, b2));
    assertEquals(a2 * b2, question.mul(a2, b2));
    assertEquals(a2 / b2, question.div(a2, b2));
    
    Random rnd = new Random();
    for (int c = 0; c < 10; ++c) {
      int a = rnd.nextInt(1000) - 500;
      int b = rnd.nextInt(1000) - 500;
      assertEquals(a - b, question.subtract(a, b));
      assertEquals(a * b, question.mul(a, b));
      assertEquals(a / b, question.div(a, b));
    }
  }

  @Override
  @Test
  public void testNegCase() {
    // TODO Auto-generated method stub

  }

}
