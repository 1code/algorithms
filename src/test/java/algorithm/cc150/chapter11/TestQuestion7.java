package algorithm.cc150.chapter11;

import org.junit.Test;

import algorithm.TestBase;

/**
 * A circus is designing a tower routine consisting of people standing atop one
 * another's shoulders. For practical and aesthetic reasons, each person must be
 * both shorter and lighter than the person below him or her. Given the heights
 * and weights of each person in the circus, write a method to compute the
 * largest possible number of people in such a tower.
 * 
 * EXAMPLE:
 * Input (ht, wt): (65, 200) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * Output: The longest tower is length 6 and includes from top to bottom:
 * (56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 190)
 * 
 */
public class TestQuestion7 extends TestBase {

  private Question7 question;
  
  @Override
  protected void initInstance() {
    question = new Question7();
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
