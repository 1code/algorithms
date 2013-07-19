package algorithm.cc150.chapter18;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import algorithm.TestBase;

/**
 * Imagine you have a square matrix, where each cell (pixel) is either black or
 * white. Design an algorithm to find the maximum subsquare such that all four
 * borders are filled with black pixels.
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
    String[] mat1 = {
      "bbbbbbbbb",
      "bbbbbbbbb",
      "bbbbbbbbb",
      "bbbbbbbbb",
      "bbbbbbbbb",
      "bbbbbbbbb",
      "bbbbbbbbb",
      "bbbbbbbbb",
      "bbbbbbbbb"
    };
    
    int[] results1 = {0, 0, 8, 8};
    assertArrayEquals(results1, question.maximumSubSquare(mat1));
    
    String[] mat2 = {
      "wwwwwwww",
      "wwwwwwww",
      "wwwwwwww",
      "bwwwwwww",
      "wwwwwwww",
      "wwwwwwww",
      "wwwwwwww",
      "wwwwwwww"
    };
    
    int[] results2 = {0, 3, 0, 3};
    assertArrayEquals(results2, question.maximumSubSquare(mat2));
    
    String[] mat3 = {
        "bwwbbbbw",
        "wwwbwwbw",
        "wwwbwwbw",
        "bwwbbbbw",
        "wwwwwwbw",
        "wwwwwwww",
        "wwwwwwww",
        "wwwwwwww"
      };
    
    int[] results3 = {0, 3, 3, 6};
    assertArrayEquals(results3, question.maximumSubSquare(mat3));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
