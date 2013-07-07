package algorithm.cc150.chapter7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

/**
 * There are three ants on different vertices of a triangle. What is the
 * probability of collision (between any two or all of them) if they start
 * walking on the sides of the triangle? Assume that each ant randomly picks a
 * direction, with either direction being equally likely to be chosen, and that
 * they walk at the same speed. Assume they will stop once they come to another
 * vertex.
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
    int n1 = 3;
    assertEquals(0.75, question.probability(n1), 0.000001);
    int n2 = 4;
    assertEquals(0.875, question.probability(n2), 0.000001);
    int n3 = 5;
    assertEquals(0.9375, question.probability(n3), 0.000001);
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

}
