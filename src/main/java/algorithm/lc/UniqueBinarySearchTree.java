package algorithm.lc;

import java.util.Arrays;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *  1         3     3      2      1 
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3 
 *
 */
// O(n) space, O(n) time
public class UniqueBinarySearchTree {
  
  public class Solution {
    // recursive plus DP
    public int numTrees(int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (n <= 1) {
        return 1;
      }
      int[] mem = new int[n];
      Arrays.fill(mem, -1);
      mem[0] = 1;
      mem[1] = 1;
      return count(n, mem);
    }
    
    private int count(int n, int[] mem) {
      int sum = 0;
      for (int i = 1; i <= n; ++i) {
        // use i as root
        if (mem[i - 1] == -1) {
          mem[i - 1] = count(i - 1, mem);
        }
        if (mem[n - i] == -1) {
          mem[n - 1] = count(n - i, mem);
        }
        sum += mem[i - 1] * mem[n - i];
      }
      return sum;
    }
  }

}
