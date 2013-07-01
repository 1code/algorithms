package algorithm.cc150.chapter5;

/**
 * Given a positive integer, print the next smallest and the next largest number
 * that have the same number of 1 bits in their binary representation.
 * 
 */
public class Question3 {

  public int nextSmallest(int num) {
    int numOf1 = 0;
    int copy = num;
    // count the number of 1 for num
    while (copy > 0) {
      ++numOf1;
      copy &= copy - 1;
    }

    // decrease num until find a number has the same 1 as num
    int n = num;
    while (true) {
      --n;
      if (n < 0)
        return -1; // return -1 to indicate no such number exists
      copy = n;
      int numOf1Smaller = 0;
      while (copy != 0) {
        ++numOf1Smaller;
        copy &= copy - 1;
      }
      if (numOf1Smaller == numOf1)
        return n;
    }
  }

  public int nextLargest(int num) {
    int numOf1 = 0;
    int copy = num;
    // count the number of 1 for num
    while (copy > 0) {
      ++numOf1;
      copy &= copy - 1;
    }

    // decrease num until find a number has the same 1 as num
    int n = num;
    while (true) {
      ++n;
      copy = n;
      int numOf1Smaller = 0;
      while (copy != 0) {
        ++numOf1Smaller;
        copy &= copy - 1;
      }
      if (numOf1Smaller == numOf1)
        return n;
    }
  }

}
