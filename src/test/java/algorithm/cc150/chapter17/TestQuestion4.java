package algorithm.cc150.chapter17;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write a method which finds the maximum of two numbers. You should not use
 * if-else or any other comparison operator.
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
    Random rnd = new Random();
    for (int c = 0; c < 1000000; ++c) {
      int a = rnd.nextInt();
      int b = rnd.nextInt();
      assertEquals(Math.max(a, b), question.max(a, b));
    }
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

}
