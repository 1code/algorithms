package algorithm.basic;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestSort {
  
  @Test
  public void testSort() {
    testSorter(new BubbleSort());
    testSorter(new InsertionSort());
    testSorter(new SelectionSort());
    testSorter(new QuickSortRecursive());
    testSorter(new QuickSortIterative());
  }
  
  public void testSorter(Sort sorter) {
    Random rnd = new Random();
    for (int cases = 0; cases < 100; ++cases) {
      int[] rndArr = new int[1000];
      for (int j = 0; j < rndArr.length; ++j) {
        rndArr[j] = rnd.nextInt(100);
      }
      int[] copy = Arrays.copyOf(rndArr, rndArr.length);
      sorter.sort(copy);
      Arrays.sort(rndArr);
      assertArrayEquals(copy, rndArr);
    }
  }

}
