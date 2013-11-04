package algorithm.imagong;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

public class TestReversePolish extends TestBase {

  private ReversePolish.Solution sol;
  @Override
  protected void initInstance() {
    sol = new ReversePolish.Solution();
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
    
    for (int i = 0; i < sample.length; ++i) {
      assertEquals(res[i], sol.calculateRPNotation(sample[i]), 0.000001);
    }
  }

  @Override
  @Test
  public void testNegCase() {
  }

}
