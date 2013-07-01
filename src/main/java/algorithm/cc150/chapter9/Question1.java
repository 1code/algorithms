package algorithm.cc150.chapter9;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2
 * steps or 3 steps at a time. Implement a method to count how many possible
 * ways the child can run up the stairs.
 * 
 */
public class Question1 {

  public long numOfWays(int numOfStairs) {
    // write the implement here

    if (numOfStairs == 0) {
      return 0;
    }
    if (numOfStairs == 1) {
      return 1;
    }
    if (numOfStairs == 2) {
      return 2;
    }

    long[] stairs = new long[numOfStairs];
    stairs[0] = 1;
    stairs[1] = 2;
    stairs[2] = 3;

    for (int i = 3; i < numOfStairs; ++i) {
      stairs[i] = stairs[i - 1] + stairs[i - 2] + stairs[i - 3];
    }

    return stairs[numOfStairs - 1];
  }
}
