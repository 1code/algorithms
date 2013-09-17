package algorithm.basic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestBinarySearch {
  
  @Test
  public void testBinarySearch() {
    BinarySearch bs = new BinarySearch();
    Random rnd = new Random();
    for (int cases = 0; cases < 1000; ++cases) {
      int[] arr = new int[10000];
      for (int i = 0; i < arr.length; ++i) {
        arr[i] = rnd.nextInt(10000);
      }
      Arrays.sort(arr);
      
      int target = rnd.nextInt(10000);
      int idx = bs.binarySearch(arr, target);
      int expected = Arrays.binarySearch(arr, target);
      assertEquals(expected, idx);
    }
  }

}
