package algorithm.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumZero {
  
  public int[] sumZero(int[] array) {
    if (array.length == 0) {
      return new int[0];
    }
    
    int[] b = new int[array.length];
    b[0] = array[0];
    for (int i = 1; i < b.length; ++i) {
      b[i] = b[i - 1] + array[i];
      if (b[i] == 0) {
        return Arrays.copyOfRange(array, 0, i + 1);
      }
    }
    Map<Integer, Integer> index = new HashMap<Integer, Integer>(); // key is the sum, value is the index
    for (int i = 0; i < b.length; ++i) {
      int key = b[i];
      Integer idx = index.get(key);
      if (idx != null && idx < i) {
        int start = idx + 1;
        int end = i;
        return Arrays.copyOfRange(array, start, end + 1);
      }
      index.put(b[i], i);
    }
    
    return new int[0];
  }

}
