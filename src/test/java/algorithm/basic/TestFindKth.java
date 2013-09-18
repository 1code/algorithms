package algorithm.basic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestFindKth {
  
  @Test
  public void testFindKth() {
    Random rnd = new Random();
    FindKth kth = new FindKth();
    for (int cases = 0; cases < 1; ++cases) {
      int k = rnd.nextInt(10) + 1;
      int[] arr = new int[10];
      for (int i = 0; i < arr.length; ++i) {
        arr[i] = rnd.nextInt(10);
      }
      int[] copy = Arrays.copyOf(arr, arr.length);
      int val = kth.findKth(copy, k);
      Arrays.sort(arr);
      int expected = arr[k];
      assertEquals(expected, val);
    }
  }

}
