package algorithm.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestHashMap {
  
  @Test
  public void testHashMap() {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(100, 200);
    map.put(200, 300);
    assertEquals(200, map.get(100).intValue());
    assertEquals(300, map.get(200).intValue());
    assertTrue(map.containsKey(100));
    assertTrue(map.containsKey(200));
    map.put(100, 3);
    assertEquals(3, map.get(100).intValue());
    map.put(100, 5);
    assertEquals(5, map.get(100).intValue());
    
  }

}
