package algorithm.imagong;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;

public class TestValidParenthesis extends TestBase {

  private ValidParenthesis.Solution sol;
  
  @Override
  protected void initInstance() {
    sol = new ValidParenthesis.Solution(); 
  }

  @Override
  @Test
  public void testPosCase() {
    String[] samples = {"{{}}[]()({})", "{[()]}{}((()))", "()([]){[]()}"};
    
    for (String str : samples) {
      assertTrue(sol.isBracketValid(str));
    }
  }
  
  @Override
  @Test
  public void testNegCase() {
    String[] samples = {"()()()())))(", "{}{{}()", ")(", "[]][[()){()]()", "()}}{()}{)"};
    for (String str : samples) {
      assertFalse(sol.isBracketValid(str));
    }
  }
  
}
