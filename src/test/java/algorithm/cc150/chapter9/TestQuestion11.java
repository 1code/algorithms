package algorithm.cc150.chapter9;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given a boolean expression consisting of the symbols 0, 1, &, |, and ^, and a
 * desired boolean result value result, implement a function to count the number
 * of ways of parenthesizing the expression such that it evaluates to result.
 * 
 * EXAMPLE
 * Expression: 1^0|0|1
 * Desired result: false (0)
 * Output: 2 ways. 1^((0|0)|1) and 1^(0|(0|1))
 * 
 */
public class TestQuestion11 extends TestBase {

  private Question11 question;
  
  @Override
  protected void initInstance() {
    question = new Question11();
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
