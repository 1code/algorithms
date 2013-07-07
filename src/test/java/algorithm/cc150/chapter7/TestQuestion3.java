package algorithm.cc150.chapter7;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given two lines on a Cartesian plane, determine whether the two lines would
 * intersect.
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
    double x11 = 0;
    double y11 = 0;
    double x12 = 2;
    double y12 = 2;
    double x13 = 0;
    double y13 = 1;
    double x14 = 2;
    double y14 = 0;
    assertTrue(question.isIntersect(x11, y11, x12, y12, x13, y13, x14, y14));
    
    double x21 = 0.5;
    double y21 = 0.5;
    double x22 = 2;
    double y22 = 2;
    double x23 = 0;
    double y23 = 1;
    double x24 = 2;
    double y24 = 1;
    assertTrue(question.isIntersect(x21, y21, x22, y22, x23, y23, x24, y24));
  }

  @Override
  @Test
  public void testNegCase() {
    double x11 = 1;
    double y11 = 1;
    double x12 = 2;
    double y12 = 2;
    double x13 = 0;
    double y13 = 1;
    double x14 = 2;
    double y14 = 0;
    assertFalse(question.isIntersect(x11, y11, x12, y12, x13, y13, x14, y14));
    
    double x21 = 1;
    double y21 = 1;
    double x22 = 2;
    double y22 = 2;
    double x23 = 0;
    double y23 = 1;
    double x24 = 1;
    double y24 = 1;
    assertFalse(question.isIntersect(x21, y21, x22, y22, x23, y23, x24, y24));
  }

}
