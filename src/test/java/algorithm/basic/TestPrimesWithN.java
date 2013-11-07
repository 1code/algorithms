package algorithm.basic;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestPrimesWithN {
  
  @Test
  public void testPrimesWithN() {
    PrimesWithInN primes = new PrimesWithInN();
    
    int n = 10;
    assertArrayEquals(new Integer[] {2,3,5,7}, primes.primes(n).toArray());
  }

}
