package algorithm.basic;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestSort {
  
  @Test
  public void testSort() {
    testSorter(new BubbleSort());
    testSorter(new InsertionSort());
    testSorter(new SelectionSort());
  }
  
  public void testSorter(Sort sorter) {
    Random rnd = new Random();
    for (int cases = 0; cases < 10; ++cases) {
      int[] rndArr = new int[10000];
      for (int j = 0; j < rndArr.length; ++j) {
        rndArr[j] = rnd.nextInt(10000);
      }
      int[] copy = Arrays.copyOf(rndArr, rndArr.length);
      sorter.sort(copy);
      Arrays.sort(rndArr);
      assertArrayEquals(copy, rndArr);
    }
  }

}
