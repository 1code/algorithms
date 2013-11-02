package algorithm.basic;

import java.util.Random;

import org.junit.Test;

public class TestFindKth {
  
  @Test
  public void testFindKth() {
    FindKth kth = new FindKth();
    
    int[] num = {0, 1, 2, 4, 6, 5, 3, 10, 20};
    int idx = num.length / 2;
//    assertEquals(4, kth.findKth(num, idx));
    
    FindKth.median(num, 0, num.length - 1, idx);
    
    Random rnd = new Random();
    
//    for (int cases = 0; cases < 1; ++cases) {
//      int k = rnd.nextInt(10) + 1;
//      int[] arr = new int[10];
//      for (int i = 0; i < arr.length; ++i) {
//        arr[i] = rnd.nextInt(10);
//      }
//      int[] copy = Arrays.copyOf(arr, arr.length);
//      int val = kth.findKth(copy, k);
//      Arrays.sort(arr);
//      int expected = arr[k];
//      assertEquals(expected, val);
//    }
  }

}
