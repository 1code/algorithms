package algorithm.imagong;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.TestBase;

public class TestGenerateReversePolish extends TestBase {

  private GenerateReversePolish.Solution generator;
  
  @Override
  protected void initInstance() {
    generator = new GenerateReversePolish.Solution();
  }

  @Override
  @Test
  public void testPosCase() {
    char[][] samples = {
        "1+2-3*4".toCharArray(),
        "1+(2+3)/4".toCharArray(),
        "1*((2/1)+3*4-5)".toCharArray()
    };
    
    String[] res = {"1234*-+", "123+4/+", "121/34*5-+*"};
    
    for (int i = 0; i < samples.length; ++i) {
      assertEquals(res[i], generator.genRPNotation(samples[i]));
    }
  }

  @Override
  @Test
  public void testNegCase() {
    
  }

}
