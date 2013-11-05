package algorithm.lc;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 * 
 */
public class GasStation {

  // O(1) space, O(n) time
  public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      // Note: The Solution object is instantiated only once and is reused by
      // each test case.
      int start = 0, total = 0, remain = 0;

      for (int i = 0; i < gas.length; ++i) {
        remain += gas[i] - cost[i];
        total += gas[i] - cost[i];
        if (remain < 0) {
          start = i + 1; // i cannot reach to i + 1
          remain = 0;
        }
      }
      return total < 0? -1 : start;
    }
  }

}
