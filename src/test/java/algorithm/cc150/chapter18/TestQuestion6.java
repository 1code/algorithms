package algorithm.cc150.chapter18;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import algorithm.TestBase;

/**
 * Describe an algorithm to find the smallest one million numbers in one billion
 * numbers. Assume that the computer memory CANNOT hold all one billion numbers.
 * 
 */
public class TestQuestion6 extends TestBase {

  private Question6 question;

  @Override
  protected void initInstance() {
    question = new Question6();
  }

  @Override
  @Test
  public void testPosCase() {
    Random rnd = new Random();
    int k = 10000;
    for (int c = 0; c < 10; ++c) {
      int len = rnd.nextInt(1000000 - k) + k + 1;
      int[] arr = new int[len];
      for (int i = 0; i < arr.length; ++i) {
        arr[i] = rnd.nextInt();
      }
      int[] result = question.firstK(arr, k);
      Arrays.sort(result);
      Arrays.sort(arr);
      int[] firstK = Arrays.copyOf(arr, k);
      assertArrayEquals(firstK, result);
    }
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative cases
  }

}
