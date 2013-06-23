package algorithm.cc150.chapter9;

import org.junit.Test;

import algorithm.TestBase;

/**
 * You have a stack of n boxes, with widths w_i, heights h_i and depths d_i. The
 * boxes cannot be rotated and can only be stacked on top of one another if each
 * box in the stack is strictly larger than the box above it in width, height,
 * and depth. Implement a method to build the tallest stack possible, where the
 * height of a stack is the sum of the heights of each box.
 * 
 */
public class TestQuesiton10 extends TestBase {
  
  private Question10 question;

  @Override
  protected void initInstance() {
    question = new Question10();
  }

  @Override
  @Test
  public void testPosCase() {
    // TODO Auto-generated method stub
    
  }

  @Override
  @Test
  public void testNegCase() {
    // TODO Auto-generated method stub
    
  }

}
