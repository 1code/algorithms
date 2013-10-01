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

  // O(1) space, O(n^2) time
  public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      // Note: The Solution object is instantiated only once and is reused by
      // each test case.
      int start = -1;

      for (int i = 0; i < gas.length; ++i) {
        start = solve(i, gas, cost);
        if (start != -1) {
          break;
        }
      }
      return start;
    }

    private int solve(int i, int[] gas, int[] cost) {
      int remain = gas[i]; // add initial gas
      int curIdx = i;
      do {
        remain -= cost[curIdx]; // use gas
        if (remain < 0) {
          return -1;
        }
        ++curIdx;
        if (curIdx == gas.length) {
          curIdx = 0;
        }
        remain += gas[curIdx];
      } while (curIdx != i);
      return i;
    }
  }

}
