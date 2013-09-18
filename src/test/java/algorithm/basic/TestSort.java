package algorithm.basic;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestSort {
  
  @Test
  public void testSort() {
//    testSorter(new BubbleSort());
//    testSorter(new InsertionSort());
//    testSorter(new SelectionSort());
    testSorter(new QuickSortRecursive());
  }
  
  public void testSorter(Sort sorter) {
    Random rnd = new Random();
    for (int cases = 0; cases < 1000; ++cases) {
      int[] rndArr = new int[1000];
      for (int j = 0; j < rndArr.length; ++j) {
        rndArr[j] = rnd.nextInt(1000);
      }
      int[] copy = Arrays.copyOf(rndArr, rndArr.length);
      sorter.sort(copy);
      Arrays.sort(rndArr);
      assertArrayEquals(copy, rndArr);
    }
  }

}
