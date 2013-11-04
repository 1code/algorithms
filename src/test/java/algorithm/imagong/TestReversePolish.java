package algorithm.imagong;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

public class TestReversePolish extends TestBase {

  @Override
  protected void initInstance() {
    // TODO Auto-generated method stub
    
  }

  @Override
  @Test
  public void testPosCase() {
    char[][] sample = {
      {'1', '1', '2', '+', '-'},
      {'5', '8', '4', '/', '+'},
      {'a', 'b', '+'},
    };
    
    double[] res = {-2, 7, 99};
    
    ReversePolish.Solution sol = new ReversePolish.Solution();
    
    for (int i = 0; i < sample.length; ++i) {
      assertEquals(res[i], sol.calculateRPNotation(sample[i]), 0.000001);
    }
  }

  @Override
  @Test
  public void testNegCase() {
  }

}
