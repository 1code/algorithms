package algorithm.cc150.chapter18;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Write a function to add two number without add operation.
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
    Random rnd = new Random();
    for (int c = 0; c < 100; ++c) {
      int a = rnd.nextInt(100000000);
      int b = rnd.nextInt(100000000);
      assertEquals(a + b, question.add(a, b));
    }
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
