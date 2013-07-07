package algorithm.cc150.chapter7;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import algorithm.TestBase;

/**
 * Given two squares on a two-dimensional plane, find a line that would cut
 * these two squares in half. Assume that the top and the bottom sides of the
 * square run parallel to the x-axis.
 * 
 */
public class TestQuestion5 extends TestBase {

  private Question5 question;

  @Override
  protected void initInstance() {
    question = new Question5();
  }

  @Override
  @Test
  public void testPosCase() {
    // y = 0
    double x11 = 0;
    double y11 = 1;
    double x12 = 1;
    double y12 = -1;
    double x13 = 2;
    double y13 = 1;
    double x14 = 3;
    double y14 = -1;
    double[] arr1 = new double[] {0};
    assertArrayEquals(arr1, question.cutInHalf(x11, y11, x12, y12, x13, y13, x14, y14), 0.00001);
    
    // x = 1;
    double x21 = 0;
    double y21 = 1;
    double x22 = 2;
    double y22 = 0;
    double x23 = 0;
    double y23 = 3;
    double x24 = 2;
    double y24 = 2;
    double[] arr2 = new double[] {1};
    assertArrayEquals(arr2, question.cutInHalf(x21, y21, x22, y22, x23, y23, x24, y24), 0.00001);
    
    // coincides
    double x31 = 0;
    double y31 = 1;
    double x32 = 1;
    double y32 = -1;
    double x33 = 0;
    double y33 = 1;
    double x34 = 1;
    double y34 = -1;
    double[] arr3 = new double[] {0.5, 0};
    assertArrayEquals(arr3, question.cutInHalf(x31, y31, x32, y32, x33, y33, x34, y34), 0.00001);
    
    // y = -0.5x - 1
    double x41 = 0;
    double y41 = -1;
    double x42 = 4;
    double y42 = -3;
    double x43 = 5;
    double y43 = -3.5;
    double x44 = 7;
    double y44 = -4.5;
    double[] arr4 = new double[] {-0.5, -1};
    assertArrayEquals(arr4, question.cutInHalf(x41, y41, x42, y42, x43, y43, x44, y44), 0.00001);
  }

  @Override
  @Test
  public void testNegCase() {

  }

}
