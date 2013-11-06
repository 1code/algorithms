package algorithm.basic;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestSubarrayWithSumZero {
  
  @Test
  public void testSubarrayWithSumZero() {
    SubarrayWithSumZero sum = new SubarrayWithSumZero();
    
    int[] arr1 = {-3, 2, 4, -6, -8, 10, 11};
    assertArrayEquals(new int[]{2, 4, -6}, sum.sumZero(arr1));
    
    int[] arr2 = {-3, 2, 1, 5, 1, -3};
    assertArrayEquals(new int[]{-3, 2, 1}, sum.sumZero(arr2));
    
    int[] arr3 = {-3, 2, -10, 5, 5};
    assertArrayEquals(new int[]{-10, 5, 5}, sum.sumZero(arr3));
  }
}
