package algorithm.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Open hash map.
 * Collion is resolved by list. 
 *
 */
public class OpenAddressHashMap<K extends Comparable<K>, V> {
  
  private class Entry<K, V> {
    private K key;
    private V val;
    
    public Entry(K key, V val) {
      this.key = key;
      this.val = val;
    }
  }
  
  private List<Entry<K, V>>[] array;
  private int capacity = 100;
  
  public OpenAddressHashMap(int capacity) {
    if (capacity > this.capacity) {
      this.capacity = capacity;
    }
    this.array = new ArrayList[capacity];
  }
  
  public OpenAddressHashMap() {
    this(100);
  }

  /**
   * Insert the value by key.
   * @param key
   * @param val
   */
  public void put(K key, V val) {
    int idx = hash(key) % capacity;
    if (array[idx] == null) {
      array[idx] = new ArrayList<Entry<K, V>>();
      array[idx].add(new Entry<K, V>(key, val));
    }
    else {
      for (Entry<K, V> entry : array[idx]) {
        if (entry.key.equals(key)) {
          entry.val = val; // update existing
          return;
        }
      }
      array[idx].add(new Entry<K, V>(key, val)); // append to tail
    }
    
  }
  
  /**
   * Get the value by key.
   * @param key
   * @return
   */
  public V get(K key) {
    int idx = hash(key) % capacity;
    List<Entry<K, V>> list = array[idx];
    if (list == null) { // no entry
      return null;
    }
    for (Entry<K, V> entry : list) {
      if (entry.key.equals(key)) {
        return entry.val;
      }
    }
    
    return null;
  }
  
  /**
   * Look up whether the key is contained.
   * @param key
   * @return
   */
  public boolean containsKey(K key) {
    int idx = hash(key) % capacity;
    List<Entry<K, V>> list = array[idx];
    if (list == null) {
      return false;
    }
    for (Entry<K, V> entry : list) {
      if (entry.key.equals(key)) {
        return true;
      }
    }
    return false;
  }
  
  private int hash(K key) {
    return key.hashCode();
  }
  
}
