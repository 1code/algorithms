package algorithm.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A data structure that support O(1) add, delete and get random. 
 *
 */
public class ConstantTimeDS {
  
  private Map<Integer, Integer> index;
  private List<Integer> array;
  private int size;
  private Random rnd;
  
  public ConstantTimeDS() {
    index = new HashMap<Integer, Integer>();
    array = new ArrayList<Integer>();
    size = 0;
    rnd = new Random();
  }
  
  /**
   * Add a value with O(1)
   * @param val
   */
  public void add(int val) {
    Integer idx = index.get(val);
    if (idx == null) {
      index.put(val, size++);
      if (size < array.size()) {
        array.set(size, val);
      }
      else {
        array.add(val);
      }
    }
  }
  
  /**
   * Delete a value with O(1)
   * @param val
   */
  public void del(int val) {
    Integer idx = index.get(val);
    if (idx == null) {
      return;
    }
    int lastVal = array.get(array.size() - 1);
    array.set(idx, lastVal);
    index.put(lastVal, idx); // update index
    index.remove(val); // remove deleted val from array
    --size;
  }
  
  /**
   * Get a random number in O(1)
   * @return
   */
  public int getRandom() {
    if (size == 0) {
      return -1;
    }
    int idx = rnd.nextInt(size);
    return array.get(idx);
  }

}
