package algorithm.basic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestUnionFind {
  
  @Test
  public void testUnionFind() {
    int size = 10;
    UnionFind uf = new UnionFind(size);
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        if (i == j) {
          assertTrue(uf.connected(i, j));
        }
        else {
          assertFalse(uf.connected(i, j));
        }
      }
    }
    uf.union(1, 5);
    assertTrue(uf.connected(1, 5));
    
    uf.union(2, 5);
    assertTrue(uf.connected(2, 5));
    assertTrue(uf.connected(1, 2));
    
    uf.union(4, 8);
    assertTrue(uf.connected(4, 8));
    assertFalse(uf.connected(4, 5));
    assertFalse(uf.connected(5, 8));
    assertFalse(uf.connected(1, 8));
    
    uf.union(1, 8);
    assertTrue(uf.connected(1, 8));
    assertTrue(uf.connected(4, 1));
    assertTrue(uf.connected(5, 8));
  }

}
